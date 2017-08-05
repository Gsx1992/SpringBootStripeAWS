package com.gsx.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.gsx.web.domain.frontend.FeedbackPojo;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.to.address}")
	private String defaultToAddress;
	
	protected SimpleMailMessage prepareSimpleMessage(FeedbackPojo feedback) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(defaultToAddress);
		message.setFrom(feedback.getEmail());
		message.setSubject("Test email from: "+feedback.getFirstName());
		message.setText(feedback.getFeedback());
		return message;
	}

	@Override
	public void sendFeedbackEmail(FeedbackPojo feedback) {
		sendGenericEmailMessage(prepareSimpleMessage(feedback));
		
	}

	
	
	

}
