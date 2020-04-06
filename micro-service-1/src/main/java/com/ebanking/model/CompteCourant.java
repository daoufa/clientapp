package com.ebanking.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Inheritance/*(strategy = InheritanceType.)*/
public class CompteCourant extends Compte {
	
	private double decouvert;
	
	
}
