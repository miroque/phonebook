package ru.miroque.phonebook.front;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import ru.miroque.phonebook.dao.PhoneDao;
import ru.miroque.phonebook.entities.Phone;

@Named
@RequestScoped
public class TelephonesEditController implements Serializable {
	private static final long serialVersionUID = 1391280938192540190L;
	
	@Inject
	private PhoneDao daoPhone;

	private List<Phone> phones;

	@PostConstruct
	private void pConstruct() {
		phones = daoPhone.getAll();
	}

	public List<Phone> getPhones() {
		FacesMessage fm;
		return phones;
	}

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Phone Edited", ((Phone) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Phone) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
        	System.out.println("Cell Changed Old: " + oldValue + ", New:" + newValue);
//        	daoPhone.merge(newValue);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
