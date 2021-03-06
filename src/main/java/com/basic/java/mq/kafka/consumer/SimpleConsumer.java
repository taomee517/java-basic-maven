package com.basic.java.mq.kafka.consumer;

import com.basic.java.mq.kafka.constants.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class SimpleConsumer {
    public static void main(String[] args) {
        String groupId = "simple-consumer-group";

        //1. 创建消费者配置
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.BOOTSTRAP_SERVER);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //重置消费者的offset-两种策略:（换组 或者 数据过期）
        // earliest 相当于--from-beginning
        // latest   相当于只拉最新的消息（默认配置）
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //2. 创建消费者对象
        KafkaConsumer consumer = new KafkaConsumer(properties);

        //3. 订阅主题
        consumer.subscribe(Collections.singleton("demo"));

        //4. 循环获取消息
        while (true) {
            ConsumerRecords records = consumer.poll(Duration.ofSeconds(5));
            if (Objects.nonNull(records)) {
                Iterator<ConsumerRecord> iterator = records.iterator();
                while (iterator.hasNext()){
                    ConsumerRecord record = iterator.next();
                    String msg = ((String) record.value());

                    long now = System.currentTimeMillis();
                    long offset = now - record.timestamp();
                    log.info("收到消息： topic = {}, msg = {}, offset = {}", record.topic(), msg, offset);
                }
            }
        }
    }
}
