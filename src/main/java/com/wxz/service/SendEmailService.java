package com.wxz.service;

import com.wxz.entity.Email;
import com.wxz.rabbitmq.Producer.ProducerService;
import com.wxz.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SendMessageService
 * @Description: 发送短信服务类
 * @Author: 王显政
 * @CreateDate: 2018/11/5 17:16
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@Service
@Slf4j
public class SendEmailService {

    @Autowired
    private ProducerService producerService;
    @Autowired
    private EmailUtil emailUtil;
    /**
     * @Description: 发送短信
     * @Author: 王显政
     * @CreateDate: 2018/11/5 17:18
     * @UpdateUser:
     * @UpdateDate:
     * @Version: 0.0.1
     * @param email 邮件对象
     * @return
     */
    public void sendEmail(Email email) throws Exception {
        log.info("进入发送邮件服务");
        //1 校验邮箱地址
        boolean b=emailUtil.checkEmailAddress(email.getReceiver());
        if(!b){
            throw new Exception("收件人邮箱格式错误");
        }
        //2 发送邮件mq消息
        producerService.send(email);

    }
}
