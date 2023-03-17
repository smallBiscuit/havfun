package com.aristo.hklistco.service.config;

import org.springframework.context.annotation.Bean;

import com.aristo.hklistco.email.TestEmailSender;
import com.havfun.service.email.EmailSender;

public class HklistcoEmailSenderTestConfig {
	
	@Bean
	public EmailSender emailSender() {
		TestEmailSender emailSender = new TestEmailSender();
		return emailSender;
	}

}
