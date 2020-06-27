package com.ebanking.model;

import java.io.Serializable;

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

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String cin;
	private String pays;
	private String ville;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CODE_AGENCE")
	private Agence agence;

	public Agent(String nom, String prenom, String pays, String ville, String telephone, String email, String cin,
			Agence agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
		this.email = email;
		this.telephone = telephone;
		this.cin = cin;
		this.pays = pays;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "agent" + this.getNom();
	}
}
