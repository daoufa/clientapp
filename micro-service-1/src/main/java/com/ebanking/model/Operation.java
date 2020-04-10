package com.ebanking.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP",
discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Operation {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name = "NUM_CPTE")
	private Compte compte;
	
	
	public Operation(double montant, Compte compte) {
		super();
		this.dateOperation = new Date();
		this.montant = montant;
		this.compte = compte;
	}
	
	
	
}
