package com.wxz.service;

import com.wxz.entity.Email;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ClassName: SendMessageServiceTest
 * @Description: 发送邮件单元测试类
 * @Author: 王显政
 * @CreateDate: 2018/11/5 20:56
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SendEmailServiceTest {
    @Autowired
    private SendEmailService sendEmailService;
    //html邮件样例
    private static String content = "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            + "<title>Html测试邮件</title>"
            + "<meta name=\"content-type\" content=\"text/html; charset=UTF-8\">"
            + "</head>"
            + "<body>"
            + "<p style=\"color:#0FF\">这是一封Html测试邮件~</p>"
            + "<a href=\"www.baidu.com\" title=\"百度一下\">百度一下，你就知道</a>"
            + "</body>"
            + "</html>";
    @Test
    public void sendEmail() throws Exception {
        log.info("测试发送邮件开始");
        Email email=new Email();
        email.setReceiver("2166286498@qq.com");
        email.setSubject("RabbitMQ发送邮件测试2");
        email.setContent("2018-11-05，RabbitMQ发送邮件测试。");
        sendEmailService.sendEmail(email);
        log.info("测试发送邮件结束");
    }
    @Test
    public void sendHtmlEmail() throws Exception {
        log.info("测试发送邮件开始");
        Email email=new Email();
        email.setReceiver("2166286498@qq.com");
        email.setSubject("html测试邮件");
        email.setContent(content);
        email.setIsHtml(true);
        sendEmailService.sendEmail(email);
        log.info("测试发送邮件结束");
    }

}