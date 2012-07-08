package com.example.registration.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;

import com.example.registration.model.WebRegistration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/context.xml"})
public class RegistrationFormControllerTest {

	@Autowired
	private RegistrationFormController controller;
	
	@Test
	public void testContext(){
		Assert.assertNotNull(controller);
	}
	
	@Test
	public void testShowForm(){
		Map<String, Object> model = new HashMap<String, Object>();
		String result = controller.showForm(model);
		Assert.assertEquals("registrationForm", result);
		Assert.assertNotNull(model.get("registrationForm"));
	}
	
	@Test
	public void testSaveRegistration(){
		BindingResult bindingResult = Mockito.mock(BindingResult.class);
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);

		WebRegistration registration = new WebRegistration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.co.uk");
		registration.setPostCode("E13EE");
		registration.setDomain("com-en");
		
		Map<String, ? extends Object> result = controller.saveRegistration(registration, bindingResult, Locale.ENGLISH);
		Assert.assertTrue((Boolean)result.get("success"));
	}
	
	@Test
	public void testSaveRegistrationErrorDomain(){
		BindingResult bindingResult = Mockito.mock(BindingResult.class);
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		
		WebRegistration registration = new WebRegistration();
		registration.setUsername("user1");
		registration.setEmail("user1@mail.es");
		registration.setPostCode("E13EE");
		registration.setDomain("com-en");
		
		Map<String, ? extends Object> result = controller.saveRegistration(registration, bindingResult, Locale.ENGLISH);
		Assert.assertFalse((Boolean)result.get("success"));
	}
	
	@Test
	public void testSaveRegistrationErrorRequired(){
		BindingResult bindingResult = Mockito.mock(BindingResult.class);
		Mockito.when(bindingResult.hasErrors()).thenReturn(true);
		WebRegistration registration = Mockito.mock(WebRegistration.class);
		
		Map<String, ? extends Object> result = controller.saveRegistration(registration, bindingResult, Locale.ENGLISH);
		Assert.assertFalse((Boolean)result.get("success"));
	}
}
