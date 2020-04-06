package com.ebanking.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	public Client(String nom, String prenom, String email, String tel, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.sexe = sexe;
	}
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String prenom;
	private String email;
	@OneToMany(mappedBy = "client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	private String tel;
	private String sexe;
	private String password;
}
