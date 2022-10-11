package com.cms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {

	private final JavaMailSender javaMailSender;
	private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	
	@Async
	public void send(String toEmail, String email) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
			mimeMessageHelper.setText(email, true);
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setSubject("Confirm your email");
			mimeMessageHelper.setFrom("joeapptestermail@gmail.com");
			javaMailSender.send(mimeMessage);
		}catch(MessagingException e) {
			LOGGER.error("failed to send email", e);
			throw new IllegalStateException("failed to send");
		}
	}
	
}
