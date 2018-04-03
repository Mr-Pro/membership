package cn.lger.web;

import cn.lger.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-20.
 */
@Controller
@PropertySource("classpath:emailConfig.properties")
public class BirthdayWarningController {

    @Resource
    private MemberService memberService;

    @Value("${email.account}")
    private String emailAccount;
    @Value("${email.password}")
    private String emailPassword;
    @Value("${email.smtp}")
    private String emailSmtp;

    @GetMapping("/birthdayWarning")
    public String getBirthdayWarningView(Map<String, Object> model){
        if (memberService.findBirthdayToday().size()==0){
            model.put("msg", "null");
        }
        return "birthdayWarning";
    }

    @PostMapping("/birthdayWarning")
    @ResponseBody
    public String birthdayWarning(String content){

        try {
//            System.out.println(content);
            Properties props = new Properties();                    // 参数配置
            props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
            props.setProperty("mail.smtp.host", emailSmtp);   // 发件人的邮箱的 SMTP 服务器地址
            props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
            Session session = Session.getInstance(props);
            session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
            List<String> receiveMailAccounts = memberService.findBirthdayToday();


            for (String receiveMailAccount : receiveMailAccounts){
                Transport transport = session.getTransport();
                MimeMessage message = createMimeMessage(session, emailAccount, receiveMailAccount,content);
                transport.connect(emailAccount, emailPassword);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "error";

        }
        return "success";
    }

    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String content) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, "测试JMail", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "亲爱的 先生/小姐", "UTF-8"));
        message.setSubject("生日快乐", "UTF-8");
        message.setContent(content, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}
