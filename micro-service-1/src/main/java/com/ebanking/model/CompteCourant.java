package com.ebanking.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
	private double decouvert;
	
	
}
