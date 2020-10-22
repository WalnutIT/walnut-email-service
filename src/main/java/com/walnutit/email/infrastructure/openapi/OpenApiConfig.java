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
package com.walnutit.email.infrastructure.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author Daniel Krentzlin
 *
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {

		Contact contact = new Contact();

		contact.setName("Daniel Krentzlin");
		contact.setUrl("https://walnut-it.com");
		contact.setEmail("info@walnut-it.com");

		return new OpenAPI().components(new Components())
				.info(new Info().title("Walnut Email Service API")
						.description(
								"The Walnut Email Service is a SMTP mail service which allow to trigger email messages to you and your customer, e. g. in case of request or newsletter registration")
						.contact(contact)

						.version("1.0.0"));
	}

}
