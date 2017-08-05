package com.gsx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.gsx.backend.service.EmailService;
import com.gsx.backend.service.MockEmailService;

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.devproj/application-dev.properties")
public class DevelopmentConfig {
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
