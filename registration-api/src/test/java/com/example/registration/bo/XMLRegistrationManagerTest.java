package com.example.registration.bo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.registration.exception.RegistrationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/jaxb/xml-context.xml"})
public class XMLRegistrationManagerTest{
	
	@Autowired
	public RegistrationManager registrationManager;
	
	@Before
	public void initXMLFile(){
		registrationManager.removeAll();
	}
	
	@Test
	public void testContext(){
		RegistrationManagerTests.testContext(registrationManager);
	}
	
	@Test
	public void testAddRegistration() throws RegistrationException{
		RegistrationManagerTests.testAddRegistration(registrationManager);
	}
	
	@Test(expected = RegistrationException.class)
	public void testAddRegistrationValidationErrorNullRegistration() throws RegistrationException{
		RegistrationManagerTests.testAddRegistrationValidationErrorNullRegistration(registrationManager);
	}
	
	@Test(expected = RegistrationException.class)
	public void testAddRegistrationValidationNullDomain() throws RegistrationException{
		RegistrationManagerTests.testAddRegistrationValidationNullDomain(registrationManager);
	}
	
	@Test(expected = RegistrationException.class)
	public void testAddRegistrationValidationNullId() throws RegistrationException{
		RegistrationManagerTests.testAddRegistrationValidationNullId(registrationManager);
	}
	
	@Test(expected = RegistrationException.class)
	public void testAddRegistrationValidationDomainValidation() throws RegistrationException{
		RegistrationManagerTests.testAddRegistrationValidationDomainValidation(registrationManager);
	}
}
