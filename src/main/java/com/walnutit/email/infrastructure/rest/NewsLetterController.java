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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walnutit.email.domain.SmtpConfiguration;
import com.walnutit.email.domain.newsletter.NewsLetterEmailConfiguration;
import com.walnutit.email.domain.newsletter.NewsLetterRequest;
import com.walnutit.email.domain.newsletter.messages.NewsletterCompanyMessage;
import com.walnutit.email.domain.newsletter.messages.NewsletterCustomerMessage;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Daniel Krentzlin
 *
 */
@RestController
@RequestMapping("/api")
@Tag(name = "newsletter", description = "the newsletter registration api")
public class NewsLetterController extends Controller {
	public static final Logger LOG = LoggerFactory
			.getLogger(ContactFormController.class);

	@Autowired
	public NewsLetterEmailConfiguration newsLetterEmailConfiguration;

	@Autowired
	@Qualifier("newsletter")
	public SmtpConfiguration newsLetterSmtpConfiguration;

	@Autowired
	public NewsletterCompanyMessage newsLetterCompanyMessage;

	@Autowired
	public NewsletterCustomerMessage newsLetterCustomerMessage;

	@PostMapping("/newsletter")
	public HttpStatus sendNewsLetterNotfication(
			@RequestBody NewsLetterRequest newsLetterRequest) {

		newsLetterCompanyMessage
				.setNewsLetterRequest(newsLetterRequest);
		newsLetterCustomerMessage
				.setNewsLetterRequest(newsLetterRequest);

		try {
			sendToCompany(newsLetterCompanyMessage,
					newsLetterEmailConfiguration);
			sendToCustomer(newsLetterCustomerMessage,
					newsLetterEmailConfiguration,
					newsLetterRequest.getEmail());
			return HttpStatus.OK;
		} catch (Exception me) {
			LOG.error("Couldn't send message: ", me);
			return HttpStatus.INTERNAL_SERVER_ERROR;

		}

	}
}
