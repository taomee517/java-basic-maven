package com.basic.java.db.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/15
 * @time 16:06
 */
public class JedisDemo {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        Set<String> keys = jedis.keys("client*");
        System.out.println("遍历所有key:");
        for(String key:keys){
            System.out.println(key);
        }
//        String what = jedis.hget(generateKey("client",3,2539),"lastMsgTime");
//        System.out.println(what);
        Map<String,String> map = jedis.hgetAll(generateKey("client",3,1773));
        Set<String> clientKeys = map.keySet();
        for(String key:clientKeys){
            System.out.println("key:" + key + ",value:" + map.get(key));
        }
    }

    public static String generateKey(String topic,int clientType,int entityId){
        return topic + "_" + clientType +  "_" + entityId;
    }
}
