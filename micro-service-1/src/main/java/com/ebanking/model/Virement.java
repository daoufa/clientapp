package com.ebanking.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("V")
public class Virement extends Operation {
	
	
	
	
	
	public Virement(long numero, Date dateOperation, double montant, Compte compte) {
		super(numero, dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}
