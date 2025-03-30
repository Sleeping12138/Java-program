package com.test.Demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.test.Constants.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class code2 {
    public static void main(String[] args) throws IOException, TimeoutException {

        //1. 建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setPort(Constants.PORT); //需要提前开放端口号
        connectionFactory.setUsername(Constants.USER_NAME);//账号
        connectionFactory.setPassword(Constants.PASSWORD);  //密码
        connectionFactory.setVirtualHost(Constants.VIRTUAL_HOST); //虚拟主机
        Connection connection = connectionFactory.newConnection();
        //2. 开启信道
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(Constants.DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT, true);

        // 声明队列
        channel.queueDeclare(Constants.DIRECT_QUEUE1, true, false, false, null);
        channel.queueDeclare(Constants.DIRECT_QUEUE2, true, false, false, null);

        // 设置bindingKey
        channel.queueBind(Constants.DIRECT_QUEUE1, Constants.DIRECT_EXCHANGE, "a");
        channel.queueBind(Constants.DIRECT_QUEUE2, Constants.DIRECT_EXCHANGE, "a");
        channel.queueBind(Constants.DIRECT_QUEUE2, Constants.DIRECT_EXCHANGE, "b");
        channel.queueBind(Constants.DIRECT_QUEUE2, Constants.DIRECT_EXCHANGE, "c");
        // 发送消息
        String msg = "hello direct, my routingkey is a....";
        channel.basicPublish(Constants.DIRECT_EXCHANGE, "a", null, msg.getBytes());

        String msg_b = "hello direct, my routingkey is b....";
        channel.basicPublish(Constants.DIRECT_EXCHANGE, "b", null, msg_b.getBytes());

        String msg_c = "hello direct, my routingkey is c....";
        channel.basicPublish(Constants.DIRECT_EXCHANGE, "c", null, msg_c.getBytes());

        System.out.println("消息发送成功");

        //7. 释放资源
        channel.close();
        connection.close();
    }
}

