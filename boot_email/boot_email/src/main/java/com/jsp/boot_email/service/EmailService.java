package com.jsp.boot_email.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailList;
import com.jsp.boot_email.dto.FileAttachment;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailsender;

	
	// sending simple email
	public void sendmsg(Email mail) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(mail.getTo());
		msg.setSubject(mail.getSubject());
		msg.setText(mail.getBody());
		msg.setFrom("palojitejasree@gmail.com");
		mailsender.send(msg);
	}
	
	
    //sending for multiple recipients
	public void sendmsgs(EmailList list) {
		// TODO Auto-generated method stub
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(list.getTo());
		msg.setSubject(list.getSubject());
		msg.setText(list.getBody());
		msg.setFrom("palojitejasree@gmail.com");
		mailsender.send(msg);
		
	}
	

	public void sendEmailWithAttachment(FileAttachment file) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage msg = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(file.getTo());
		helper.setSubject(file.getSubject());
		helper.setText(file.getBody());
		helper.setFrom("palojitejasree@gmail.com");

		FileSystemResource file1 = new FileSystemResource(new File(file.getAttachment()));
		helper.addAttachment("attachment.jpg", file1);

		mailsender.send(msg);
		
	}
	
	

	public void sendHtmlEmail(Email mail) throws MessagingException {
	    MimeMessage message = mailsender.createMimeMessage();

	    message.setFrom(new InternetAddress("palojitejasree@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, "priyankasandamalla3@gmail.com");
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
	                         "<p>It can contain <strong>HTML</strong> content.</p>";
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailsender.send(message);
	}

}
