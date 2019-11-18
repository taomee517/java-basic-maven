package com.basic.java.db.redis.mq.ps_future;

import com.basic.java.db.redis.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 消息发布方，内容为分片信息
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\3\5 0005 21:27
 */
public class ShardPublisher {
    private int totalShard = 10;
    private int index = 0;

    public int getTotalShard() {
        return totalShard;
    }

    public void setTotalShard(int totalShard) {
        this.totalShard = totalShard;
    }

    public void publish(){
        ShardPublisher.Task task = new ShardPublisher.Task();
        ExecutorService schedule = Executors.newScheduledThreadPool(1);
        ((ScheduledExecutorService) schedule).scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }

    class Task implements Runnable {
        private Jedis jedis = JedisPoolUtils.getJedis();
        private String key = "upgrade:shardIndex";

        @Override
        public void run() {
            index++;
            String msg = index + "/" + totalShard;
            jedis.publish(key, msg);
            if(index == totalShard){
                System.exit(0);
            }
        }
    }
}

