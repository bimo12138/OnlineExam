package com.bimo.OnlineExam;

import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SecurityTest
 * @Author: 13716
 * @Date: 2020/7/27 14:01
 * @Version: 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void safeTest() {
        List<String> roles = Arrays.asList("999", "8788");
        roles.forEach(System.out::println);
    }

    @Test
    public void getUserByName() {
        String username = "bimo";
        User user = userService.getUserByUsername(username);
        System.out.println(user);
    }
}
