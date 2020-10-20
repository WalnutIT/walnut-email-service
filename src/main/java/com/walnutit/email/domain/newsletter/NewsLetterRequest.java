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

/**
 * @author Daniel Krentzlin
 *
 */
public class NewsLetterRequest {

	private String email;
	private boolean acceptedPrivacyPolicy;

	public NewsLetterRequest(String email, boolean acceptedPrivacyPolicy) {
		super();
		this.email = email;
		this.acceptedPrivacyPolicy = acceptedPrivacyPolicy;
	}

	public NewsLetterRequest() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NewsLetterRequest [\n\temail=" + email + "\n "
				+ "\taccepted privacy policy=" + acceptedPrivacyPolicy
				+ "]";
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

}
