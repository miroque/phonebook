package ru.miroque.phonebook.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import ru.miroque.phonebook.entities.Division;

@RequestScoped
public class DivisionDao extends DaoImpl<Division, Integer> implements Serializable {
	private static final long serialVersionUID = 237775913023556200L;

	public DivisionDao() {
		super(Division.class);
	}
}
