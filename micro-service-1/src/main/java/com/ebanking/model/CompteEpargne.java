package com.ebanking.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	
	private double tauxInterets;
	
	public CompteEpargne(Long numCompte, Date dateCreation, double solde, Client client,double tauxInterets) {
		super(numCompte, dateCreation, solde, client);
		// TODO Auto-generated constructor stub
		this.tauxInterets=tauxInterets;
	}

	
}
