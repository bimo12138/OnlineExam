package com.bimo.OnlineExam.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;

/**
 * @ClassName: DirectRabbitConfig
 * @Author: 13716
 * @Date: 2020/7/28 11:53
 * @Version: 1.0
 **/

@Configuration
public class DirectRabbitConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    private final static String DIRECT_QUEUE = "directQueue";

    private final static String TOPIC_QUEUE_ONE = "topicQueueOne";
    private final static String TOPIC_QUEUE_TOW = "topicQueueTwo";

    private final static String FANOUT_QUEUE_ONE = "fanoutQueueOne";
    private final static String FANOUT_QUEUE_TWO = "fanoutQueueTwo";

    private final static String TOPIC_EXCHANGE = "topicExchange";
    private final static String FANOUT_EXCHANGE = "fanoutExchange";
    private final static String TOPIC_ROUTING_KEY_ONE = "common_key";
    private final static String TOPIC_ROUTING_KEY_TWO = "*.key";



    /**
     * email 队列
     */
    private final static String MAIL_QUEUE = "mail.queue";
    private final static String MAIL_EXCHANGE = "mail.exchange";
    private final static String MAIL_ROUTING_KEY = "mail.routing.key";

    @Bean
    public Queue mailQueue() {
        return new Queue(MAIL_QUEUE, true);
    }

    @Bean
    public DirectExchange mailExchange() {
        return new DirectExchange(MAIL_EXCHANGE);
    }

    @Bean
    public Binding mailBinding() {
        return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(MAIL_ROUTING_KEY);
    }
    /**
     *
     *
     */
    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT_QUEUE, true);
    }

    @Bean
    public Queue topicQueueOne() {
        return new Queue(TOPIC_QUEUE_ONE, true);
    }

    @Bean
    public Queue topicQueueTwo() {
        return new Queue(TOPIC_QUEUE_TOW, true);
    }

    @Bean
    public Queue fanoutQueueOne() {
        return new Queue(FANOUT_QUEUE_ONE, true);
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return new Queue(FANOUT_QUEUE_TWO, true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding topicExchangeBingingOne() {
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with(TOPIC_ROUTING_KEY_ONE);
    }

    @Bean
    public Binding topicExchangeBindingTwo() {
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with(TOPIC_ROUTING_KEY_TWO);
    }

    @Bean
    public Binding fanoutExchangeBingingOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutExchangeBindingTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }
}
