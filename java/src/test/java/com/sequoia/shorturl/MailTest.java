package com.sequoia.shorturl;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/10/24
 */
public class MailTest {

    public static void main(String[] args) {
        // 服务器地址:
        String smtp = "smtp.163.com";
// 登录用户名:
        String username = "error_warn@163.com";
// 登录口令:
        String password = "error@2021";
// 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "25"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密

        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, "ANNTCEJMSIXXCWIK");
            }
        });
// 设置debug模式便于调试:
        session.setDebug(true);


        try {
            MimeMessage message = new MimeMessage(session);
// 设置发送方地址:
            message.setFrom(new InternetAddress("error_warn@163.com"));
// 设置接收方地址:
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("usr1999@qq.com"));
// 设置邮件主题:
            message.setSubject("Hello, usr1999, 这是一个异常", "UTF-8");
// 设置邮件正文:
            message.setText("Hi Xiaoming...这是一个异常", "UTF-8");
// 发送:
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
