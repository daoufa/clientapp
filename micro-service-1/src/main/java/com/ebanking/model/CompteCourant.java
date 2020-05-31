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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("CC")
@JsonTypeName("cc")
public class CompteCourant extends Compte {
	
	private double decouvert;
	public CompteCourant( Date dateCreation, double solde, Client client,double decouvert) {
		super(dateCreation, solde, client,"cc");
		this.decouvert=decouvert;
	}
	
	
}
