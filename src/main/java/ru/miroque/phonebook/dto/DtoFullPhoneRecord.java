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
	private final String fio;
	private final String number;
	private final String code;
	private final String division;
}
