package com.ebanking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data

@NoArgsConstructor
public class Admin {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	
	
	public Admin(String nom, String prenom, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}
	
	

}
