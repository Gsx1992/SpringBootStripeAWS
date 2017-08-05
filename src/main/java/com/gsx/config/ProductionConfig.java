package com.gsx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.gsx.backend.service.EmailService;
import com.gsx.backend.service.MockEmailService;
import com.gsx.backend.service.SmtpEmailService;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.devproj/application-prod.properties")
public class ProductionConfig {
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
