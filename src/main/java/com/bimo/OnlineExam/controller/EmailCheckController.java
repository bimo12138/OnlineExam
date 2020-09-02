package com.bimo.OnlineExam.controller;

import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.service.MailSendService;
import com.bimo.OnlineExam.service.UserService;
import com.bimo.OnlineExam.utils.MailSendUtils;
import com.bimo.OnlineExam.utils.RandomCode;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: EmailCheckController
 * @Author: 13716
 * @Date: 2020/8/8 17:27
 * @Version: 1.0
 **/

@RequestMapping("/emailCheck")
@RestController
public class EmailCheckController {
    private UserService userService;
    private StringRedisTemplate redisTemplate;
    private MailSendUtils mailSendUtils;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setMailSendService(MailSendUtils mailSendUtils) {
        this.mailSendUtils = mailSendUtils;
    }

    @GetMapping
    public BaseResponse getEmail(String username, String email) {
        String code = RandomCode.getRandomCode();
        mailSendUtils.sendMail(email, username, code);
        redisTemplate.opsForValue().set(email, code, 60 * 5, TimeUnit.SECONDS);
        return new BaseResponse(HttpStatus.OK, "验证码发送成功！请查看邮箱！");
    }

    @PostMapping
    public BaseResponse checkEmail(String username, String email, String code) {
        String codeCheck = redisTemplate.opsForValue().get(email);
        if (code.equals(codeCheck)) {
            User user = userService.getUserByUsername(username);
            user.setEmail(email);
            userService.updateById(user);
            return new BaseResponse(HttpStatus.OK, "邮箱验证成功!");
        } else {
            return new BaseResponse(HttpStatus.BAD_REQUEST, "验证码错误！");
        }
    }
}
