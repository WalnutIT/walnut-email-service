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
package com.walnutit.email.domain.contactform.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walnutit.email.application.language.I18N;
import com.walnutit.email.domain.CustomerMessage;
import com.walnutit.email.domain.contactform.ContactFormRequest;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class ContactFormCustomerMessage extends CustomerMessage {

	@Autowired
	I18N i18N;

	private ContactFormRequest contactFormRequest;

	public void setContactFormRequest(
			ContactFormRequest contactFormRequest) {
		this.contactFormRequest = contactFormRequest;
	}

	@Override
	public String getMessageForCustomer() {

		Locale locale = contactFormRequest.getLocale();

		StringBuilder sb = new StringBuilder();

		// Step 1: salutation
		Object[] argsStep1 = new Object[] {
				contactFormRequest.getName() };
		sb.append(i18N.getMessageResource().getMessage(
				"contactform.customer.salutation", argsStep1,
				locale));

		// Step 2: message
		sb.append(i18N.getMessageResource().getMessage(
				"contactform.customer.message", null, locale));

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
