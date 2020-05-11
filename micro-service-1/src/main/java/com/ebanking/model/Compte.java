package com.ebanking.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE",
discriminatorType = DiscriminatorType.STRING,length = 2 )
public abstract class Compte implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCompte;
	private Date dateCreation;
	private double solde;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CODE_CLT" )
	private Client client;
	@JsonManagedReference
	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;
	
	
	public Compte( Date dateCreation, double solde, Client client) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}
	

	public String getClientNom() {
		return client.getNom();
	}
	

}
