package com.basic.java.db.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 8:15
 */
public class JedisPoolUtils {
    private static JedisPool pool = null;
    static {
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int maxIdle = Integer.valueOf(pro.getProperty("redis.maxIdle"));
        int maxWait = Integer.valueOf(pro.getProperty("redis.maxWait"));
        int minIdle = Integer.valueOf(pro.getProperty("redis.minIdle"));
        int maxTotal = Integer.valueOf(pro.getProperty("redis.maxTotal"));
        String host = pro.getProperty("redis.url");
        int port = Integer.valueOf(pro.getProperty("redis.port"));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setMinIdle(minIdle);
        config.setMaxTotal(maxTotal);
        pool = new JedisPool(config,host,port);
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtils.getJedis();
        if("PONG".equals(jedis.ping().toUpperCase())){
            System.out.println("连接成功！");
        }
    }
}
