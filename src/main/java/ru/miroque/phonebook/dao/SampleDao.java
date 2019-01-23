package ru.miroque.phonebook.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.miroque.phonebook.entities.Phone;

@RequestScoped
public class SampleDao {
	@Inject
	private EntityManager em;
	
	public void addTestPhone() {
		Phone phone = new Phone();
		phone.setNumber("222-333");

		em.persist(phone);
	}
}
