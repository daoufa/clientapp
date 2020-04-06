package com.ebanking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Operation {
	
	@Id @GeneratedValue
	private long numero;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name = "NUM_CPTE")
	private Compte compte;
	
	
	
}
