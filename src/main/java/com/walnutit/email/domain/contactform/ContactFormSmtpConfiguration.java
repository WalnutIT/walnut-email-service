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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.walnutit.email.domain.SmtpConfiguration;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
@Qualifier("contactform")
@Primary
public class ContactFormSmtpConfiguration
		implements SmtpConfiguration {

	@Value("${walnut.contactform.smtp.username}")
	String userName;

	@Value("${walnut.contactform.smtp.password}")
	String password;

	@Value("${walnut.contactform.smtp.host}")
	String host;

	@Value("${walnut.contactform.smtp.port}")
	int port;

	@Value("${walnut.contactform.smtp.protocol}")
	String protocol;

	@Value("${walnut.contactform.smtp.properties.auth}")
	boolean auth;

	@Value("${walnut.contactform.smtp.properties.starttls.enable}")
	boolean starttls;

	@Value("${walnut.contactform.smtp.properties.debug}")
	boolean debug;

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public String getProtocol() {
		return protocol;
	}

	@Override
	public boolean isAuth() {
		return auth;
	}

	@Override
	public boolean isStarttls() {
		return starttls;
	}

	@Override
	public boolean isDebug() {
		return debug;
	}

}
