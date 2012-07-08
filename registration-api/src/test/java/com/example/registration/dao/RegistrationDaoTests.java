package com.example.registration.dao;

import java.util.List;

import org.junit.Assert;

import com.example.registration.dao.RegistrationDao;
import com.example.registration.exception.RegistrationException;
import com.example.registration.model.Registration;

public class RegistrationDaoTests {

	public static void testContext(RegistrationDao registrationDao){
		Assert.assertNotNull(registrationDao);
	}
	
	public static void testSave(RegistrationDao registrationDao) throws RegistrationException{
		Registration registration = new Registration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.co.uk");
		registration.setPostCode("E13EE");
		
		registrationDao.save(registration);
		Assert.assertEquals(1, registrationDao.getAll().size());
		
		registration = new Registration();
		registration.setUsername("user2");
		registration.setEmail("user2@mail.co.uk");
		registration.setPostCode("E12EE");
		
		registrationDao.save(registration);
		Assert.assertEquals(2, registrationDao.getAll().size());
	}
	

	public static void testRemove(RegistrationDao registrationDao) throws RegistrationException{
		Registration registration = new Registration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.co.uk");
		registration.setPostCode("E13EE");
		
		registrationDao.save(registration);
		Assert.assertEquals(1, registrationDao.getAll().size());
		
		registrationDao.delete(registration);
		Assert.assertTrue(registrationDao.getAll().isEmpty());
	}
	
	public static void testUpdate(RegistrationDao registrationDao) throws RegistrationException{
		Registration registration = new Registration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.co.uk");
		registration.setPostCode("E13EE");
		
		registrationDao.save(registration);
		Assert.assertEquals(1, registrationDao.getAll().size());
		
		String updatedEmail = "user1@mail.com";
		registration.setEmail(updatedEmail);
		registrationDao.save(registration);
		List<Registration>  registrations = registrationDao.getAll();
		
		Assert.assertEquals(1, registrations.size());
		Assert.assertEquals(updatedEmail, registrations.get(0).getEmail());
	}

}
