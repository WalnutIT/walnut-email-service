/**
 * Copyright 2020 - 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walnutit.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walnutit.email.domain.ClientRequest;

/**
 * @author Daniel Krentzlin
 *
 */
@RestController
public class EmailController {

	@Autowired
	public JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	String username;
	
	@Value("${spring.mail.properties.request_receiver}")
	String receiver;
	
	@Value("${spring.mail.properties.request_subject}")
	String subject;
	

	@PostMapping("/contactform")
	public HttpStatus sendSimpleEmail (
			@RequestBody ClientRequest clientRequest) throws MailException{

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(username);
		message.setTo(receiver);
		message.setSubject(subject);
		message.setText(clientRequest.toString());

		this.emailSender.send(message);
		
		return HttpStatus.OK;
	}

}
