package com.ebanking.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("V")
public class Virement extends Operation {
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "NUM_CPTE_DEST")
	Compte destinataireCompte;
	
	
	public Virement(Compte compte,Compte dest, double montant ) {
		super(  montant, compte);
		this.destinataireCompte=dest;
	}
	public Compte getDestinataireCompte() {
		return destinataireCompte;
	}
	

	public Long getDestinataireCompteId() {
		return destinataireCompte.getNumCompte();
	}

}
