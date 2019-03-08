package com.games24x7.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Properties;

final class ProduceMsgs {

	public java.util.List<String> blockUsersList() {
		java.util.List<String> users = new ArrayList<String>();

		// Add users which you want to block.
		users.add("134344");

		java.util.List<String> records = new ArrayList<String>();
		for (int i = 0; i < users.size(); i++) {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("user_id", users.get(i));

			records.add(jsonObject.toJSONString());
		}

		return records;
	}

	public void publishHandHistory(KafkaProducer<String, String> producer) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/Users/naveen/Desktop/Handhistory1.log"));

			String line = reader.readLine();
			int count = 1;
			while (line != null) {

				producer.send(new ProducerRecord<String, String>("hh_topic_new", line));
				System.out.println("Sent " + count + ": " + line);

				line = reader.readLine();
				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
	}
}

public class ProducerString {
	public static void produce(String brokers) throws IOException {

		Properties properties = new Properties();

		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.14.26.71:9092,10.14.27.24:9092,10.14.25.52:9092");
		properties.put("acks", "all");
		properties.put("retries", 1);
		properties.put("linger.ms", 0);
//        properties.put("batch.size", 1);
		properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = null;
		ProduceMsgs produceMsgs = new ProduceMsgs();

		try {
			producer = new KafkaProducer<String, String>(properties);
			produceMsgs.publishHandHistory(producer);
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
