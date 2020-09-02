package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public BaseResponse getUserInfo(Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前查询的内容不存在");
        }
        return new BaseResponse(HttpStatus.OK, user);
    }

    @PostMapping
    public BaseResponse saveUser(String username, String password, boolean isUploader) {
        if (username == null || password == null) {
            return new BaseResponse(HttpStatus.BAD_REQUEST, "信息填写不完整，请重试");
        }
        boolean exists = userService.checkExists(username);
        if (exists) {
            return new BaseResponse(HttpStatus.UNAUTHORIZED, "用户名已经注册, 请重试");
        }
        User user = new User(username, password, isUploader);
        boolean result = userService.save(user);
        if (result) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("message", "用户" + username + "注册成功！页面即将跳转");
            map.put("username", username);
            return new BaseResponse(HttpStatus.OK, map);
        }
        return new BaseResponse(HttpStatus.BAD_REQUEST, "用户注册失败，请重试！");
    }
}

