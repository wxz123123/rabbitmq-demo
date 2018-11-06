package com.wxz.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitMqConfigration
 * @Description: mq消息队列配置
 * @Author: 王显政
 * @CreateDate: 2018/11/5 16:57
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@Configuration
public class RabbitMqConfigration {
    @Bean
    public Queue emailQueue(){
        return new Queue("email");
    }
}
