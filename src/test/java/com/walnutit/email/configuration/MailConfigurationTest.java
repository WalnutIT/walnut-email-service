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
package com.walnutit.email.configuration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.walnutit.email.application.mail.MailSenderImpl;

/**
 * @author Daniel Krentzlin
 *
 */

@SpringBootTest(properties = { "spring.mail.username=testUsername",
		"spring.mail.password=testPassword",
		"spring.mail.host=testHost", "spring.mail.port=587",
		"spring.mail.protocol=smtp",
		"spring.mail.properties.auth=true",
		"spring.mail.properties.starttls.enable=true",
		"spring.mail.properties.debug=true" })
class MailConfigurationTest {

	@Autowired
	MailSenderImpl mailConfiguration;

	JavaMailSenderImpl expectedJavaMailSender;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		expectedJavaMailSender = new JavaMailSenderImpl();
		expectedJavaMailSender.setHost("testHost");
		expectedJavaMailSender.setPort(587);
		expectedJavaMailSender.setUsername("testUsername");
		expectedJavaMailSender.setPassword("testPassword");

		Properties props = expectedJavaMailSender
				.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", true);

	}

	/**
	 * Test method for
	 * {@link com.walnutit.email.application.MailSenderImpl#getJavaMailSender()}.
	 * @throws Exception 
	 */
	@Test
	final void testGetJavaMailSender() throws Exception {
		// given

		// when

		JavaMailSenderImpl actualJavaMailSender = (JavaMailSenderImpl) mailConfiguration
				.getJavaMailSender();

		String expectedProtocol = (String) expectedJavaMailSender
				.getJavaMailProperties()
				.get("mail.transport.protocol");

		String actualProtocol = (String) actualJavaMailSender
				.getJavaMailProperties()
				.get("mail.transport.protocol");

		Object authExpected = expectedJavaMailSender
				.getJavaMailProperties().get("mail.smtp.auth");
		Object authActual = actualJavaMailSender
				.getJavaMailProperties().get("mail.smtp.auth");

		Object debugExpected = expectedJavaMailSender
				.getJavaMailProperties().get("mail.debug");
		Object debugActual = actualJavaMailSender
				.getJavaMailProperties().get("mail.debug");

		Object starttlsExpected = expectedJavaMailSender
				.getJavaMailProperties()
				.get("mail.smtp.starttls.enable");
		Object starttlsActual = actualJavaMailSender
				.getJavaMailProperties()
				.get("mail.smtp.starttls.enable");

		// then
		assertEquals(expectedJavaMailSender.getUsername(),
				actualJavaMailSender.getUsername());
		assertEquals(expectedJavaMailSender.getPassword(),
				actualJavaMailSender.getPassword());
		assertEquals(expectedJavaMailSender.getHost(),
				actualJavaMailSender.getHost());
		assertEquals(expectedJavaMailSender.getPort(),
				actualJavaMailSender.getPort());

		assertEquals(expectedProtocol, actualProtocol);
		assertEquals(authExpected, authActual);
		assertEquals(debugExpected, debugActual);
		assertEquals(starttlsExpected, starttlsActual);

	}

}
