package com.example.registration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Registration implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank
	private String username;
	
	@NotBlank
	private String postCode;
	
	@Email
	private String email;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return getUsername().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Registration){
			Registration registration = (Registration)obj;
			return getUsername().equals(registration.getUsername());
		}
		return false;
	}
}
