package com.basic.java.mq.kafka.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class DemoPartitioner implements Partitioner {

    /**
     * 几个参数分别代表的意义
     * @param s -> topic
     * @param o -> key
     * @param bytes -> keyBytes
     * @param o1 -> value
     * @param bytes1 -> valueBytes
     * @param cluster -> kafka cluster
     * @return
     */
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        Integer size = cluster.partitionCountForTopic(s);
        if(Objects.isNull(bytes)){
            bytes = UUID.randomUUID().toString().getBytes();
        }
        return bytes.hashCode()%size;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
