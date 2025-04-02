package com.test.spring2025_4_2.Config;

import com.test.spring2025_4_2.Constants.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

    @Bean("normalQueue")
    public Queue normalQueue(){
        return QueueBuilder
                .durable(Constants.NORMAL_QUEUE)
                .deadLetterExchange(Constants.DL_EXCHANGE)
                .deadLetterRoutingKey("dl")
                .maxLength(10L)
                .build();
    }

    @Bean("normalExchange")
    public DirectExchange normalExchange(){
        return ExchangeBuilder.directExchange(Constants.NORMAL_EXCHANGE).build();
    }

    @Bean("normalQueueBinding")
    public Binding normalQueueBinding(@Qualifier("normalQueue") Queue queue,@Qualifier("normalExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("normal");
    }

    @Bean("dlQueue")
    public Queue dlQueue(){
        return QueueBuilder.durable(Constants.DL_QUEUE).build();
    }

    @Bean("dlExchange")
    public DirectExchange dlExchange(){
        return ExchangeBuilder.directExchange(Constants.DL_EXCHANGE).build();
    }

    @Bean("dlQueueBinding")
    public Binding dlQueueBinding(@Qualifier("dlQueue") Queue queue,@Qualifier("dlExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("dl");
    }

    // 延迟响应
    @Bean("delayQueue")
    public Queue delayQueue(){
        return QueueBuilder.durable(Constants.DELAY_QUEUE).build();
    }

    @Bean("delayExchange")
    public DirectExchange delayExchange(){
        return ExchangeBuilder.directExchange(Constants.DELAY_EXCHANGE).delayed().build();
    }

    @Bean("delayQueueBinding")
    public Binding delayQueueBinding(@Qualifier("delayQueue") Queue queue,@Qualifier("delayExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("delay");
    }

    // 事务

    @Bean("transQueue")
    public Queue transQueue(){
        return QueueBuilder.durable(Constants.TRANS_QUEUE).build();
    }

    // 创建一个新的RabbitTemplate对象，防止全局污染
    @Bean("transRabbitTemplate")
    public RabbitTemplate transRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // 开启事务
        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }

    // 设置事务管理器
    @Bean("rabbitTransactionManager")
    public RabbitTransactionManager rabbitTransactionManager(ConnectionFactory connectionFactory){
        return new RabbitTransactionManager(connectionFactory);
    }

    // 消息分发
    @Bean("qosQueue")
    public Queue qosQueue(){
        return QueueBuilder.durable(Constants.QOS_QUEUE).build();
    }

    @Bean("qosExchange")
    public DirectExchange qosExchange(){
        return ExchangeBuilder.directExchange(Constants.QOS_EXCHANGE).build();
    }

    @Bean("qosQueueBinding")
    public Binding qosQueueBinding(@Qualifier("qosQueue") Queue queue,@Qualifier("qosExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("qos");
    }
}
