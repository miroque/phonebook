package ru.miroque.phonebook.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import ru.miroque.phonebook.entities.Account;

@RequestScoped
public class AccountDao extends DaoImpl<Account, Integer> implements Serializable {
	private static final long serialVersionUID = 237775913023556200L;

	public AccountDao() {
		super(Account.class);
	}
}
