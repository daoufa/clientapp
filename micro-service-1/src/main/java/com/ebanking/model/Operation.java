package com.ebanking.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

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
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP",
discriminatorType = DiscriminatorType.STRING,length = 2)

public abstract class Operation implements Serializable {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private Date dateOperation;
	private double montant;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "NUM_CPTE")
	private Compte compte;
	boolean isVirement;
	
	
	public Operation(double montant, Compte compte) {
		super();
		this.dateOperation = new Date();
		this.montant = montant;
		this.compte = compte;
		if(this instanceof Virement) isVirement=true;
		else isVirement=false;
	}
	
	public Long getCompteId() {
		return compte.getNumCompte();
	}
	public String getOperationType() {
		return this instanceof Virement? "V":"R";
	}
	public String getDateOperation() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dateOperation);
		
	}
	
	
	
	
}
