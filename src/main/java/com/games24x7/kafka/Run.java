package com.games24x7.kafka;

import java.io.IOException;
import java.util.UUID;

public class Run {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            usage();
        }

        String brokers = args[1];

        switch (args[0].toLowerCase()) {
            case "producer":
//                Producer.produce(brokers);
                ProducerString.produce(brokers);
                break;

            case "consumer":
                String groupId;
                if (args.length == 3) {
                    groupId = args[2];
                } else {
                    groupId = UUID.randomUUID().toString();
                }

//                Consumer.consume(brokers, groupId);
                ConsumerString.consume(brokers, groupId);
                break;

            default:
                usage();
        }

        System.exit(0);
    }

    public static void usage() {
        System.out.println("Usage:");
        System.out.println("kafka-example.jar <producer|consumer> brokerhosts [groupid]");
        System.exit(1);
    }
}
