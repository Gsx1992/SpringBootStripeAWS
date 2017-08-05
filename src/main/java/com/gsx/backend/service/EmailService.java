package com.gsx.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.gsx.web.domain.frontend.FeedbackPojo;

public interface EmailService {
	
	/**
	 * Sends an email with the content in the Feedback object
	 * @param feedback
	 */
	
	public void sendFeedbackEmail(FeedbackPojo feedback);
	
	
	/**
	 * Sends an email with the content of the Simple Mail Message object
	 * @param message the object with the email content
	 */
	public void sendGenericEmailMessage(SimpleMailMessage message);

}
