package com.games24x7.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Producer {
    public static void produce(String brokers) throws IOException {

        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        properties.put("acks", "all");
        properties.put("retries", 1);
        properties.put("linger.ms", 0);
//        properties.put("batch.size", 1);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.games24x7.example.MyEmployeeListSerializer");

        KafkaProducer<String, MyEmployeeList> producer = null;

        try {
            producer = new KafkaProducer<String, MyEmployeeList>(properties);

            for (int i = 0; ; i++) {

                List<MyEmployee> empList = new ArrayList<MyEmployee>();
                empList.add(new MyEmployee("Naveen 0"));
                empList.add(new MyEmployee("Naveen 1"));

                producer.send(new ProducerRecord<String, MyEmployeeList>("naveen_test", new MyEmployeeList(empList)));

                System.out.println("Sent " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    private static void printClassPaths() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader) cl).getURLs();

        for (URL url : urls) {
            System.out.println(url.getFile());
        }
    }
}
