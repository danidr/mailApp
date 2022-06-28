package com.gbtech.mail;

import com.gbtech.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailApplication {

	@Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}

}
