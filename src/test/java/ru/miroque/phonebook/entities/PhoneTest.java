package ru.miroque.phonebook.entities;

import org.junit.jupiter.api.Test;

class PhoneTest {

	@Test
	void testGetNumber() {
		Phone phone  = new Phone();
		phone.setId(1);
		phone.setNumber("2323");
		System.out.println("seeee: " + phone);
		System.out.println("hashCode: " + phone.hashCode());
	}

}
