package com.basic.java.db.redis.mq.producer_consumer;

import com.alibaba.fastjson.JSON;
import com.basic.java.db.redis.mq.pojo.UpgradeTask;
import com.basic.java.db.redis.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 9:05
 */
public class UpgradeConsumer implements Runnable {
    public static final String UPGRADE_TASK_KEY ="upgrade:queue";
    private volatile int count;

    public void taskConsume(){
        Jedis jedis = JedisPoolUtils.getJedis();
        try {
            List<String> tasks = jedis.brpop(0,UPGRADE_TASK_KEY);
//        System.out.println(tasks);
            for (String taskJson : tasks) {
                if(UPGRADE_TASK_KEY.equals(taskJson)){
                    continue;
                }
                UpgradeTask task = JSON.parseObject(taskJson,UpgradeTask.class);
                System.out.println(task.getImei());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
        UpgradeConsumer consumer = new UpgradeConsumer();
        Thread t1 = new Thread(consumer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
