package com.aristo.hklistco.email;

import com.havfun.service.email.EmailSender;

public class TestEmailSender implements EmailSender {

	@Override
	public boolean sendMail(String to, String subject, String content) {
		return true;
	}

}
