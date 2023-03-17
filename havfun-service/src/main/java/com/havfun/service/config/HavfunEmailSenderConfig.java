package com.havfun.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.havfun.service.email.EmailSender;
import com.havfun.service.email.EmailSenderImpl;

@Configuration
public class HavfunEmailSenderConfig {
	
	@Value("${emailSender.host}")
	private String host;
	
	@Value("${emailSender.port}")
	private String port;

	@Value("${emailSender.sender}")
	private String sender;
	
	@Value("${emailSender.password}")
	private String password;
	
	@Bean
	public EmailSender emailSender() {
		EmailSenderImpl emailSender = new EmailSenderImpl();
		emailSender.setHost(host);
		emailSender.setPort(port);
		emailSender.setSender(sender);
		emailSender.setPassword(password);
		return emailSender;
	}

}
