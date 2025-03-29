package com.test.spring2025_3_29.Demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.60.101");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("student");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("rabbitMQ");

        // 由工厂创建连接
        Connection connection = connectionFactory.newConnection();

        // 创建channel
        Channel channel = connection.createChannel();

        // 创建队列
        channel.queueDeclare("hello", true, false, false, null);

        // 添加消息
        for (int i = 0; i < 10; i++) {
            String msg = "hello rabbitMQ--" + i;
            channel.basicPublish("", "hello", null, msg.getBytes());
        }


        System.out.println("发送消息成功...");
        // 释放资源
        channel.close();
        connection.close();
    }
}
