package com.bimo.OnlineExam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: RabbitTest
 * @Author: 13716
 * @Date: 2020/7/28 23:32
 * @Version: 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Test
    public void directTest() {
        rabbitTemplate.convertAndSend("exchange.direct", "SpringTest", "666");
    }
    @Test
    public void receiveTest() {
        Object object = rabbitTemplate.receiveAndConvert("SpringTest");
        System.out.println(object.getClass());
        System.out.println(object);
    }
}
