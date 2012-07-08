package com.example.registration.model;

import org.hibernate.validator.constraints.NotBlank;

import com.example.registration.model.Registration;

public class WebRegistration extends Registration{

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String domain;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
