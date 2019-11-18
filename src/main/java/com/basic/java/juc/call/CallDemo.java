package com.basic.java.multithread.call;

import com.basic.java.db.redis.JedisPoolUtils;
import org.apache.commons.lang3.ObjectUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.*;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/3/5
 * @time 19:24
 */
public class CallDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Jedis jedis = JedisPoolUtils.getJedis();
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> task = pool.submit(new CallDemo());
        Integer value = task.get();
        if(ObjectUtils.allNotNull(value)){
            return value;
        }
        int data = Integer.valueOf(jedis.get("demo"));
        return data;

    }
}
