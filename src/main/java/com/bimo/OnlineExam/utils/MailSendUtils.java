package com.bimo.OnlineExam.utils;

import com.bimo.OnlineExam.pojo.Mail;
import com.bimo.OnlineExam.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MailSendUtils
 * @Author: 13716
 * @Date: 2020/8/8 21:30
 * @Version: 1.0
 **/

@Component
public class MailSendUtils {
    private MailSendService sendService;

    @Autowired
    public void setSendService(MailSendService sendService) {
        this.sendService = sendService;
    }

    public boolean sendMail(String target, String subject, String code) {
        Mail mail = new Mail();
        mail.setId((int) System.currentTimeMillis());
        mail.setSubject(subject);
        mail.setContent("欢迎使用在线考试系统" + subject + "：您的验证码为: " + code + "此验证码有效时间为 5 min！");
        mail.setTo(target);
        sendService.addToQueue(mail);
        return true;
    }
}
