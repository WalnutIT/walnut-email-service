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
package com.walnutit.email.cors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.walnutit.email.infrastructure.cors.CorsParameter;

/**
 * @author Daniel Krentzlin
 *
 */
@SpringBootTest(properties = {
		"management.endpoints.web.cors.allow-credentials=true",
		"management.endpoints.web.cors.allowed-origins=*",
		"management.endpoints.web.cors.allowed-headers=*",
		"management.endpoints.web.cors.allowed-methods=*",
		"management.endpoints.web.cors.cors-configuration-source=/**", })
class CORSAdviceTest {

	@Autowired
	CorsParameter actualCorsParamterObject;

	@Test
	final void testCorsParamter() {
		// given
		boolean expectedAllowedCredentials = true;
		String expectedAllowedOrigins = "*";
		String expectedAllowedHeaders = "*";
		String expectedAllowedMethods = "*";
		String expectedCorsConfigurationSource = "/**";
		List<Object> expectedCorsParameters = createObjectList(
				expectedAllowedCredentials, expectedAllowedOrigins,
				expectedAllowedHeaders, expectedAllowedMethods,
				expectedCorsConfigurationSource);
		// when
		boolean actualAllowedCredentials = actualCorsParamterObject
				.isAllowCredentials();
		String actualAllowedOrigins = actualCorsParamterObject
				.getAllowedOrigins();
		String actualAllowedHeaders = actualCorsParamterObject
				.getAllowedHeader();
		String actualAllowedMethods = actualCorsParamterObject
				.getAllowedMethods();
		String actualCorsConfigurationSource = actualCorsParamterObject
				.getCorsConfigurationSource();
		List<Object> actualCorsParameters = createObjectList(
				actualAllowedCredentials, actualAllowedOrigins,
				actualAllowedHeaders, actualAllowedMethods,
				actualCorsConfigurationSource);

		// then
		assertThat(actualCorsParameters).usingRecursiveComparison()
				.isEqualTo(expectedCorsParameters);
	}

	private List<Object> createObjectList(boolean allowedCredential,
			String allowedOrigins, String allowedHeader,
			String allowedMethods, String corsConfigurationsSource) {

		List<Object> corsParameters = new ArrayList<>();
		corsParameters.add(allowedCredential);
		corsParameters.add(allowedOrigins);
		corsParameters.add(allowedHeader);
		corsParameters.add(allowedMethods);
		corsParameters.add(corsConfigurationsSource);

		return corsParameters;

	}

}
