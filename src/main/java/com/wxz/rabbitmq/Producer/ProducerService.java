package com.wxz.rabbitmq.Producer;

import com.wxz.entity.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName: ProducerService
 * @Description: 消息生产者
 * @Author: 王显政
 * @CreateDate: 2018/11/5 10:40
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@Service
@Slf4j
public class ProducerService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Email email){
        log.info("MQ开始发送邮件消息");
        rabbitTemplate.convertAndSend("email",email);
        log.info("MQ发送邮件消息结束");
    }
}
