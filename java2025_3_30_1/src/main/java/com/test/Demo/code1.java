package com.test.Demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.test.Constants.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

// 发布订阅模式
public class code1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setPort(Constants.PORT);
        connectionFactory.setUsername(Constants.USER_NAME);
        connectionFactory.setPassword(Constants.PASSWORD);
        connectionFactory.setVirtualHost(Constants.VIRTUAL_HOST);

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        // 闯将交换机
        channel.exchangeDeclare(Constants.FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT, true);

        // 创建队列
        channel.queueDeclare(Constants.FANOUT_QUEUE1, true, false, false, null);
        channel.queueDeclare(Constants.FANOUT_QUEUE2, true, false, false, null);

        // 设置bindingKey
        channel.queueBind(Constants.FANOUT_QUEUE1, Constants.FANOUT_EXCHANGE, "");
        channel.queueBind(Constants.FANOUT_QUEUE2, Constants.FANOUT_EXCHANGE, "");

        // 发送消息
        String msg = "hello rabbitMQ";
        channel.basicPublish(Constants.FANOUT_EXCHANGE, "", null, msg.getBytes(StandardCharsets.UTF_8));

        channel.close();
        connection.close();
    }
}
