package com.bimo.OnlineExam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.service.UserService;
import com.bimo.OnlineExam.utils.TokenDetail;
import com.bimo.OnlineExam.utils.TokenUtils;
import com.bimo.OnlineExam.utils.impl.TokenDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Author: 13716
 * @Date: 2020/7/24 22:29
 * @Version: 1.0
 **/

@RequestMapping("/login")
@RestController
public class LoginController {

    private UserService userService;
    private TokenUtils tokenUtils = new TokenUtils();

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private TokenDetail getTokenDetail(User user) {
        return new TokenDetailImpl(user.getUsername(), user.getIsSuperuser(), user.getIsUploader());
    }

    @PostMapping
    public BaseResponse login(User user) {
        User checked_user = userService.getUserByUsername(user.getUsername());
        if (checked_user == null) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前用户名不存在, 请重试!");
        }
        if (user.checkPassword(checked_user.getPassword())) {
            // SUCCESS
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("message", "登录成功, 即将跳转……");
            response.put("user", checked_user);
            response.put("token", tokenUtils.generateToken(getTokenDetail(checked_user)));
            return new BaseResponse(HttpStatus.OK, response);
        }
        return new BaseResponse(HttpStatus.NO_CONTENT, "密码输入错误，请重试！");
    }
}
