package com.BC.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matiere_premiere")
public class MatierePremiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nom;
	private Double prix;
	private Double quantiteStockee;
	
	public MatierePremiere() {
		
	}

	public MatierePremiere(Long id, String nom, Double prix, Double quantiteStockee) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantiteStockee = quantiteStockee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getQuantiteStockee() {
		return quantiteStockee;
	}

	public void setQuantiteStockee(Double quantiteStockee) {
		this.quantiteStockee = quantiteStockee;
	}
	
	
	

}
