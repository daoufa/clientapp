package com.ebanking.model;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Virement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private Date date;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name = "NUM_CPTE")
	private Compte compte;
	
	
	@ManyToOne
	@JoinColumn(name = "NUM_CPTE_DEST")
	Compte destinataireCompte;
	
	
	public Virement( Compte compte,Compte dest,double montant ) {
		
		super();
		this.montant = montant;
		this.compte = compte;
		this.destinataireCompte=dest;
	}

	public Long getCompteId() {
		return this.compte.getNumCompte();
	}
	public Long getDestCompteId() {
		return this.destinataireCompte.getNumCompte();
	}
	@JsonGetter
	private long getClientId() {
		
		return compte.getClient().getCode();
	}

}
