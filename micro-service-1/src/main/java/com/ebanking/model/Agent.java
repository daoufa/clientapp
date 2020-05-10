package com.ebanking.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data
@NoArgsConstructor
public class Agent {

	public Agent(String nom, String prenom, Agence agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String prenom;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CODE_AGENCE")
	private Agence agence;
	

}
