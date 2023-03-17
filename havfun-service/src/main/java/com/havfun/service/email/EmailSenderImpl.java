package com.havfun.service.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailSenderImpl  implements EmailSender {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(EmailSender.class.getSimpleName());
	
	private String host;
	
	private String port;
	
	private String sender;
	
	private String password;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean sendMail(String to, String subject, String content) {
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.socketFactory.port", port);
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.starttls.enable", "true");
	      
		// Get the default Session object.
	    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    	      return new PasswordAuthentication(sender, password);
	    	    }
	    });
	    
	    try{
	    	
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(sender));
			
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
			                          new InternetAddress(to));
			
			// Set Subject: header field
			message.setSubject(subject, "UTF-8");

			// Fill the message
			message.setContent(content, "text/html; charset=UTF-8");
			
			// Send message
			LOGGER.info("sending email...");
			Transport.send(message);
			LOGGER.info("Sent message successfully....");
	    }catch (MessagingException mex) {
	    	LOGGER.warn("MessagingException", mex);
	        return false;
	    }
	    
	    return true;
	}

}
