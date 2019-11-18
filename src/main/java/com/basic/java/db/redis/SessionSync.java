package com.basic.java.db.redis;

import redis.clients.jedis.Jedis;

import java.util.Comparator;
import java.util.Map;

public class SessionSync {

    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtils.getJedis();
        String entityId = "1773";
        jedis.hset(entityId,"1234","channel-1");
        jedis.hset(entityId,"2984","channel-2");
        Map<String,String> channels = jedis.hgetAll("1773");
        if (channels.keySet().size()>1) {
            String time = channels.keySet().stream().min(Comparator.comparing(String::trim)).get();
            String channel = jedis.hget(entityId,time);
            System.out.println(channel);
        }

//        for(String key:channels.keySet()){
//            int time = Integer.valueOf(key);
//            if(){
//
//            }
//        }
    }
}
