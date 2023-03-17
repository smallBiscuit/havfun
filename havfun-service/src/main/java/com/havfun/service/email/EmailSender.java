package com.havfun.service.email;

public interface EmailSender {

	public boolean sendMail(String to, String subject, String content);
	
}
