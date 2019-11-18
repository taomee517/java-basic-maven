package com.basic.java.db.redis.mq.publisher_subscriber;

import com.alibaba.fastjson.JSON;
import com.basic.java.db.redis.JedisPoolUtils;
import com.basic.java.db.redis.mq.pojo.KeyUtils;
import com.basic.java.db.redis.mq.pojo.ResultEnum;
import com.basic.java.db.redis.mq.pojo.UpgradeTask;
import redis.clients.jedis.Jedis;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 10:58
 */
public class MessagePublisher {
    private volatile int count;

    public void publishMessage(String channelKey,UpgradeTask task){
        Jedis jedis = JedisPoolUtils.getJedis();
        try {
            count++;
            String taskJson = JSON.toJSONString(task);
            Long subscriberSize = jedis.publish(channelKey,taskJson);
            System.out.println(Thread.currentThread().getName() + " put message,count=" + count +",subscriberNum=" + subscriberSize);
            String currShardKey = KeyUtils.generateKey("currShard",task.getId(),task.getProd());
            jedis.set(currShardKey,String.valueOf(task.getCurrShard()));
            jedis.expire(currShardKey,10);

        } finally {
            jedis.close();
        }
    }

    public static String generateKey(String topic,int id,String prod){
        return topic + ":" + id + ":" + prod;
    }

    public UpgradeTask shardIncs(UpgradeTask task){
        task.setCurrShard(task.getCurrShard()+1);
        return task;
    }

    public static void main(String[] args) {
        MessagePublisher publisher = new MessagePublisher();
        int initId = 8001;
        String initProd = "btu";
        int initTotalShard = 200;
        int index = 0;
        String key = generateKey("task",initId,initProd);
        UpgradeTask task = new UpgradeTask();
        task.setId(initId);
        task.setImei("864244022064702");
        task.setProd("btu");
        task.setResult(ResultEnum.UPGRATING);
        task.setRepeat(0);
        task.setVersion("otu.c3.103b.base.release.b1.05010302");
        task.setTotalShard(initTotalShard);
        Timer timer = new Timer();
        int total = task.getTotalShard();
        timer.schedule(new TimerTask() {
            int cnt = 0;
            @Override
            public void run() {
                if(cnt++<total) {
                    UpgradeTask pTask = publisher.shardIncs(task);
                    publisher.publishMessage(key, pTask);
                }else {
                    System.exit(0);
                }
            }
        },3000,3000);

    }

}

