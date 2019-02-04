package ru.miroque.phonebook.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
public class Phone implements Serializable {
	private static final long serialVersionUID = -3953142861480064290L;

	@Id
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_phone")
	@SequenceGenerator(name = "seq_phone", sequenceName = "seq_phone")
	private Integer id;

	@Column
	@Getter
	@Setter
	private String number;

	@Column
	@Getter
	@Setter
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private Division division;

}
