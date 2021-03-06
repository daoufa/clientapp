package com.ebanking.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue("CE")
@JsonTypeName("ce")
public class CompteEpargne extends Compte {

	private double tauxInterets;

	public CompteEpargne(Date dateCreation, double solde, Client client, double tauxInterets) {
		super(dateCreation, solde, client, "ce");
		this.tauxInterets = tauxInterets;
	}

	@JsonGetter
	public double getTauxInterets() {
		return tauxInterets;
	}

	public void setTauxInterets(double t) {
		this.tauxInterets = t;
	}

}
