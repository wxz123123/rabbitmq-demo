package com.wxz.utils;

import com.wxz.entity.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.mail.internet.MimeMessage;

/**
 * @ClassName: EmailUtil
 * @Description: 邮件工具类
 * @Author: 王显政
 * @CreateDate: 2018/11/5 20:01
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@Component
@Slf4j
public class EmailUtil {
    /**
     * 邮箱格式检验正则表达式
     */
    private static final String EMAIL_REGEX = ("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    @Autowired
    private JavaMailSender javaMailSender;
    /**
     * 发送人
     */
    @Value("${spring.mail.username}")
    private String from;
    /**
     * @Description: 邮箱格式校验
     * @Author: 王显政
     * @CreateDate: 2018/11/5 20:47
     * @UpdateUser:
     * @UpdateDate:
     * @Version: 0.0.1
     * @param email
     * @return
     */
    public  boolean checkEmailAddress(String email){
        log.info("开始校验邮箱格式");
        if(StringUtils.isEmpty(email) || !(email.matches(EMAIL_REGEX))){
            return false;
        }
        return true;
    }
    /**
     * @Description: 发送普通文本邮件
     * @Author: 王显政
     * @CreateDate: 2018/11/5 20:21
     * @UpdateUser:
     * @UpdateDate:
     * @Version: 0.0.1
     * @param email 邮件对象
     * @return
     */
    public  void send(Email email) throws Exception {
        //1 封装邮件消息
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        //2 发送
        log.info("开始发送普通文本邮件："+email);
        try{
            javaMailSender.send(message);
            log.info("发送普通文本邮件成功："+email);
        }catch (Exception e){
            log.info("普通文本邮件发送失败");
            e.printStackTrace();
           throw  new Exception("普通文本邮件发送失败："+e.getMessage());
        }
    }
    /**
     * @Description: 发送Html邮件
     * @Author: 王显政
     * @CreateDate: 2018/11/6 11:15
     * @UpdateUser:
     * @UpdateDate:
     * @Version: 0.0.1
     * @param email 邮件对象
     * @return
     */
    public  void sendHtml(Email email) throws Exception {
        //1 封装邮件消息
        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        MimeMessageHelper message=new MimeMessageHelper(mimeMessage);
        message.setFrom(from);
        message. setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getContent(),true);
        //2 发送
        log.info("开始发送Html邮件："+email);
        try{
            javaMailSender.send(mimeMessage);
            log.info("发送Html邮件成功："+email);
        }catch (Exception e){
            log.info("Html邮件发送失败");
            e.printStackTrace();
            throw  new Exception("Html邮件发送失败："+e.getMessage());
        }
    }
}
