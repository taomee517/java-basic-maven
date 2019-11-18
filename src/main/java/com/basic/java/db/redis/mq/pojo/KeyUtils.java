package com.basic.java.db.redis.mq.pojo;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 14:12
 */
public class KeyUtils {
    public static String generateKey(String topic,int id,String prod){
        return topic + ":" + id + ":" + prod;
    }

    public static String generateThreadName(String topic,int id,String prod,int curr){
        return topic + "_" + id + "_" + prod + "_" + curr;
    }
}
