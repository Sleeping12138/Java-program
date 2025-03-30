package com.test.Constants;

public class Constants {
    public static final String HOST = "192.168.60.101";
    public static final int PORT = 5672;
    public static final String USER_NAME = "student";
    public static final String PASSWORD = "admin";
    public static final String VIRTUAL_HOST = "rabbitMQ";
    //发布订阅模式
    public static final String FANOUT_EXCHANGE = "fanout.exchange";
    public static final String FANOUT_QUEUE1 = "fanout.queue1";
    public static final String FANOUT_QUEUE2 = "fanout.queue2";

    //路由模式
    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String DIRECT_QUEUE1 = "direct.queue1";
    public static final String DIRECT_QUEUE2 = "direct.queue2";

    //通配符模式
    public static final String TOPIC_EXCHANGE = "topic.exchange";
    public static final String TOPIC_QUEUE1 = "topic_queue1";
    public static final String TOPIC_QUEUE2 = "topic_queue2";

    //rpc 模式
    public static final String RPC_REQUEST_QUEUE = "rpc.request.queue";
    public static final String RPC_RESPONSE_QUEUE = "rpc.response.queue";

    //publisher confirms
    public static final String PUBLISHER_CONFIRMS_QUEUE1 = "publisher.confirms.queue1";
    public static final String PUBLISHER_CONFIRMS_QUEUE2 = "publisher.confirms.queue2";
    public static final String PUBLISHER_CONFIRMS_QUEUE3 = "publisher.confirms.queue3";

    //推拉模式
    public static final String MESSAGE_QUEUE = "message.queue";
}
