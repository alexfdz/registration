package com.example.registration.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.registration.dao.RegistrationDao;
import com.example.registration.model.Registration;
import com.example.registration.model.Registrations;

public class XMLRegistrationDao implements RegistrationDao{
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private StreamSource source;
	
	private StreamResult result;
	
	public void delete(Registration registration) {
		if(registration != null){
			Registrations registrations =  getRegistrations();
			if(registrations != null && registrations.getRegistrations().contains(registration)){
				registrations.getRegistrations().remove(registration);
				marshaller.marshal(registrations, this.result);
			}
		}
	}

	public void save(Registration registration){
		Registrations registrations = getRegistrations();
		
		if(registrations != null){
			if(registrations.getRegistrations().contains(registration)){
				registrations.getRegistrations().remove(registration);
			}
			registrations.add(registration);
			marshaller.marshal(registrations, this.result);
		}
	}

	public List<Registration> getAll(){
		Registrations registrations =  getRegistrations();
		return registrations.getRegistrations();
	}
	
	
	private Registrations getRegistrations(){
		return (Registrations)marshaller.unmarshal(this.source);
	}
	
	@Override
	public void removeAll() {
		Registrations registrations = new Registrations();
		marshaller.marshal(registrations, this.result);
	}
	
	public void setFile(File file) {
		if(!file.exists()){
			try {
				FileUtils.touch(file);
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		}
		this.source = new StreamSource(file);
		this.result = new StreamResult(file);
	}
}
