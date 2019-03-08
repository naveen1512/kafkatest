package com.games24x7.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public abstract class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endpointName) throws IOException {
        this.endPointName = endpointName;

        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();

        //hostname of your rabbitmq server
        factory.setHost("localhost");

        //getting a connection
        this.connection = factory.newConnection();

        //creating a channel
        this.channel = connection.createChannel();

        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(this.endPointName, false, false, false, null);
    }

    public void close() throws IOException {
        this.channel.close();
        this.connection.close();
    }

    public int getMessageCount() throws IOException {
        return this.channel.queueDeclarePassive(this.endPointName).getMessageCount();
    }

    public int getMessageCountOther() throws IOException {
        return channel.queueDeclare(this.endPointName, true, false, false, null).getMessageCount();
    }
}
