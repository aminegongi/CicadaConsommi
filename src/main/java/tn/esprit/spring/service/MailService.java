package tn.esprit.spring.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;

@Service
public class MailService {
	private JavaMailSender javaMailSender ;
	
@Autowired
public MailService(JavaMailSender javaMailSender) {
	this.javaMailSender = javaMailSender;
}

public void sendEmail(String From , String To , String Subject , String Text) throws MailException {
	 
	/*SimpleMailMessage mail = new SimpleMailMessage();
	mail.setFrom(From ); //"zeinebbl327@gmail.com"
	mail.setTo(To);
	mail.setSubject(Subject) ;
	mail.setText (Text);
	javaMailSender.send(mail) ;*/
	
	MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
     
    try {
	helper.setFrom(From, "Consommi Tounsi");
    helper.setTo(To);
    helper.setSubject(Subject);
    
    helper.setText(Text, true);
     
    javaMailSender.send(message);
    } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void sendEmailWithAttachment() throws MailException, MessagingException {

	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	
	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	helper.setTo("zeinebmailpi@gmail.com");
	helper.setSubject("Testing Mail  with Attachment");
	helper.setText("Please find the attached document below .");

	ClassPathResource classPathResource = new ClassPathResource("C://Users//MSI//test.jpg");
	helper.addAttachment(classPathResource.getFilename(), classPathResource);

	javaMailSender.send(mimeMessage) ;
}
public void sendVerificationEmail(User user)
        throws MessagingException, UnsupportedEncodingException {
    String toAddress = user.getEmail();
    String fromAddress = "zeinebbl327@gmail.com";
    String senderName = "Consommi Tounsi";
    String subject = "Please verify your registration";
    String content = "Dear [[name]],<br>"
            + "Please click the link below to verify your registration:<br>"
            +"http://[[URL]]" 
            + "<br>Thank you,<br>"
            + "Consommi Tounsi.";
     
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
     
    helper.setFrom(fromAddress, senderName);
    helper.setTo(toAddress);
    helper.setSubject(subject);
     
    content = content.replace("[[name]]", user.getUsername());
    String verifyURL = "localhost:8081" + "/api/auth/verify?code=" + user.getVerificationCode();
     
    content = content.replace("[[URL]]", verifyURL);
     
    helper.setText(content, true);
     
    javaMailSender.send(message);
     
}
public void sendresetpwd(User user)
        throws MessagingException, UnsupportedEncodingException {
	String link="http://localhost:8081/pages/client/resetpwd.jsf?token="+user.getVerificationCode();
    String toAddress = user.getEmail();
    String fromAddress = "zeinebbl327@gmail.com";
    String senderName = "Consommi Tounsi";
    String subject = "Here's the link to reset your password";
    String content = "<p>Hello,</p>"
            + "<p>You have requested to reset your password.</p>"
            + "<p>Click the link below to change your password:</p>"
            + "<p><a href=\"" + link + "\">Change my password</a></p>"
            + "<br>"
            + "<p>Ignore this email if you do remember your password, "
            + "or you have not made the request.</p>";
     
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
     
    helper.setFrom(fromAddress, senderName);
    helper.setTo(toAddress);
    helper.setSubject(subject);
     
    content = content.replace("[[name]]", user.getUsername());
    String verifyURL = "localhost:8081" + "/api/auth/verify?code=" + user.getVerificationCode();
     
    content = content.replace("[[URL]]", verifyURL);
     
    helper.setText(content, true);
     
    javaMailSender.send(message);
     
}
public void sendresetpwdb(User user)
        throws MessagingException, UnsupportedEncodingException {
	String link="http://localhost:8081/template/Back/resetpwd.jsf?token="+user.getVerificationCode();
    String toAddress = user.getEmail();
    String fromAddress = "zeinebbl327@gmail.com";
    String senderName = "Consommi Tounsi";
    String subject = "Here's the link to reset your password";
    String content = "<p>Hello,</p>"
            + "<p>You have requested to reset your password.</p>"
            + "<p>Click the link below to change your password:</p>"
            + "<p><a href=\"" + link + "\">Change my password</a></p>"
            + "<br>"
            + "<p>Ignore this email if you do remember your password, "
            + "or you have not made the request.</p>";
     
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
     
    helper.setFrom(fromAddress, senderName);
    helper.setTo(toAddress);
    helper.setSubject(subject);
     
    content = content.replace("[[name]]", user.getUsername());
    String verifyURL = "localhost:8081" + "/api/auth/verify?code=" + user.getVerificationCode();
     
    content = content.replace("[[URL]]", verifyURL);
     
    helper.setText(content, true);
     
    javaMailSender.send(message);
     
}
}
