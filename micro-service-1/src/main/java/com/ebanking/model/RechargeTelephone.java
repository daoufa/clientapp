package com.ebanking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeTelephone implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private Date date;
	private double montant;
	@ManyToOne
	@JoinColumn(name = "NUM_CPTE")
	private Compte compte;
	private String numTel;
	 
	
	
	public RechargeTelephone( double montant, Compte compte,String numTel,Date date) {
		super();
		this.date=date;
		this.montant = montant;
	    this.compte = compte;
		this.numTel=numTel;
		// TODO Auto-generated constructor stub
	}
	
	
}
