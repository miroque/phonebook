package ru.miroque.phonebook.front;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.primefaces.event.RowEditEvent;

import ru.miroque.phonebook.dto.DtoFullPhoneRecord;
import ru.miroque.phonebook.entities.Phone;
import ru.miroque.phonebook.services.TelephoneService;

@Named
@RequestScoped
public class TelephonesController implements Serializable {
	private static final long serialVersionUID = 1391280938192540190L;
	
	@Inject
	private TelephoneService telephoneService;

	private List<DtoFullPhoneRecord> phones;
	
	private Logger log = Logger.getLogger(getClass());

	@PostConstruct
	private void pConstruct() {
		phones = telephoneService.getAllPhonesForView();
	}

	public List<DtoFullPhoneRecord> getPhones() {
		return phones;
	}

	public void onRowEdit(RowEditEvent event) {
		log.info("onRowEdit: " + ((Phone) event.getObject()).getId());
		FacesMessage msg = new FacesMessage("onRowEdit", ((Phone) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		log.info("onRowCancel: " +((Phone) event.getObject()).getId());
		FacesMessage msg = new FacesMessage("onRowCancel", ((Phone) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onAddNew() {
        FacesMessage msg = new FacesMessage("New Phone added", "so");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
