package com.bimo.OnlineExam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName: redisTest
 * @Author: 13716
 * @Date: 2020/8/8 20:01
 * @Version: 1.0
 **/

@SpringBootTest
public class redisTest {
    // 主要操作对象为String
    private StringRedisTemplate stringRedisTemplate;
    // k v 都是 object
    private RedisTemplate redisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void redisBaseTest() {
//        stringRedisTemplate.opsForValue().append("1371639183@qq.com", "123456");
//        String a = stringRedisTemplate.opsForValue().get("1371639183@qq.com");
//        System.out.println(a);
    }
}
