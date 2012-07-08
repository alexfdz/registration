package com.example.registration.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Registrations {
	
	@XmlElement(name="registration")
	private List<Registration> registrations;

	public List<Registration> getRegistrations() {
		if(registrations == null){
			registrations = new ArrayList<Registration>();
		}
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	
	public void add(Registration registration){
		getRegistrations().add(registration);
	}
}
