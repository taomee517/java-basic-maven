package com.basic.java.db.redis.pipeline;

import com.basic.java.util.JedisBuilder;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Objects;

public class PipelineDemo {
    private static volatile long main_end = 0;

    public static void main(String[] args) {
        String testKey = "DelayMessageQueue:865886034429940";
        Jedis jedis = JedisBuilder.instance().getJedis();
        for(int i=0;i<100;i++){
            jedis.lpush(testKey, String.valueOf(i));
        }

        DefaultPromise<Object> resultFuture = new DefaultPromise<>(new DefaultEventLoop());
        MyPipeline mp = new MyPipeline(jedis, new ICallback() {
            @Override
            public Object call(Object obj) {
                resultFuture.setSuccess(obj);
                return obj;
            }
        });
        mp.lrange(testKey);
        resultFuture.addListener(new GenericFutureListener<Future<? super Object>>() {
            @Override
            public void operationComplete(Future<? super Object> future) throws Exception {
                Object result = future.get();
                if(Objects.nonNull(result)){
                    List<String> msgs = ((List<String>) result);
                    long now = System.currentTimeMillis();
                    long offset = now - main_end;
                    System.out.println("收到结果：time = " + now + ", size = " + msgs.size() + ", offset = " + offset);
                    mp.close();
                }
            }
        });
        main_end = System.currentTimeMillis();
        System.out.println("主线程执行结束！ end = " + main_end);
    }
}
