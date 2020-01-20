package com.basic.java.db.redis.pipeline;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.List;

public class MyPipeline{
    private Jedis jedis;
    private Pipeline pipeline;
    private ICallback callback;

    public MyPipeline(Jedis jedis) {
        this.jedis = jedis;
        this.pipeline = jedis.pipelined();
    }

    public MyPipeline(Jedis jedis, ICallback callback) {
        this.jedis = jedis;
        this.pipeline = jedis.pipelined();
        this.callback = callback;
    }

    public void lrange(String key){
        Response<List<String>> resp = pipeline.lrange(key,0,-1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                pipeline.sync();
                callback.call(resp.get());
            }
        }).start();
    }

    public void close(){
        pipeline.close();
        jedis.close();
    }
}
