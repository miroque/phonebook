package ru.miroque.phonebook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Номер телефона который привязан к конкретному отделу
 * @author miroque
 *
 */
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Phone {

	@Id
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	@Getter
	@Setter
	private String number;

	@Column
	@Getter
	@Setter
	private String inner;
	
/*	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "division_fkey")
	@Getter
	@Setter
	private Division division;*/

}
