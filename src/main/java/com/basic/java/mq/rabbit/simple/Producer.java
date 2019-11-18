package com.basic.java.mq.rabbit.simple;

import com.basic.java.mq.rabbit.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * MQ 生产者
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\17 0017 17:25
 */
public class Producer {
    public static final String QUEUE_NAME = "rabbit_simple_queue";
    public static void main(String[] args){
        try(
            /**获取mq连接*/
            Connection connection = RabbitMqUtils.getConnetion();
            /**从连接中获取一个通道*/
            Channel ch = connection.createChannel();
        ) {
            /**创建队列声明*/
            ch.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello,World!";
            /**发布消息接口*/
            ch.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("---send message:" + message + "---");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
