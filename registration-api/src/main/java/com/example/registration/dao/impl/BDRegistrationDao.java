package com.example.registration.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.registration.dao.RegistrationDao;
import com.example.registration.model.Registration;

public class BDRegistrationDao implements RegistrationDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Registration registration){
		entityManager.persist(registration);
		entityManager.flush();
	}
	
	public void delete(Registration registration) {
		entityManager.remove(registration);
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Registration> getAll(){
		Query query = entityManager.createQuery("from " + Registration.class.getName()+ " c");
		return (List<Registration>)query.getResultList();
	}

	@Override
	public void removeAll() {
		 List<Registration> registrations = this.getAll();
		 for (Registration registration : registrations) {
			this.delete(registration);
		}
	}

}
