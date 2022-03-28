package com.BC.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String prenom;
	private String nom;
	private String tele;
	private String email;
	
	@Column(columnDefinition="TEXT")
	private String contenu;	
	
	@Column(name="date_creation")
	private Date dateCreation = new Date();
	
	@Column(columnDefinition="TEXT")
	private String reponse;
	
	public Message() {
		
	}

	public Message(Long id, String prenom, String nom, String tele, String email, String contenu, Date dateCreation,
			String reponse) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.tele = tele;
		this.email = email;
		this.contenu = contenu;
		this.dateCreation = dateCreation;
		this.reponse = reponse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
}
