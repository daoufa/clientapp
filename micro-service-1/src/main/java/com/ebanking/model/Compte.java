package com.ebanking.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

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

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE",
discriminatorType = DiscriminatorType.STRING,length = 2 )
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value=CompteCourant.class, name="cc"),
    @JsonSubTypes.Type(value=CompteEpargne.class, name="ce")
})
@JsonIgnoreProperties({"virementsIn","virementsOut","rechargeTelephones"})
public abstract class Compte  {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCompte;
	private Date dateCreation;
	private double solde;
	
	private String type;
	@ManyToOne
	@JoinColumn(name = "CODE_CLT" )
	private Client client;
	
	@OneToMany(mappedBy = "compte")
	private Collection<Virement> virementsOut;
	
	
	@OneToMany(mappedBy = "destinataireCompte")
	private Collection<Virement> virementsIn;
	
	
	@OneToMany(mappedBy = "compte")
	private Collection<RechargeTelephone> rechargeTelephones;
	private boolean isEpargne;
	
	public Compte( Date dateCreation, double solde, Client client,String type) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		if(type=="ce") { isEpargne=true;}
		else {isEpargne=false;}
	}

	public Compte(Long numCompte, Date dateCreation, double solde,String type, Client client, Collection<Virement> virementsOut,
			Collection<Virement> virementsIn, Collection<RechargeTelephone> rechargeTelephones, boolean isEpargne) {
		super();
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		this.virementsOut = virementsOut;
		this.virementsIn = virementsIn;
		this.rechargeTelephones = rechargeTelephones;
		this.type=type;
		
		if(type=="ce") { isEpargne=true;}
		else {isEpargne=false;}
	}
/*	
	@JsonGetter
	public String clientNom() {
		return this.client.getNom()+" "+this.client.getPrenom();
	}
	
*/
	
	

}
