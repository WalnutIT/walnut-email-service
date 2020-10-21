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
import com.walnutit.email.domain.CompanyMessage;
import com.walnutit.email.domain.newsletter.NewsLetterRequest;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class NewsletterCompanyMessage extends CompanyMessage {

	@Autowired
	I18N i18N;

	private NewsLetterRequest newsLetterRequest;

	public void setNewsLetterRequest(
			NewsLetterRequest newsLetterRequest) {
		this.newsLetterRequest = newsLetterRequest;
	}

	@Override
	public String getMessageForCompany() {

		Locale locale = newsLetterRequest.getLocale();
		String email = newsLetterRequest.getEmail();
		boolean acceptedPrivacyPolicy = newsLetterRequest
				.isAcceptedPrivacyPolicy();

		StringBuilder sb = new StringBuilder();
		// Step 1: salutation
		sb.append(i18N.getMessageResource().getMessage(
				"newsletter.company.salutation", null, locale));
		// Step 2: message
		Object[] step2Args = new Object[] { email };
		sb.append(i18N.getMessageResource().getMessage(
				"newsletter.company.message", step2Args, locale));
		// Step 3: privacy policy
		String accetedPrivacyPolicyAnswer = null;
		if (acceptedPrivacyPolicy) {
			accetedPrivacyPolicyAnswer = i18N.getMessageResource()
					.getMessage(
							"newsletter.company.privacy_policy.true",
							null, locale);
		} else {
			accetedPrivacyPolicyAnswer = i18N.getMessageResource()
					.getMessage(
							"newsletter.company.privacy_policy.false",
							null, locale);
		}
		Object[] step3Args = new Object[] {
				accetedPrivacyPolicyAnswer };
		sb.append(i18N.getMessageResource().getMessage(
				"newsletter.company.privacy_policy", step3Args,
				locale));

		return sb.toString();
	}

}
