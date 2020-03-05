package com.basic.java.mq.kafka.producer;

import com.basic.java.mq.kafka.config.DemoPartitioner;
import com.basic.java.mq.kafka.constants.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Objects;
import java.util.Properties;

@Slf4j
public class PartitionProducer {
    public static void main(String[] args) {
        //创建配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.BOOTSTRAP_SERVER);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, DemoPartitioner.class);

        //创建生产者
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);

        //发送消息
        String topic = "demo";
        ProducerRecord record = new ProducerRecord(topic, "partition producer");
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(Objects.isNull(e)){
                    log.info("消息头信息： partition = {}, offset = {}", recordMetadata.partition(), recordMetadata.offset());
                    log.info("消息发送成功！ topic = {}, msg = {}", topic, record.value());
                } else {
                    log.error("消息发送失败！ e = {}", e);
                }
            }
        });

        //关闭资源
        producer.close();
    }
}
