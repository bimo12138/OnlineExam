package com.bimo.OnlineExam;

import com.bimo.OnlineExam.pojo.Mail;
import com.bimo.OnlineExam.service.MailSendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @ClassName: MailTest
 * @Author: 13716
 * @Date: 2020/8/1 17:36
 * @Version: 1.0
 **/

@SpringBootTest
public class MailTest {

    private JavaMailSender sender;
    private MailSendService mailSendService;

    @Autowired
    public void setMailSendService(MailSendService mailSendService) {
        this.mailSendService = mailSendService;
    }

    @Autowired
    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }

    @Test
    public void mainTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1371639183@qq.com");
        message.setTo("1781339190@qq.com");
        message.setSubject("JavaMail");
        message.setText("窃以为，刘盈说的很多都让人听不懂");
        sender.send(message);
    }

    @Test
    public void mailAndQueueTest() {
        Mail mail = new Mail();
        mail.setId(1);
        mail.setSubject("test");
        mail.setContent("test");
        mail.setTo("1371639183@qq.com");
        for (int i = 0; i < 10; i++) {
            mailSendService.addToQueue(mail);
        }
    }
}
