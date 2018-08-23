package yu.JavaMail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Auther: yusiming
 * @Date: 2018/8/22 13:43
 * @Description:
 */
public class Demo1 {
    /**
     * @Description:
     * 1.session类，若得到该类，表示于服务器已经建立了连接
     * 2.MimeMessage，表示一个邮件对象，调用setFrom()一系列方法，设置发件人，设置收件人，设置主题，正文
     * 3.TransPort， 只有一个功能，发邮件 send方法
     * @auther: yusiming
     * @date: 13:44 2018/8/22
     * @param: []
     * @return: void
     */
    public void sendMail() {
        // 得到session对象
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");
        javax.mail.Authenticator authenticator = new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("yusimingQAQ","ysm1997830");
            }
        };
        Session session = Session.getInstance(properties, authenticator);
        // 创建MimeMessage
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            // 设置发件人
            mimeMessage.setFrom(new InternetAddress("yusimingQAQ@163.com"));
            // 设置收件人
            mimeMessage.setRecipients(Message.RecipientType.TO,"2283375386@qq.com");
            //
            mimeMessage.setSubject("邮件测试");
            mimeMessage.setContent("虞四明的邮件测试","text/html;charset=utf-8");
            // 发邮件
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        // 发邮件
    }
}
