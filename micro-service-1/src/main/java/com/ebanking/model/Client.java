package com.ebanking.model;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String prenom;
	private String email;
	@JsonBackReference
	@OneToMany(mappedBy = "client",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Collection<Compte> comptes;
	private String tel;
	private String sexe;
	private String password;
	private boolean estSuspendu;
	private Date dateNaissance;
	private String nationalite;
	private String paysResidence;
	private String situationProf;
	private String profession;
	private String cin;
	private String ville;
	private String identitePhoto;
	private String passportPhoto;
	
	
	@JsonBackReference
	public Collection<Compte> getClientComptes(){
		return this.comptes;
	}

	@SuppressWarnings("deprecation")
	public Client(String nom, String prenom, String email, String tel, String sexe,
			 boolean estSuspendu, String dateNaissance, String nationalite, String paysResidence,
			String situationProf, String profession, String cin, String ville, String identitePhoto,
			String passportPhoto) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.sexe = sexe;
		this.estSuspendu = estSuspendu;
		this.nationalite = nationalite;
		this.paysResidence = paysResidence;
		this.situationProf = situationProf;
		this.profession = profession;
		this.cin = cin;
		this.ville = ville;
		this.identitePhoto = identitePhoto;
		this.passportPhoto = passportPhoto;
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		this.dateNaissance =new Date(sdf.format(new Date(dateNaissance)));
	}
}







