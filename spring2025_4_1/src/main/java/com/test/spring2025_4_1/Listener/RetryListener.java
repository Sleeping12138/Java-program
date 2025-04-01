package com.test.spring2025_4_1.Listener;

import com.test.spring2025_4_1.Constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RetryListener {
    @RabbitListener(queues = Constants.RETRY_QUEUE)
    public void Listener1(Message message) {
        log.info(new String(message.getBody())+"---"+message.getMessageProperties().getDeliveryTag());
        int a = 10 / 0;
    }
}
