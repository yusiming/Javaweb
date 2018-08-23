package yu.commons;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: yusiming
 * @Date: 2018/8/22 15:18
 * @Description:
 */
public class MailUtils {
    private static String host;
    private static String username;
    private static String password;
    private static String from;
    private static String content;
    private static String subject;

    //加载配置文件
    static {
        InputStream resourceAsStream = MailUtils.class.getClassLoader().getResourceAsStream("mail.properties");
        try {
            // 私有的Properties
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            host = properties.getProperty("host");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            from = properties.getProperty("from");
            content = properties.getProperty("content");
            subject = properties.getProperty("subject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Session getSession() {
        Properties pro = new Properties();
        pro.setProperty("mail.host", host);
        pro.setProperty("mail.smtp.auth", "true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        return Session.getInstance(pro, authenticator);
    }

    /**
     * @Description: 将一封邮件发送给destination
     * @auther: yusiming
     * @date: 16:48 2018/8/22
     * @param: [destination]
     * @return: void
     */
    public static void sendMail(String destination) {
        Session session = getSession();
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            // 设置发件人
            mimeMessage.setFrom(new InternetAddress(from));
            // 设置收件人
            mimeMessage.setRecipients(Message.RecipientType.TO, destination);
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(content, "text/html;charset=utf-8");
            // 发邮件
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMailWithFile(String destination) {
        Session session = getSession();
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            // 设置发件人
            mimeMessage.setFrom(new InternetAddress(from));
            // 设置收件人
            mimeMessage.setRecipients(Message.RecipientType.TO, destination);
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(content, "text/html;charset=utf-8");
            // 创建MimeMultipart
            MimeMultipart mimeMultipart = new MimeMultipart();
            //
            MimeBodyPart part1 = new MimeBodyPart();
            part1.attachFile(new File("d:/虞四明.jpg"));
            part1.setFileName(MimeUtility.decodeText("虞四明.jpg"));
            mimeMultipart.addBodyPart(part1);
            mimeMessage.setContent(mimeMultipart);
            // 发邮件
            Transport.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
