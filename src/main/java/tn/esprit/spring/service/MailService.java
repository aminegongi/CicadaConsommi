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
	 
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setFrom(From ); //"zeinebbl327@gmail.com"
	mail.setTo(To);
	mail.setSubject(Subject) ;
	mail.setText (Text);
	
	javaMailSender.send(mail) ; 
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
     
}}
