package com.basic.java.mq.kafka.producer;

import com.basic.java.mq.kafka.constants.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Objects;
import java.util.Properties;

@Slf4j
public class SimpleProducer {
    public static final String TOPIC = "demo";

    /**
     * kafka命令行订阅主题：
     *  kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --from-beginning --topic demo
     * @param args
     */
    public static void main(String[] args) {
        //创建配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.BOOTSTRAP_SERVER);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        //创建生产者
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);

        //发送数据
        String message = "hello,kafka!";
        ProducerRecord record = new ProducerRecord(TOPIC, message);
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (Objects.isNull(e)) {
                    log.info("消息头信息： partition = {}, offset = {}", recordMetadata.partition(), recordMetadata.offset());
                    log.info("消息发送成功！ topic = {}, msg = {}", TOPIC, message);
                } else {
                    log.error("消息发送失败！ e = {}", e);
                }
            }
        });

        //如果没有指定分区，kafka会根据key的hash值去计算出数据存到哪个分区
        producer.send(new ProducerRecord<>(TOPIC, 0, "hashKey", "hashValue"));

        //关闭资源
        producer.close();

    }
}
