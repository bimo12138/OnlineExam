package com.bimo.OnlineExam;

import com.bimo.OnlineExam.mapper.UserMapper;
import com.bimo.OnlineExam.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: MapperTest
 * @Author: 13716
 * @Date: 2020/7/25 17:30
 * @Version: 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void testExam() {
        System.out.println(userMapper.selectById(1));
    }

    @Test
    public void insertTest() {
        String username = "bimo";
        String password = "qwe123";
        User user = new User(username, password);
        userMapper.insert(user);
    }
}
