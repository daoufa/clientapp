package com.ebanking.model;

<<<<<<< HEAD
import java.util.Collection;
=======

import java.util.Collection;
import java.util.List;
>>>>>>> f934e7d36f864455eac8104a12ebd4c1964a69fa

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

<<<<<<< HEAD
=======

>>>>>>> f934e7d36f864455eac8104a12ebd4c1964a69fa
@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
<<<<<<< HEAD
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "agence",fetch=FetchType.LAZY)
	private Collection<Agent> agents;
	

=======

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String adresse;
	@OneToMany(mappedBy = "agence",fetch=FetchType.LAZY)
	private Collection<Agent> agents;
	
>>>>>>> f934e7d36f864455eac8104a12ebd4c1964a69fa
}
