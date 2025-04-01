package com.test.spring2025_4_1.Controller;

import com.test.spring2025_4_1.Constants.Constants;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/producer")
public class RabbitController {

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Resource(name = "confirmRabbitTemplate")
    private RabbitTemplate confirmRabbitTemplate;

    @RequestMapping("/m1")
    public void method1() {
        String msg = "hello rabbitMQ...";
        Message message = new Message(msg.getBytes(), new MessageProperties());
        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);

        rabbitTemplate.convertAndSend(Constants.NONPERSISTENCE_EXCHANGE, "nonpersistence", message);
        log.info("消息发布成功method1...");
    }

    @RequestMapping("/confirm")
    public void confirm() {
        CorrelationData correlationData = new CorrelationData("1");
        confirmRabbitTemplate.convertAndSend(Constants.CONFIRM_EXCHANGE, "confirm111", "hello world", correlationData);
        log.info("消息成功发送...");
    }

    @RequestMapping("retry")
    public void retry() {
        rabbitTemplate.convertAndSend(Constants.RETRY_EXCHANGE, "retry", "retry test...");
    }

    @RequestMapping("/ttl")
    public void ttl(){
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("8000");
                log.info("设置时间完毕...");
                return message;
            }
        };
        rabbitTemplate.convertAndSend(Constants.TTL_EXCHANGE,"ttl","ttl test...",messagePostProcessor);
    }

    @RequestMapping("normal")
    public void normal(){
        rabbitTemplate.convertAndSend(Constants.NORMAL_EXCHANGE,"normal","dl test...");
    }
}
