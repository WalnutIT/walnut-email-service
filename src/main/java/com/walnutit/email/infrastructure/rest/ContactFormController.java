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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walnutit.email.domain.SmtpConfiguration;
import com.walnutit.email.domain.contactform.ContactFormEmailConfiguration;
import com.walnutit.email.domain.contactform.ContactFormRequest;
import com.walnutit.email.domain.contactform.messages.ContactFormCompanyMessage;
import com.walnutit.email.domain.contactform.messages.ContactFormCustomerMessage;

/**
 * @author Daniel Krentzlin
 *
 */
@RestController
public class ContactFormController extends Controller {

	public static final Logger LOG = LoggerFactory
			.getLogger(ContactFormController.class);

	@Autowired
	public ContactFormEmailConfiguration contactFormEmailConfiguration;

	@Autowired
	@Qualifier("contactform")
	public SmtpConfiguration conntactFormSmptConfiguration;

	@Autowired
	public ContactFormCompanyMessage contactFormCompanyMessage;

	@Autowired
	public ContactFormCustomerMessage contactFormCustomerMessage;

	@PostMapping("/contactform")
	public HttpStatus sendContactFormNotfication(
			@RequestBody ContactFormRequest contactFormRequest) {

		contactFormCompanyMessage
				.setContactFormRequest(contactFormRequest);
		contactFormCustomerMessage
				.setContactFormRequest(contactFormRequest);

		SimpleMailMessage companyMessage = new SimpleMailMessage();
		companyMessage
				.setFrom(contactFormEmailConfiguration.getUsername());
		companyMessage
				.setTo(contactFormEmailConfiguration.getReceiver());
		companyMessage.setSubject(
				contactFormEmailConfiguration.getSubject());
		companyMessage.setText(
				contactFormCompanyMessage.getMessageForCompany());

		SimpleMailMessage customerMessage = new SimpleMailMessage();
		customerMessage
				.setFrom(contactFormEmailConfiguration.getUsername());
		customerMessage
				.setTo(contactFormRequest.getEmail());
		customerMessage.setSubject(
				contactFormEmailConfiguration.getSubject());
		customerMessage.setText(
				contactFormCustomerMessage.getMessageForCustomer());

		try {
			mailSender.getJavaMailSender().send(companyMessage);
			mailSender.getJavaMailSender().send(customerMessage);
			return HttpStatus.OK;
		} catch (Exception me) {
			LOG.error("Couldn't send message: ", me);
			return HttpStatus.INTERNAL_SERVER_ERROR;

		}

	}

}
