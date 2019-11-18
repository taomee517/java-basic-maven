package com.basic.java.db.redis.mq.ps_future;

import com.basic.java.db.redis.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 订阅者
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\3\5 0005 21:46
 */
public class ShardSubscriber implements Runnable {
    public static final String CONCERN_TOPIC = "upgrade:shardIndex";
    private int totalShard;
    private int currShard;
    private String msg;

    public void subscribe(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.psubscribe(new JedisPubSub() {
            @Override
            public void onPMessage(String pattern, String channel, String message) {
                System.out.println(message);
                String[] values = message.split("\\/");
                currShard = Integer.valueOf(values[0]);
                totalShard = Integer.valueOf(values[1]);
            }
        }, CONCERN_TOPIC);
    }

    @Override
    public void run() {
       subscribe();
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(new ShardSubscriber());
//        try {
//           String msg = task.get(5,TimeUnit.SECONDS);
//           if(StringUtils.isNoneBlank(msg)){
//               System.out.println(msg);
//           }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            System.out.println("超时事件！");
//        }
    }
}
