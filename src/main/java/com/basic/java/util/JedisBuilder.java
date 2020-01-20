package com.basic.java.util;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

@Slf4j
public class JedisBuilder {
    private static final String REDIS_IP = "127.0.0.1";
    private static final int REDIS_PORT = 6379;
    private static final int REDIS_DATABASE = 15;

    private static JedisPool jedisPool;

    private static class SingletonHolder {
        public final static JedisBuilder instance = new JedisBuilder();
    }

    public static JedisBuilder instance() {
        return JedisBuilder.SingletonHolder.instance;
    }

    private JedisBuilder(){

    }

    public Jedis getJedis(){
        Jedis jedis = new Jedis(REDIS_IP,REDIS_PORT);
        jedis.select(REDIS_DATABASE);
        return jedis;
    }

    public synchronized Pipeline getPipeline(Jedis jedis){
        return jedis.pipelined();
    }
}
