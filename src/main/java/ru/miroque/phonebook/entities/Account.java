package ru.miroque.phonebook.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Некая абстрактная учетная запись в которой известно фио, и телефон по которому можно дозвониться.
 * Учетная запись в текущей реализации не привязана к отделу. 
 * К отделу привязывается только телефоный номер, как физическое устройство в конкретном помещении.
 * @author master
 *
 */
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Account {
	@Id
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	@Getter
	@Setter
	private String fio;

	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private Phone phone;
	
}
