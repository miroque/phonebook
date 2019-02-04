package ru.miroque.phonebook.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import ru.miroque.phonebook.entities.Phone;

@RequestScoped
public class PhoneDao extends DaoImpl<Phone, Integer> implements Serializable {
	private static final long serialVersionUID = 5567454653205368551L;

	public PhoneDao() {
		super(Phone.class);
	}
}
