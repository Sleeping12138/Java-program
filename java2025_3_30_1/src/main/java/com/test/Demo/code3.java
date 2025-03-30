package com.test.Demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.test.Constants.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class code3 {
    public static void main(String[] args) throws IOException, TimeoutException {
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
        channel.exchangeDeclare(Constants.TOPIC_EXCHANGE, BuiltinExchangeType.TOPIC, true);

        // 声明队列
        channel.queueDeclare(Constants.TOPIC_QUEUE1, true, false, false, null);
        channel.queueDeclare(Constants.TOPIC_QUEUE2, true, false, false, null);

        // 设置bindingKey
        channel.queueBind(Constants.TOPIC_QUEUE1, Constants.TOPIC_EXCHANGE, "*.a.*");
        channel.queueBind(Constants.TOPIC_QUEUE2, Constants.TOPIC_EXCHANGE, "*.*.b");
        channel.queueBind(Constants.TOPIC_QUEUE2, Constants.TOPIC_EXCHANGE, "c.#");

        // 发送消息
        String msg = "hello topic, my routingkey is ae.a.f....";
        channel.basicPublish(Constants.TOPIC_EXCHANGE,"ae.a.f", null, msg.getBytes());
        String msg_b = "hello topic, my routingkey is ef.a.b....";
        channel.basicPublish(Constants.TOPIC_EXCHANGE,"ef.a.b", null, msg_b.getBytes());

        String msg_c = "hello topic, my routingkey is c.ef.d....";
        channel.basicPublish(Constants.TOPIC_EXCHANGE, "c.ef.d", null, msg_c.getBytes());

        System.out.println("消息发送成功");

        //7. 释放资源
        channel.close();
        connection.close();
    }
}
