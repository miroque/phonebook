package ru.miroque.phonebook.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ru.miroque.phonebook.dao.PhoneDao;

@RequestScoped
public class FooService {
	@Inject
	private PhoneDao dao;
	
	public void name() {
//		dao.addTestPhone();
	}
}
