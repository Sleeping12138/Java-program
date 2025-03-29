package com.test.spring2025_3_29.Demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
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

        // 创建默认消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        };

        // 获取消息
        channel.basicConsume("hello", true, defaultConsumer);

        // 释放资源
        channel.close();
        connection.close();
    }
}
