package com.example.registration.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.registration.dao.RegistrationDao;
import com.example.registration.exception.RegistrationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/jpa/bd-context.xml"})
@TransactionConfiguration
@Transactional
public class BDRegistrationDaoTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	protected RegistrationDao registrationDao;
	
	@Test
	public void testContext(){
		RegistrationDaoTests.testContext(registrationDao);
	}
	
	@Test
	public void testSave() throws RegistrationException{
		RegistrationDaoTests.testSave(registrationDao);
	}
	
	@Test
	public void testRemove() throws RegistrationException{
		RegistrationDaoTests.testRemove(registrationDao);
	}
	
	@Test
	public void testUpdate() throws RegistrationException{
		RegistrationDaoTests.testUpdate(registrationDao);
	}

}
