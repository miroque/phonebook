package ru.miroque.phonebook.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
public class Division implements Serializable{
	private static final long serialVersionUID = -4782524280148652383L;

	@Id
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_division")
	@SequenceGenerator(name = "seq_division", sequenceName = "seq_division")
	
	private Integer id;

	@Column
	@Getter
	@Setter
	private String name;

}
