package ru.miroque.phonebook.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ru.miroque.phonebook.dao.PhoneDao;
import ru.miroque.phonebook.dto.DtoFullPhoneRecord;

@RequestScoped
public class TelephoneService {
	
	@Inject
	private PhoneDao daoPhone;

	public List<DtoFullPhoneRecord> getAllPhonesForView() {
		return daoPhone.getAllPhonesForView();
	}

}
