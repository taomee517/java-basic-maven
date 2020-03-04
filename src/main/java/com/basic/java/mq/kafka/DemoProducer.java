package com.basic.java.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@Slf4j
public class DemoProducer {
    public static final String BOOTSTRAP_SERVER = "127.0.0.1:9092";
    public static final String TOPIC = "demo";

    /**
     * kafka命令行订阅主题：
     *  kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --from-beginning --topic demo
     * @param args
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);
        String message = "hello,kafka!";
        ProducerRecord record = new ProducerRecord(TOPIC, message);
        producer.send(record);
        log.info("消息发送成功！ topic = {}, msg = {}", TOPIC, message);
    }
}
