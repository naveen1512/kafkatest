package com.games24x7.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class Consumer {
    public static void consume(String brokers, String groupId) {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", brokers);
        properties.setProperty("group.id", groupId);
        properties.setProperty("enable.auto.commit", "true");
        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer", "com.games24x7.example.MyEmployeeDeserializer");
        // When a group is first created, it has no offset stored to start reading from. This tells it to start
        // with the earliest record in the stream.
        // earliest -> from beginning and latest -> from the last committed offset.
        properties.setProperty("auto.offset.reset", "earliest");

        KafkaConsumer<String, MyEmployeeList> consumer = null;

        try {
            consumer = new KafkaConsumer<String, MyEmployeeList>(properties);

            consumer.subscribe(Arrays.asList("naveen_test"));

            int count = 0;
            while (true) {
                ConsumerRecords<String, MyEmployeeList> records = consumer.poll(Duration.ofMillis(2000));

                Set partitions = consumer.assignment();

                if (records.count() == 0) {
                } else {
                    for (ConsumerRecord<String, MyEmployeeList> record : records) {
                        count += 1;
                        System.out.println(record.value());
//                        System.out.println(count + ": " + groupId + ": topic:" + record.topic() +
//                                ": partition:" + record.partition() + ": offset:" + record.offset() +
//                                ": timestamp:" + record.timestamp() + ": Key:" + record.key() + " : " +
//                                record.value());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
