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
package com.walnutit.email.application.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.walnutit.email.domain.SmtpConfiguration;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class MailSenderLogger implements MailSender {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MailSenderLogger.class);

	public MailSenderLogger(SmtpConfiguration smptConfiguration) {
		super();
		this.smptConfiguration = smptConfiguration;
	}

	private SmtpConfiguration smptConfiguration;

	
	public JavaMailSender getJavaMailSender() {

		MailSenderImpl mailConfiguration = new MailSenderImpl(
				smptConfiguration);

		LOGGER.info(this.toString());

		try {
			return mailConfiguration.getJavaMailSender();
		} catch (Exception e) {
			LOGGER.error(
					"Error during the creation of a Java MailSenderImpl",
					e);
			return null;
		}
	}

	@Override
	public String toString() {
		return "MailSenderLogger [userName="
				+ smptConfiguration.getUserName() + ", password="
				+ smptConfiguration.getPassword() + ", host="
				+ smptConfiguration.getHost() + ", port="
				+ smptConfiguration.getPort() + ", protocol="
				+ smptConfiguration.getProtocol() + ", auth="
				+ smptConfiguration.isAuth() + ", starttls="
				+ smptConfiguration.isStarttls() + ", debug="
				+ smptConfiguration.isDebug() + "]";
	}

}
