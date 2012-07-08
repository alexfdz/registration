package com.example.registration.dao;

import java.util.List;

import com.example.registration.model.Registration;

public interface RegistrationDao {

	public void save(Registration registration);
	
	public void delete(Registration registration);

	public List<Registration> getAll();

	public void removeAll();
}
