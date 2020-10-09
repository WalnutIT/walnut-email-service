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
package com.walnutit.email.domain;

/**
 * @author Daniel Krentzlin
 *
 */
public class ClientRequest {

	private String name;
	private String email;
	private String phone;
	private String company;
	private String url;
	private String request;

	public ClientRequest(String name, String email, String phone,
			String company, String url, String request) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.url = url;
		this.request = request;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getCompany() {
		return company;
	}

	public String getUrl() {
		return url;
	}

	public String getRequest() {
		return request;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "ClientRequest [\n\tname=" + name + ",\n\temail=" + email
				+ ",\n\tphone=" + phone + ",\n\tcompany=" + company
				+ ",\n\turl=" + url + ",\n\trequest=" + request + "\n]";
	}

	
	
}
