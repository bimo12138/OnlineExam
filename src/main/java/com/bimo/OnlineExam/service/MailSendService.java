package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.Mail;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * @ClassName: MailSendService
 * @Author: 13716
 * @Date: 2020/8/1 13:46
 * @Version: 1.0
 **/

@Component
public class MailSendService {

    private RabbitTemplate rabbitTemplate;
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(Mail mail) {
        // CorrelationData  是用来保证可靠传输的 而其中的 ID 属性则是需要是与业务无关的
        // CorrelationData correlationData = new CorrelationData();
        // correlationData.setId(mail.getId().toString());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getContent());
        try {
            mailSender.send(simpleMailMessage);
        } catch (MailException e) {
            System.out.println("发送失败！出现未知问题");
            e.printStackTrace();
        }
    }

    public void addToQueue(Mail mail) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("mail.exchange", "mail.routing.key", mail);
    }
}
