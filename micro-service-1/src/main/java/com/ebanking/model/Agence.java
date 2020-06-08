package com.ebanking.model;

import java.io.Serializable;
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
public class Agence implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private String ville;
	@JsonManagedReference
	@OneToMany(mappedBy = "agence",fetch=FetchType.LAZY)
	private Collection<Agent> agents;
	
	
	public Agence(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}
	
	
	

}
