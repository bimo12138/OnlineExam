package com.bimo.OnlineExam.consumer;

import com.bimo.OnlineExam.config.DirectRabbitConfig;
import com.bimo.OnlineExam.pojo.Mail;
import com.bimo.OnlineExam.service.MailSendService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName: MailConsumer
 * @Author: 13716
 * @Date: 2020/8/1 23:01
 * @Version: 1.0
 **/

@Component
public class MailConsumer {
    private MailSendService mailSendService;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    public void setMailSendService(MailSendService mailSendService) {
        this.mailSendService = mailSendService;
    }

    @RabbitListener(queues = "mail.queue")
    public void sendAndConsumerMail(Mail mail) {
        mailSendService.send(mail);
    }
}
