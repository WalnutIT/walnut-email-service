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
package com.walnutit.email.infrastructure.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walnutit.email.application.MailSenderLogger;
import com.walnutit.email.domain.newsletter.NewsLetterEmailConfiguration;
import com.walnutit.email.domain.newsletter.NewsLetterRequest;
import com.walnutit.email.domain.newsletter.NewsLetterSmtpConfiguration;

/**
 * @author Daniel Krentzlin
 *
 */
@RestController
public class NewsLetterController {
	public static final Logger LOG = LoggerFactory
			.getLogger(ContactFormController.class);

	@Autowired
	public NewsLetterEmailConfiguration newsLetterEmailConfiguration;

	@Autowired
	public NewsLetterSmtpConfiguration newsLetterSmtpConfiguration;

	@PostMapping("/newsletter")
	public HttpStatus sendNewsLetterNotfication(
			@RequestBody NewsLetterRequest newsLetterRequest) {

		MailSenderLogger logger = new MailSenderLogger(
				newsLetterSmtpConfiguration);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(newsLetterEmailConfiguration.getUsername());
		message.setTo(newsLetterEmailConfiguration.getReceiver());
		// message.setCc(contactFormRequest.getEmail());
		message.setSubject(newsLetterEmailConfiguration.getSubject());
		message.setText(newsLetterRequest.toString());

		try {
			logger.getJavaMailSender().send(message);
			return HttpStatus.OK;
		} catch (Exception me) {
			LOG.error("Couldn't send message: ", me);
			return HttpStatus.INTERNAL_SERVER_ERROR;

		}

	}
}
