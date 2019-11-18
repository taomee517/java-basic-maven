package com.basic.java.mq.rabbit.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMq连接工具类
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\17 0017 17:17
 */
public class RabbitMqUtils {
    /**获取rabbitMq连接*/
    public static Connection getConnetion() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        /**类似于数据库*/
        factory.setVirtualHost("/1st_vhost");
        factory.setUsername("taomee");
        factory.setPassword("123456");
        return factory.newConnection();
    }
}
