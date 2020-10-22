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
import com.walnutit.email.domain.CompanyMessage;
import com.walnutit.email.domain.contactform.ContactFormRequest;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class ContactFormCompanyMessage extends CompanyMessage {

	@Autowired
	I18N i18N;

	private ContactFormRequest contactFormRequest;

	public void setContactFormRequest(
			ContactFormRequest contactFormRequest) {
		this.contactFormRequest = contactFormRequest;
	}

	@Override
	public String getMessageForCompany() {
		Locale locale = new Locale(contactFormRequest.getLocale());
		String name = contactFormRequest.getName();
		String email = contactFormRequest.getEmail();
		String phone = contactFormRequest.getPhone();
		String company = contactFormRequest.getCompany();
		String companyUrl = contactFormRequest.getUrl();
		String request = contactFormRequest.getRequest();

		StringBuilder sb = new StringBuilder();

		// Step 1: salutation
		sb.append(i18N.getMessageResource().getMessage(
				"contactform.company.salutation", null, locale));

		// Step 2: message
		Object[] step2args = new Object[] { name, request, phone,
				email };
		sb.append(i18N.getMessageResource().getMessage(
				"contactform.company.message", step2args, locale));

		// Step 3: optional
		Object[] step3args = new Object[] { company, companyUrl };
		sb.append(i18N.getMessageResource().getMessage(
				"contactform.company.optional", step3args, locale));

		// Step 4: farewell
		sb.append(i18N.getMessageResource()
				.getMessage("general.phrase.farewell", null, locale));

		// Step 5: customer name
		Object[] step5args = new Object[] { name };
		sb.append(i18N.getMessageResource().getMessage(
				"contactform.company.customer", step5args, locale));

		return sb.toString();
	}

}
