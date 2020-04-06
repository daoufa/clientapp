package com.ebanking.model;

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
	
}
