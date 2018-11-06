package com.wxz.rabbitmq.consumer;

import com.wxz.entity.Email;
import com.wxz.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloConsumer
 * @Description: 消息队列消费者监听
 * @Author: 王显政
 * @CreateDate: 2018/11/5 17:11
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@Component
@RabbitListener(queues = "email")
@Slf4j
public class EmailConsumer {
    @Autowired
    private EmailUtil emailUtil;
    @RabbitHandler
    public void process(Email email) throws Exception {
       log.info("MQ开始接受邮件消息："+email);
       //判断是否是html邮件
       if(email.getIsHtml()){
           //Html邮件
           emailUtil.sendHtml(email);
       }else{
           //普通邮件
           emailUtil.send(email);
       }
    }
}
