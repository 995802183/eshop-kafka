package com.wyw.eshop.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConsumerThreadHandler<K,V> {

    private final KafkaConsumer<K,V> consumer;

    private ExecutorService executors;

    private final Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();

    public ConsumerThreadHandler(String brokerList,String groupId,String topic){
        Properties props = new Properties();
        props.put("bootstrap.servers",brokerList);
        props.put("group.id",groupId);
        props.put("enable.auto.commit","false");
        props.put("auto.offset.reset","earliest");
        props.put("key.deserializer","org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.ByteArrayDeserializer");
        consumer = new KafkaConsumer<K, V>(props);
        consumer.subscribe(Arrays.asList(topic), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                consumer.commitSync(offsets);
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                offsets.clear();
            }
        });
        
        public void consume(int threadNumber){
            executors = new ThreadPoolExecutor(threadNumber,threadNumber,0L,
                    TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(1000),new ThreadPoolExecutor.CallerRunsPolicy());
            try{
                while (true){
                    ConsumerRecords<K, V> records = consumer.poll(Duration.ofMillis(1000));
                    if(!records.isEmpty()){
                        executors.submit()
                    }
                }
            }catch (Exception e){
                
            }
        }
    }
}
