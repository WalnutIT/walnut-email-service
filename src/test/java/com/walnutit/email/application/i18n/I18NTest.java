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
package com.walnutit.email.application.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.walnutit.email.application.language.I18N;

/**
 * @author Daniel Krentzlin
 *
 */
@SpringBootTest
class I18NTest {
	
	@Autowired
	I18N i18N;

	@Test
	final void testWithArgs() {
		// Given
		String expectedMessage = "Sehr geehrte/r Daniel Krentzlin,\n\n";
		Object[] args = new Object[] {"Daniel Krentzlin"};
		
		// When
		String actualMessage = i18N.getMessageResource().getMessage("contactform.customer.salutation", args, new Locale("de"));
		
		// Then
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	final void testWithoutArgs() {
		// Given
		String expectedMessage = "Vielen herzlichen Dank!\n\n";
		
		// When
		String actualMessage = i18N.getMessageResource().getMessage("newsletter.customer.salutation", null, new Locale("de"));
		
		// Then
		assertEquals(expectedMessage, actualMessage);
	}

}
