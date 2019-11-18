package com.basic.java.db.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/15
 * @time 16:31
 */
public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String queueName = "queue";
        for(int i=0;i<10;i++){
            int x = new Random().nextInt(10);
            jedis.lpush(queueName,String.valueOf(x));
        }
        int size = jedis.llen(queueName).intValue();
        for(int i=0;i<size;i++){
            int value = Integer.valueOf(jedis.lpop(queueName));
            if(value%2==0){
                jedis.rpush(queueName,String.valueOf(value));
            }else{
                System.out.println("奇数值：" + value);
            }
        }
        System.out.println("偶数值个数：" + jedis.llen(queueName).intValue());
        jedis.lrange(queueName,0,-1).stream().forEach(p-> System.out.print(p + "\t"));
    }
}
