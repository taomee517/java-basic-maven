package com.basic.java.db.redis.mq.producer_consumer;

import com.alibaba.fastjson.JSON;
import com.basic.java.db.redis.mq.pojo.ResultEnum;
import com.basic.java.db.redis.mq.pojo.UpgradeTask;
import com.basic.java.db.redis.JedisPoolUtils;
import redis.clients.jedis.Jedis;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 8:32
 */
public class UpgradeTaskProducer extends Thread {
    public static final String UPGRADE_TASK_KEY ="upgrade:queue";
    private volatile int count;

    public void putTask(UpgradeTask task){
        Jedis jedis = JedisPoolUtils.getJedis();
        try {
            String taskJson = JSON.toJSONString(task);
            Long size = jedis.lpush(UPGRADE_TASK_KEY,taskJson);
            System.out.println("put task,size=" + size + ",count=" + count);
            count++;
        } finally {
            jedis.close();
        }
    }

    public static void main(String[] args) {
        UpgradeTaskProducer producer = new UpgradeTaskProducer();
        int initId = 8000;
        long initImei = 864244022064702L;
        for(int i=0;i<50;i++){
            UpgradeTask task = new UpgradeTask();
            task.setId(initId + i);
            task.setImei(String.valueOf(initImei + i*3));
            task.setProd("otu");
            task.setResult(ResultEnum.NOT_STARTED);
            task.setRepeat(0);
            task.setVersion("otu.c3.103b.base.release.b1.05010302");
            producer.putTask(task);
        }
    }
}
