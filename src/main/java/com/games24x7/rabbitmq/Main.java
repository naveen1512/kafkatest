//https://dzone.com/articles/getting-started-rabbitmq-java
package com.games24x7.rabbitmq;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public Main() throws Exception {

//        QueueConsumer consumer = new QueueConsumer("naveenQueue");
//        Thread consumerThread = new Thread(consumer);
//        consumerThread.start();

        Producer producer = new Producer("naveenQueue");
        System.out.println("Message Count: " + producer.getMessageCount());

//        for (int i = 0; i < 100000; i++) {
//            HashMap message = new HashMap();
//            message.put("message number", i);
//            producer.sendMessage(message);
//            System.out.println("Message Number " + i + " sent.");
//            System.out.println("Message Count: " + producer.getMessageCount());
//        }
    }

    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        new Main();
    }
}
