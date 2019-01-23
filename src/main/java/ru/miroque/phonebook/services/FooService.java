package ru.miroque.phonebook.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ru.miroque.phonebook.dao.SampleDao;

@RequestScoped
public class FooService {
	@Inject
	private SampleDao dao;
	
	public void name() {
		dao.addTestPhone();
	}
}
