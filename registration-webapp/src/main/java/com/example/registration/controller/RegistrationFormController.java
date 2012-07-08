package com.example.registration.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.registration.model.WebRegistration;
import com.example.registration.bo.RegistrationManager;
import com.example.registration.exception.RegistrationException;

@Controller
@SessionAttributes
public class RegistrationFormController {
	
	private static final Logger logger = Logger.getLogger(RegistrationFormController.class);
	
	@Autowired
	private RegistrationManager registrationManager;
	
	@Autowired
	private AbstractMessageSource messageSource;
	
	
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object>  saveRegistration(
			@ModelAttribute("registrationForm") @Valid WebRegistration registration, 
			BindingResult result, Locale locale){
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (result.hasErrors()) {
			logger.debug("Validation errors in the user request");
			data.put("success",Boolean.FALSE);
			data.put("msgErrors", validationMessages(result.getAllErrors(), locale));
			return data;
		}
		
		try {
			registrationManager.addRegistration(registration, registration.getDomain());
		} catch (RegistrationException e) {
			logger.error("Errors in the user request", e);
			data.put("success",Boolean.FALSE);
			data.put("msgErrors", validationMessage(e.getCode(), locale));
			return data;
		}
		
		data.put("success",Boolean.TRUE);
		logger.debug("User request completed");
		return data;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Map<String,Object> model) {
		logger.info("hi!");
        model.put("registrationForm", new WebRegistration());
        return "registrationForm";
    }
	
	private List<String> validationMessages(List<ObjectError> errors, Locale locale) {
		List<String> failureMessages = new ArrayList<String>();
		for (ObjectError error : errors) {
			failureMessages.add(messageSource.getMessage(error, locale));
		}
		return failureMessages;
	}
	
	private List<String> validationMessage(String code, Locale locale) {
		List<String> failureMessages = new ArrayList<String>();
		failureMessages.add(messageSource.getMessage(code, null, locale));
		return failureMessages;
	}
	
}
