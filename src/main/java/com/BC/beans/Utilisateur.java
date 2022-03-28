package com.BC.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(unique=true)
	private String cin;
	private String nom;
	private String prenom;
	private String tele;
	@Column(unique=true)
	private String email;
	@Column(name="mot_de_passe")
	private String motDePasse;
	@Column(name="date_creation")
	private Date dateCreation = new Date();
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(Long id, String cin, String nom, String prenom, String tele, String email, String motDePasse,
			Date dateCreation) {
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.email = email;
		this.motDePasse = motDePasse;
		this.dateCreation = dateCreation;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

	
	
}
