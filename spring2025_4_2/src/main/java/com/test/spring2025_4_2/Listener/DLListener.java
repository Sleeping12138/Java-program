package com.test.spring2025_4_2.Listener;

import com.rabbitmq.client.Channel;
import com.test.spring2025_4_2.Constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
@Slf4j
public class DLListener {
    @RabbitListener(queues = Constants.NORMAL_QUEUE)
    public void normalListener(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("正常队列 :" + new String(message.getBody()));
            int a = 10 / 0;
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            channel.basicNack(deliveryTag, false, false);
        }
    }

    @RabbitListener(queues = Constants.DL_QUEUE)
    public void dlListener(Message message) {
        log.info("死信队列 :" + new String(message.getBody()));
    }

    @RabbitListener(queues = Constants.DELAY_QUEUE)
    public void delayListener() {
        System.out.printf("%tc \n", new Date());
    }

    @RabbitListener(queues = Constants.QOS_QUEUE)
    public void qosListener1(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info(deliveryTag + "");
            // 由于没有进行ack，所以队列中会存储15条消息
            // channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            channel.basicNack(deliveryTag, false, true);
        }
    }

    @RabbitListener(queues = Constants.QOS_QUEUE)
    public void qosListener2(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info(deliveryTag + "");
            Thread.sleep(2000);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            channel.basicNack(deliveryTag, false, true);
        }
    }
}
