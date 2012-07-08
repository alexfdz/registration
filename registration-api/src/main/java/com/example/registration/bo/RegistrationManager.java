package com.example.registration.bo;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.registration.dao.RegistrationDao;
import com.example.registration.exception.RegistrationException;
import com.example.registration.model.Registration;

public class RegistrationManager {

	private static final Logger logger = Logger.getLogger(RegistrationManager.class);
	
	@Autowired
	private RegistrationDao registrationDao;
	
	private Map<String, String[]> domainValidationMap;
	
	/**
	 * Add the {@link Registration} entity to the repository.
	 * If the registration already exist (same user name), the entity will
	 * be updated.
	 * 
	 * @param registration
	 * @param domain
	 * @throws RegistrationException For validation errors like empty content or incorrect email domain
	 */
	public void addRegistration(Registration registration, String domain) throws RegistrationException{
		if(!this.validateContent(registration)){
			throw new RegistrationException("error.content");
		}
		if(StringUtils.isEmpty(domain)){
			throw new RegistrationException("error.domain.undefined");
		}
		if(!this.validateDomain(registration.getEmail(), domain)){
			throw new RegistrationException("error.domain.validation");
		}
		registrationDao.save(registration);
		logger.info("Registration entity created");
	}
	
	/**
	 * Remove all the {@link Registration} entities
	 * @throws RegistrationException
	 */
	public void removeAll(){
		registrationDao.removeAll();
	}
	

	/**
	 * Checks if the email domain is correct for a given domain.
	 * Usage of the DomainVialidationMap property
	 * @param email
	 * @param domain
	 * @return
	 */
	private boolean validateDomain(String email, String domain) {
		String[] patterns = domainValidationMap.get(domain);
		if(patterns != null){
			for (String pattern : patterns) {
				if(Pattern.matches(pattern, email)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check if the registration content is not empty
	 * @param registration
	 * @return
	 */
	private boolean validateContent(Registration registration) {
		if(registration != null && StringUtils.isNotEmpty(registration.getUsername()) &&
				StringUtils.isNotEmpty(registration.getPostCode()) &&
				StringUtils.isNotEmpty(registration.getEmail())){
			return true;
		}
		return false;
	}


	public List<Registration> getRegistrations(){
		return registrationDao.getAll();
	}

	public void setDomainValidationMap(Map<String, String[]> domainValidationMap) {
		this.domainValidationMap = domainValidationMap;
	}
	
}
