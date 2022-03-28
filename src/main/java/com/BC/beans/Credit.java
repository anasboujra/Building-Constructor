package com.BC.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Credit")
public class Credit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double valeur;
	private Double taux;
	private String dateEmprunt;
	private String dateEpargne;
	private String valider;
	private String banque;
	
	public Credit() {
		
	}

	public Credit(Long id, Double valeur, Double taux, String dateEmprunt, String dateEpargne, String valider,
			String banque) {
		super();
		this.id = id;
		this.valeur = valeur;
		this.taux = taux;
		this.dateEmprunt = dateEmprunt;
		this.dateEpargne = dateEpargne;
		this.valider = valider;
		this.banque = banque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public String getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(String dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public String getDateEpargne() {
		return dateEpargne;
	}

	public void setDateEpargne(String dateEpargne) {
		this.dateEpargne = dateEpargne;
	}

	public String getValider() {
		return valider;
	}

	public void setValider(String valider) {
		this.valider = valider;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}
	

	
	
	
	
}
