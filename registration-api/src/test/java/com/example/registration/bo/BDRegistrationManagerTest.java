package com.example.registration.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.registration.bo.RegistrationManager;
import com.example.registration.exception.RegistrationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/jpa/bd-context.xml"})
@TransactionConfiguration
@Transactional
public class BDRegistrationManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	public RegistrationManager registrationManager;
	
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
