package com.ebanking.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	
	private double tauxInterets;
	
	public CompteEpargne( Date dateCreation, double solde, Client client,double tauxInterets) {
		super( dateCreation, solde, client);
		this.tauxInterets=tauxInterets;
	}

	
}
