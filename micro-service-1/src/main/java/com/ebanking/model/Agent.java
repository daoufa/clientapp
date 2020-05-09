package com.ebanking.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String prenom;
	@ManyToOne
<<<<<<< HEAD
	@JoinColumn(name = "CODE_AGC")
	private Agence agence;	
=======
	@JoinColumn(name = "CODE_AGENCE")
	private Agence agence;
	
>>>>>>> f934e7d36f864455eac8104a12ebd4c1964a69fa
}
