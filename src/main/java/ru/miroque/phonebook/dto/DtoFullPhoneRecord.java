package ru.miroque.phonebook.dto;

import lombok.Data;

/**
 * ДТО, для того, что у номера телефона может и не быть привязанного человека.
 * Т.е. Левый или Правый джойн, чтоб пустым был.
 * 
 * @author panov
 */
@Data
public class DtoFullPhoneRecord {
	private String fio;
	private String number;
	private String code;
	private String division;

	public DtoFullPhoneRecord(String fio, String number, String code, String division) {
		super();
		this.fio = fio;
		this.number = number;
		this.code = code;
		this.division = division;
	}

}
