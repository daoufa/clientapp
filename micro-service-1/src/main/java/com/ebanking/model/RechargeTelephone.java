package com.ebanking.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("R")
public class RechargeTelephone extends Operation {
	
	private String numTel;
	
	
	
	public RechargeTelephone( double montant, Compte compte,String numTel) {
		super( montant, compte);
		this.numTel=numTel;
		// TODO Auto-generated constructor stub
	}

}
