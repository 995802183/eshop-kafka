package com.wyw.eshop.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ConsumerWorker<K,V> implements Runnable {
    private Logger LOGGER = LoggerFactory.getLogger(ConsumerWorker.class);
    private final ConsumerRecords<K,V>records;
    private final Map<TopicPartition, OffsetAndMetadata> offsets ;

    public ConsumerWorker(ConsumerRecords<K, V> records, Map<TopicPartition, OffsetAndMetadata> offsets) {
        this.records = records;
        this.offsets = offsets;
    }

    @Override
    public void run() {
        for(TopicPartition partition : records.partitions()){
            List<ConsumerRecord<K, V>> partitionRecords = records.records(partition);

        }
    }
}
