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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private String ville;
	@JsonManagedReference
	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
	private Collection<Agent> agents;

	public Agence(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}

	public boolean equals(Object O) {
		if (O == this)
			return true;
		if (!(O instanceof Agence))
			return false;
		Agence a = (Agence) O;
		if (O == null)
			return false;
		if (this.getNom() == null && a.getNom() == null)
			return true;
		return (this.getNom().equals(a.getNom()));
	}

	@Override
	public String toString() {
		return "agence" + this.getNom();
	}

}
