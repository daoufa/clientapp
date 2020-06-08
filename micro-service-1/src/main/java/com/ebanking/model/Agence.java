package com.ebanking.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	@JsonManagedReference
	@OneToMany(mappedBy = "agence",fetch=FetchType.LAZY)
	private Collection<Agent> agents;
	
	
	public Agence(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.agents = agents;
	}
	
	
	

}
