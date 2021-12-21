package com.sequoia.shorturl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
 * @Description: 邮件工具类
 * @Author: jzq
 * @Create: 2021/10/24
 */
public class MailUtil {

    private static Logger log = LoggerFactory.getLogger(com.sequoia.shorturl.util.MailUtil.class);

    public static void warn(String receiver, String title, Exception exception) {
        log.info("发送异常报警邮件, title: {}", title);
        // 服务器地址:
        String smtp = "smtp.163.com";
        // 登录用户名:
        String username = "error_warn@163.com";
        // 登录口令:
        String password = "error@2021";
        // 连接到SMTP服务器
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "25"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密

        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, "KLBTHPFXLSUYSDGS");
            }
        });
        // 设置debug模式便于调试:
        //session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            // 设置发送方地址:
            message.setFrom(new InternetAddress("error_warn@163.com"));
            // 设置接收方地址:
            String mailReceiver = receiver != null ? receiver : "usr1999@qq.com";
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailReceiver));
            // 设置邮件主题:
            message.setSubject(title, "UTF-8");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            String content = sw.toString();

            // 设置邮件正文:
            message.setText(content, "UTF-8");
            // 发送:
            Transport.send(message);
            log.info("报警邮件发送成功");
        } catch (Exception e) {
            log.error("邮件发送异常, receiver: {}", receiver, e);
        }
    }

}
