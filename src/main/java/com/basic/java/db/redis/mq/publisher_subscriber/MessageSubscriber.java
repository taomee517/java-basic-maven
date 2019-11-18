package com.basic.java.db.redis.mq.publisher_subscriber;

import com.alibaba.fastjson.JSONObject;
import com.basic.java.db.redis.JedisPoolUtils;
import com.basic.java.db.redis.mq.pojo.KeyUtils;
import com.basic.java.db.redis.mq.pojo.ThreadUtils;
import com.basic.java.db.redis.mq.pojo.UpgradeTask;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 11:37
 */
public class MessageSubscriber implements Runnable {
    public static final String CONCERN_KEY = "task?*";
    public volatile int count;
    private MessagePubSub msgPubSub = new MessagePubSub();

    public void subscribeMessage(String channelKey){
        Jedis jedis = JedisPoolUtils.getJedis();
        //第一个参数是处理接收消息，第二个参数是订阅的消息频道
        jedis.psubscribe(msgPubSub,CONCERN_KEY);
    }


    @Override
    public void run() {
        while (true){
            subscribeMessage(CONCERN_KEY);
        }
    }

    public static void main(String[] args) {
        MessageSubscriber ms = new MessageSubscriber();
        new Thread(ms).start();
    }
}
/**
 * 继承JedisPubSub，重写接收消息的方法
 */
class MessagePubSub extends JedisPubSub {
    /** JedisPubSub类是一个没有抽象方法的抽象类,里面方法都是一些空实现
     * 所以可以选择需要的方法覆盖,这儿使用的是SUBSCRIBE指令，所以覆盖了onMessage
     * 如果使用PSUBSCRIBE指令，则覆盖onPMessage方法
     * 当然也可以选择BinaryJedisPubSub,同样是抽象类，但方法参数为byte[]
     **/
    @Override
    public void onPMessage(String pattern,String channel, String message) {
        UpgradeTask task = JSONObject.parseObject(message, UpgradeTask.class);
        System.out.println(Thread.currentThread().getName() + "-接收到消息:channel=" + channel + ",imei=" + task.getImei() + "，currShard=" + task.getCurrShard());
        String threadName = KeyUtils.generateThreadName("thread", task.getId(), task.getProd(), task.getCurrShard());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Timer timer = new Timer();
                Jedis jedis = JedisPoolUtils.getJedis();
                String curr = jedis.get(KeyUtils.generateKey("currShard", task.getId(), task.getProd()));
                System.out.println(curr);
                MessagePublisher mp = new MessagePublisher();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (curr != null && !"".equals(curr)) {
                            int currShard = Integer.valueOf(curr);
                            if (task.getTotalShard() == currShard) {
                                String downLoadSucKey = "download_success:" + task.getId() + ":" + task.getProd();
                                mp.publishMessage(downLoadSucKey, task);
                                ThreadUtils.killThreads(pattern);
                            } else {
                                String postCurr = jedis.get(KeyUtils.generateKey("currShard", task.getId(), task.getProd()));
                                Boolean ee = postCurr != null && postCurr.equals(curr);
                                boolean ne = postCurr != null && !postCurr.equals(curr);
                                if (postCurr == null || "".equals(postCurr) || ee) {
                                    task.setReason("分片请求超时！");
                                    mp.publishMessage("updfail:" + task.getId() + ":" + task.getProd(), task);
                                } else if (ne) {
                                    String pattern = threadName.substring(0, threadName.lastIndexOf('_'));
                                    ThreadUtils.killLastThreads(pattern, currShard);
                                }
                            }
                        }
                    }
                }, 3000);
            }
        }, threadName).start();
    }
}
