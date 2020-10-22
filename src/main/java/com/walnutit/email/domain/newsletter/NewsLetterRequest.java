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
package com.walnutit.email.domain.newsletter;

import org.springframework.stereotype.Component;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class NewsLetterRequest {

	private String email;
	private boolean acceptedPrivacyPolicy;
	private String locale;

	public NewsLetterRequest(String email,
			boolean acceptedPrivacyPolicy, String locale) {
		super();
		this.email = email;
		this.acceptedPrivacyPolicy = acceptedPrivacyPolicy;
		this.setLocale(locale);
	}

	public NewsLetterRequest() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the acceptedPrivacyPolicy
	 */
	public boolean isAcceptedPrivacyPolicy() {
		return acceptedPrivacyPolicy;
	}

	/**
	 * @param acceptedPrivacyPolicy the acceptedPrivacyPolicy to set
	 */
	public void setAcceptedPrivacyPolicy(
			boolean acceptedPrivacyPolicy) {
		this.acceptedPrivacyPolicy = acceptedPrivacyPolicy;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}
	

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

}
