package com.basic.java.db.redis.mq.ps_future;

/**
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\3\5 0005 21:43
 */
public class TaskServer {
    public static void main(String[] args) {
        ShardPublisher publisher = new ShardPublisher();
        publisher.publish();
    }
}
