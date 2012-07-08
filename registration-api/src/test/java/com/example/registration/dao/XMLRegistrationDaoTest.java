package com.example.registration.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.registration.dao.RegistrationDao;
import com.example.registration.dao.impl.XMLRegistrationDao;
import com.example.registration.exception.RegistrationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/jaxb/xml-context.xml"})
public class XMLRegistrationDaoTest{

	@Autowired
	protected RegistrationDao registrationDao;
	
	@Before
	public void initXMLFile(){
		((XMLRegistrationDao)registrationDao).removeAll();
	}
	
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
