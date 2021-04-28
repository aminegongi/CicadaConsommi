package tn.esprit.spring.service;

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
}}
