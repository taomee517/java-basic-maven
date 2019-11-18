package com.basic.java.mq.rabbit.simple;

import com.basic.java.mq.rabbit.util.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * MQ 消费者
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\17 0017 17:36
 */
public class Consumer extends DefaultConsumer{
    public static final String QUEUE_NAME = "rabbit_simple_queue";

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String msg = new String(body,"UTF-8");
        System.out.println("收到消息：" + msg);
    }

    public Consumer(Channel channel) {
        super(channel);
    }

    public static void main(String[] args) {
        Connection connection = null;
        Channel channel = null;
        try{
            //创建连接
            connection = RabbitMqUtils.getConnetion();
            //获取通道
            channel = connection.createChannel() ;
            //声明队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //定义队列消费者
            com.rabbitmq.client.Consumer consumer = new Consumer(channel);
            //监听队列
            channel.basicConsume(QUEUE_NAME,true,consumer);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
