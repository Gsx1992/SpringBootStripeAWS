package com.gsx.web.controllers;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsx.backend.service.EmailService;
import com.gsx.web.domain.frontend.FeedbackPojo;

@Controller
public class ContactController {
	
	private static final Logger LOG = Logger.getLogger("ContactController");
	
	public static final String FEEDBACK_MODEL_KEY = "feedback";
	public static final String CONTACT_US_VIEW_NAME = "contact/contact";
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactGet(ModelMap model) {
		FeedbackPojo feedback = new FeedbackPojo();
		model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedback);
		return ContactController.CONTACT_US_VIEW_NAME;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback){
		emailService.sendFeedbackEmail(feedback);
		return ContactController.CONTACT_US_VIEW_NAME;
	}
	
	

}
