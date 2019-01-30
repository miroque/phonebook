package ru.miroque.phonebook.front;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import ru.miroque.phonebook.entities.Phone;

@Named
@RequestScoped
public class TelephonesController {
	@Inject
	private EntityManager em;

	private List<Phone> phones;

	@PostConstruct
	private void pConstruct() {
		phones = em.createQuery("From Phone p", Phone.class).getResultList();
	}

	public List<Phone> getPhones() {
		System.out.println("getting phones");
		return phones;
	}

}
