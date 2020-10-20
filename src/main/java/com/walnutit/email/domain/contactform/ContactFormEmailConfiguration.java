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
package com.walnutit.email.domain.contactform;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.walnutit.email.domain.DomainEmailConfiguration;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class ContactFormEmailConfiguration implements DomainEmailConfiguration{
	
	@Value("${walnut.contactform.smtp.username}")
	String username;
	
	@Value("${walnut.contactform.email.request_receiver}")
	String receiver;
	
	@Value("${walnut.contactform.email.request_subject}")
	String subject;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getReceiver() {
		return receiver;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	
	
	

}
