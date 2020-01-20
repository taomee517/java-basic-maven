package com.basic.java.db.redis;

import com.basic.java.util.JedisBuilder;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

@Slf4j
public class RedisPipelineDemo {
    public static void main(String[] args) {
        Jedis jedis = JedisBuilder.instance().getJedis();
        Pipeline pipeline = JedisBuilder.instance().getPipeline(jedis);

//        Pipeline pipeline = new Pipeline();
//        pipeline.setClient(JedisBuilder.instance().getJedis().getClient());

        try {
            long start = System.currentTimeMillis();
            for (int i=0;i<10000;i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("IMEI#");
                sb.append(i);

//                pipeline.set(sb.toString(),"demo");
//                jedis.set(sb.toString(),"demo");
            }
            long end = System.currentTimeMillis();
            long offset = end - start;
            log.info("pipeline批量设置耗时：{}", offset);
        } finally {
            jedis.close();
        }

    }

}
