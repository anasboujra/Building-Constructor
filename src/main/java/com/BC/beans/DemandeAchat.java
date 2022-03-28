package com.BC.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="demande_achat")
public class DemandeAchat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="date_demande")
	private LocalDateTime dateDemande = LocalDateTime.now();
	private String etat;
	@Column(name="date_rdv")
	private LocalDateTime dateRDV;
	@Column(name="date_achat")
	private LocalDateTime dateAchat;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_projet")
	private Projet projet;

	
	public DemandeAchat() {
		
	}


	public DemandeAchat(Long id, LocalDateTime dateDemande, String etat, LocalDateTime dateRDV, LocalDateTime dateAchat,
			Client client, Projet projet) {
		this.id = id;
		this.dateDemande = dateDemande;
		this.etat = etat;
		this.dateRDV = dateRDV;
		this.dateAchat = dateAchat;
		this.client = client;
		this.projet = projet;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getDateDemande() {
		return dateDemande;
	}


	public void setDateDemande(LocalDateTime dateDemande) {
		this.dateDemande = dateDemande;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public LocalDateTime getDateRDV() {
		return dateRDV;
	}


	public void setDateRDV(LocalDateTime dateRDV) {
		this.dateRDV = dateRDV;
	}


	public LocalDateTime getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(LocalDateTime dateAchat) {
		this.dateAchat = dateAchat;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Projet getProjet() {
		return projet;
	}


	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	


}
