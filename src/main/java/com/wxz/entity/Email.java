package com.wxz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Message
 * @Description: 邮件对象
 * @Author: 王显政
 * @CreateDate: 2018/11/5 17:20
 * @UpdateUser:
 * @UpdateDate:
 * @Version: 0.0.1
 */
@Data
public class Email implements Serializable{
    private static final long serialVersionUID = 402950663441326767L;
    /**
     * 接收方邮箱
     */
    private String receiver;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;

    /**
     * 是否html邮件
     */
    private Boolean isHtml=false;

    @Override
    public String toString() {
        return "Email{" +
                "receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", isHtml=" + isHtml +
                '}';
    }
}
