package com.ebanking.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
	private double decouvert;

	public CompteCourant( Date dateCreation, double solde, Client client,double decouvert) {
		super(dateCreation, solde, client);
		// TODO Auto-generated constructor stub
		this.decouvert=decouvert;
	}
	
	
}
