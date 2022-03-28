package com.BC.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employe")
public class Employe{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String cin;
	private String nom;
	private String prenom;
	private String tele;
	@Column(unique=true)
	private String email;
	@Column(name="date_debut_travail")
	private Date dateDebutTravail = new Date();
	@Column(name="salaire_actuel")
	private Double salaireActuel;

	@ManyToOne
	@JoinColumn(name="id_equipe")
	private Equipe equipe;
	
	
	
	public Employe() {
		
	}



	public Employe(Long id, String cin, String nom, String prenom, String tele, String email, Date dateDebutTravail,
			Double salaireActuel, Equipe equipe) {
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.email = email;
		this.dateDebutTravail = dateDebutTravail;
		this.salaireActuel = salaireActuel;
		this.equipe = equipe;
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



	public Date getDateDebutTravail() {
		return dateDebutTravail;
	}



	public void setDateDebutTravail(Date dateDebutTravail) {
		this.dateDebutTravail = dateDebutTravail;
	}



	public Double getSalaireActuel() {
		return salaireActuel;
	}



	public void setSalaireActuel(Double salaireActuel) {
		this.salaireActuel = salaireActuel;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	
	
	

}
