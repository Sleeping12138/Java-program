package com.test.spring2025_4_2.Controller;

import com.test.spring2025_4_2.Constants.Constants;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/producer")
@RestController
@Slf4j
public class RabbitController {
    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Resource(name = "transRabbitTemplate")
    private RabbitTemplate transRabbitTemplate;

    @RequestMapping("/normal")
    public void normal() {
        String msg = "hello world";
        Message message = new Message(msg.getBytes(), new MessageProperties());
        message.getMessageProperties().setExpiration("10000");

        rabbitTemplate.convertAndSend(Constants.NORMAL_EXCHANGE, "normal", message);
        log.info("消息成功发送...");
    }

    @RequestMapping("/delay")
    public void delay(){
        String msg = "hello delay...";
        Message message = new Message(msg.getBytes(),new MessageProperties());
        message.getMessageProperties().setDelayLong(10000L);
        rabbitTemplate.convertAndSend(Constants.DELAY_EXCHANGE,"delay",message);

        System.out.printf("%tc \n",new Date());
    }

    @Transactional
    @RequestMapping("/trans")
    public void trans(){
        transRabbitTemplate.convertAndSend("",Constants.TRANS_QUEUE,"hello trans111...");
        int a = 10/0;
        transRabbitTemplate.convertAndSend("",Constants.TRANS_QUEUE,"hello trans222...");
    }

    @RequestMapping("qos")
    public void qos(){
        // 发送20条消息
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend(Constants.QOS_EXCHANGE,"qos","hello qos--"+i);
        }
        log.info("消息发送完毕...");
    }
}
