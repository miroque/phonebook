package ru.miroque.phonebook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Отдел 
 * @author miroque
 */
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Division {
	@Id
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	private Integer id;

	@Column
	@Getter
	@Setter
	private String name;

}
