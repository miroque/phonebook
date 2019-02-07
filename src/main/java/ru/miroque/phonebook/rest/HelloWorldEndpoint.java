package ru.miroque.phonebook.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import ru.miroque.phonebook.dao.AccountDao;
import ru.miroque.phonebook.dao.DivisionDao;
import ru.miroque.phonebook.dao.PhoneDao;
import ru.miroque.phonebook.entities.Account;
import ru.miroque.phonebook.entities.Division;
import ru.miroque.phonebook.entities.Phone;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {
	
	@Inject
	private PhoneDao daoPhone;
	
	@Inject
	private AccountDao daoAccount;
	
	@Inject
	private DivisionDao daoDivision;
	
    private Logger log = Logger.getLogger(getClass());
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response doGet() {
		initData();
		return Response.ok("Hello from Thorntail! And initial DB").build();
	}
	
	private void initData() {
		log.info("init DB");
		// init Divisions
		Division division1 = new Division();
		division1.setName("Бухгалтерия");

		Division division2 = new Division();
		division2.setName("Приемная");
		
		Division division3 = new Division();
		division3.setName("Отдел кадров");
		
		daoDivision.persist(division1);
		daoDivision.persist(division2);
		daoDivision.persist(division3);
		
		// init Accounts
		Phone phone1 = new Phone();
		phone1.setNumber("22-33-22");
		phone1.setDivision(division1);

		Phone phone2 = new Phone();
		phone2.setNumber("44-22-66");
		phone2.setCode("34");
		phone2.setDivision(division1);

		Phone phone3 = new Phone();
		phone3.setNumber("77-88-77");
		phone3.setCode("12");
		phone3.setDivision(division2);
		
		Phone phone4 = new Phone();
		phone4.setNumber("67-87-24");
		
		daoPhone.persist(phone1);
		daoPhone.persist(phone2);
		daoPhone.persist(phone3);
		daoPhone.persist(phone4);
		
		// init Accounts
		Account account1 = new Account();
		account1.setFio("Тест1 Тестович1 Тестов1");
		account1.setPhone(phone1);
		
		Account account2 = new Account();
		account2.setFio("Тест2 Тестович2 Тестов2");
		account2.setPhone(phone2);
		
		daoAccount.persist(account1);
		daoAccount.persist(account2);
	}
}
