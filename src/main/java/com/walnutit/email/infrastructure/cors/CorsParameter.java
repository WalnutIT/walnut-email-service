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
package com.walnutit.email.infrastructure.cors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Daniel Krentzlin
 *
 */
@Component
public class CorsParameter {

	@Value("${management.endpoints.web.cors.allow-credentials}")
	boolean allowCredentials;

	@Value("${management.endpoints.web.cors.allowed-origins}")
	String allowedOrigins;

	@Value("${management.endpoints.web.cors.allowed-headers}")
	String allowedHeader;

	@Value("${management.endpoints.web.cors.allowed-methods}")
	String allowedMethods;

	@Value("${management.endpoints.web.cors.cors-configuration-source}")
	String corsConfigurationSource;

	public boolean isAllowCredentials() {
		return allowCredentials;
	}

	public String getAllowedOrigins() {
		return allowedOrigins;
	}

	public String getAllowedHeader() {
		return allowedHeader;
	}

	public String getAllowedMethods() {
		return allowedMethods;
	}

	public String getCorsConfigurationSource() {
		return corsConfigurationSource;
	}

}
