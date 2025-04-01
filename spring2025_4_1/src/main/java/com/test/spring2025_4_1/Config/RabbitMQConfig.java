package com.test.spring2025_4_1.Config;

import com.test.spring2025_4_1.Constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.Bidi;

@Slf4j
@Configuration
public class RabbitMQConfig {

    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean("confirmRabbitTemplate")
    public RabbitTemplate confirmRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            // 第二个参数是是否发送到了交换机，第三个参数是如果没有发送到，原因
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if (b) {
                    log.info("exchange接收到了的消息..." + (correlationData == null ? null : correlationData.getId()));
                } else {
                    log.info("没接收导消息,--" + s);
                }
            }
        });

        // 用于开启return退回模式
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println(returnedMessage);
            }
        });
        return rabbitTemplate;
    }

    // 持久化的队列
    @Bean("persistenceQueue")
    public Queue persistenceQueue() {
        return QueueBuilder.durable(Constants.PERSISTENCE_QUEUE).build();
    }

    // 持久化交换机
    @Bean("directExchange")
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(Constants.PERSISTENCE_EXCHANGE).durable(true).build();
    }

    @Bean("persistenceQueueBinding")
    public Binding persistenceQueueBinding(@Qualifier("persistenceQueue") Queue queue, @Qualifier("directExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("persistence");
    }

    // 非持久化的队列
    @Bean("nonpersistenceQueue")
    public Queue nonpersistenceQueue() {
        return QueueBuilder.nonDurable(Constants.NONPERSISTENCE_QUEUE).build();
    }

    // 非持久化交换机
    @Bean("nonDirectExchange")
    public DirectExchange nonDirectExchange() {
        return ExchangeBuilder.directExchange(Constants.NONPERSISTENCE_EXCHANGE).durable(false).build();
    }

    @Bean("noPersistenceQueueBinding")
    public Binding noPersistenceQueueBinding(@Qualifier("nonpersistenceQueue") Queue queue, @Qualifier("nonDirectExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("nonpersistence");
    }

    // 消息的确认
    @Bean("confirmQueue")
    public Queue confirmQueue() {
        return QueueBuilder.durable(Constants.CONFIRM_QUEUE).build();
    }

    @Bean("confirmExchange")
    public DirectExchange confirmExchange() {
        return ExchangeBuilder.directExchange(Constants.CONFIRM_EXCHANGE).build();
    }

    @Bean("confirmQueueBinding")
    public Binding confirmQueueBinding(@Qualifier("confirmQueue") Queue queue, @Qualifier("confirmExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("confirm");
    }

    @Bean("retryQueue")
    public Queue retryQueue(){
        return QueueBuilder.durable(Constants.RETRY_QUEUE).build();
    }

    @Bean("retryExchange")
    public DirectExchange retryExchange(){
        return ExchangeBuilder.directExchange(Constants.RETRY_EXCHANGE).build();
    }

    @Bean
    public Binding retryQueueBinding(@Qualifier("retryQueue") Queue queue,@Qualifier("retryExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("retry");
    }

    // 设置队列ttl
    @Bean("ttlQueue")
    public Queue ttlQueue(){
        return QueueBuilder.durable(Constants.TTL_QUEUE).ttl(20000).build();
    }

    @Bean("ttlExchange")
    public DirectExchange ttlExchange(){
        return ExchangeBuilder.directExchange(Constants.TTL_EXCHANGE).build();
    }

    @Bean("ttlQueueBinding")
    public Binding ttlQueueBinding(@Qualifier("ttlQueue") Queue queue,@Qualifier("ttlExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("ttl");
    }


    // 死信
    @Bean("normalQueue")
    public Queue normalQueue(){
        return QueueBuilder
                .durable(Constants.NORMAL_QUEUE)
                .ttl(10000)
                .deadLetterExchange(Constants.DL_EXCHANGE)
                .deadLetterRoutingKey("dl")
                .build();
    }

    @Bean("dlExchange")
    public DirectExchange dlExchange(){
        return ExchangeBuilder.directExchange(Constants.DL_EXCHANGE).build();
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



    @Bean("dlQueueBinding")
    public Binding dlQueueBinding(@Qualifier("dlQueue") Queue queue,@Qualifier("dlExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("dl");
    }

}
