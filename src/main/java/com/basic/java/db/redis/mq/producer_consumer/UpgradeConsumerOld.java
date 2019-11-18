package com.basic.java.db.redis.mq.producer_consumer;

import com.alibaba.fastjson.JSON;
import com.basic.java.db.redis.mq.pojo.UpgradeTask;
import com.basic.java.db.redis.JedisPoolUtils;
import redis.clients.jedis.Jedis;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 9:05
 */
public class UpgradeConsumerOld implements Runnable {
    public static final String UPGRADE_TASK_KEY ="upgrade:queue";
    private volatile int count;

    public void taskConsume(){
        Jedis jedis = JedisPoolUtils.getJedis();
        try {
            String taskJson = jedis.rpop(UPGRADE_TASK_KEY);
            UpgradeTask task = JSON.parseObject(taskJson,UpgradeTask.class);
            if(task!=null) {
                String imei = task.getImei();
                System.out.println(imei);
            }else{
                System.out.println("队列已消费完");
                System.exit(0);
            }
        } finally {
            jedis.close();
        }
    }

    @Override
    public void run() {
        while (true) {
            taskConsume();
        }
    }

    public static void main(String[] args) {
        UpgradeConsumerOld consumer = new UpgradeConsumerOld();
        Thread t1 = new Thread(consumer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
