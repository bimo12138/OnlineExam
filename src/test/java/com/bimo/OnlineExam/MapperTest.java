package com.bimo.OnlineExam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bimo.OnlineExam.mapper.ExamMapper;
import com.bimo.OnlineExam.mapper.UserMapper;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.service.ChooseQuestionService;
import com.bimo.OnlineExam.service.ExamService;
import com.bimo.OnlineExam.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    private UserService userService;
    private ExamService examService;

    @Resource
    private ChooseQuestionService chooseQuestionService;


    @Resource
    private ExamMapper examMapper;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    @Test
    public void getExamQuestion() {
        long start = System.currentTimeMillis();
        List<ChooseQuestion> res = chooseQuestionService.getChooseQuestionWithRandom(50, "7-2-1", 10);
        System.out.println(res.size());
        long end = System.currentTimeMillis();
        System.out.println("消耗时间： " + (end - start));
    }
    @Test
    public void testExam() {
        System.out.println(userMapper.selectById(1));
    }

    @Test
    public void insertTest() {
    }
    @Test
    public void getUser() {
        String username = "bimo";
        String password = "qwe";

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> a = queryWrapper.select("password").eq("username", username);
        System.out.println(userMapper.selectOne(a).getPassword());
    }

    @Test
    public void serviceTest() {
        String username = "bimo";
        String password = "qwe123";
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> a = queryWrapper.eq("username", username);
        System.out.println(userService.getOne(a));
    }

    @Test
    public void customGet() {
        User a = userService.getUserByUsername("bimo");
        System.out.println(a);
    }

    @Test
    public void getExam() {
        examService.getNewExam();
    }

    @Test
    public void getUserByMap() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> map = userService.list(queryWrapper.orderByAsc("create_time").last("LIMIT 5"));
        System.out.println(666);
    }

    @Test
    public void getNewExam() {
        System.out.println(examMapper.getNewExams());

        System.out.println("Get Finish!");
    }

    @Test
    public void getMyExam() {
        System.out.println(examService.getMyExam(1));
    }
}
