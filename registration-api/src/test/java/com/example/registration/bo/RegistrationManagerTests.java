package com.example.registration.bo;

import org.junit.Assert;
import org.mockito.Mockito;

import com.example.registration.bo.RegistrationManager;
import com.example.registration.exception.RegistrationException;
import com.example.registration.model.Registration;

public class RegistrationManagerTests {
	
	public static void testContext(
			RegistrationManager registrationManager){
		Assert.assertNotNull(registrationManager);
	}
	
	public static void testAddRegistration(
			RegistrationManager registrationManager) throws RegistrationException{
		Registration registration = new Registration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.co.uk");
		registration.setPostCode("E13EE");
		
		String domain = "com-en";
		registrationManager.addRegistration(registration, domain);
		Assert.assertEquals(1, registrationManager.getRegistrations().size());
	}
	
	public static void testAddRegistrationValidationErrorNullRegistration(
			RegistrationManager registrationManager) throws RegistrationException{
		Registration registration = Mockito.mock(Registration.class);
		String domain = "com-en";
		registrationManager.addRegistration(registration, domain);
	}
	
	public static void testAddRegistrationValidationNullDomain(
			RegistrationManager registrationManager) throws RegistrationException{
		Registration registration = Mockito.mock(Registration.class);
		registrationManager.addRegistration(registration, null);
	}
	
	public static void testAddRegistrationValidationNullId(
			RegistrationManager registrationManager) throws RegistrationException{
		Registration registration = new Registration();
		registration.setEmail("user1@mail.co.uk");
		registration.setPostCode("E13EE");
		registrationManager.addRegistration(registration, null);
	}
	
	public static void testAddRegistrationValidationDomainValidation(RegistrationManager registrationManager) throws RegistrationException{
		Registration registration = new Registration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.es");
		registration.setPostCode("E13EE");
		
		String domain = "com-en";
		registrationManager.addRegistration(registration, domain);
	}
}
