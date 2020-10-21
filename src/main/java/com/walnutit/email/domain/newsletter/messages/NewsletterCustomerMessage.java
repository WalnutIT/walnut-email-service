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
package com.walnutit.email.domain.newsletter.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walnutit.email.application.language.I18N;
import com.walnutit.email.domain.CustomerMessage;
import com.walnutit.email.domain.newsletter.NewsLetterRequest;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class NewsletterCustomerMessage extends CustomerMessage {

	@Autowired
	I18N i18N;
	
	private NewsLetterRequest newsLetterRequest;

	public void setNewsLetterRequest(
			NewsLetterRequest newsLetterRequest) {
		this.newsLetterRequest = newsLetterRequest;
	}

	@Override
	public String getMessageForCustomer() {
		
		Locale locale = newsLetterRequest.getLocale();
		String email = newsLetterRequest.getEmail();
		
		StringBuilder sb = new StringBuilder();
		// Step 1: salutation
		sb.append(i18N.getMessageResource().getMessage(
				"newsletter.customer.salutation", null, locale));
		// Step 2: message
		Object[] args = new Object[] { email };
		sb.append(i18N.getMessageResource().getMessage(
				"newsletter.customer.message", args, locale));
		// Step 3: inquiry
		sb.append(i18N.getMessageResource()
				.getMessage("general.phrase.inquery", null, locale));
		// Step 4: farewell
		sb.append(i18N.getMessageResource()
				.getMessage("general.phrase.farewell", null, locale));
		// Step 5: name
		sb.append(i18N.getMessageResource()
				.getMessage("general.name.krentzlin", null, locale));
		// Step 6: signature
		sb.append(i18N.getMessageResource()
				.getMessage("general.signature", null, locale));

		return sb.toString();
	}

}
