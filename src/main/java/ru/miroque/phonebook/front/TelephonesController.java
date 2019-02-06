package ru.miroque.phonebook.front;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.primefaces.event.RowEditEvent;

import ru.miroque.phonebook.dao.PhoneDao;
import ru.miroque.phonebook.entities.Phone;

@Named
@RequestScoped
public class TelephonesController implements Serializable {
	private static final long serialVersionUID = 1391280938192540190L;
	
	@Inject
	private PhoneDao daoPhone;

	private List<Phone> phones;

	@PostConstruct
	private void pConstruct() {
		phones = daoPhone.getAll();
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void onRowEdit(RowEditEvent event) {
		System.out.println("onRowEdit: " + ((Phone) event.getObject()).getId());
	}

	public void onRowCancel(RowEditEvent event) {
		System.out.println("onRowCancel: " +((Phone) event.getObject()).getId());
	}

	public void onAddNew() {
	
	}
}
