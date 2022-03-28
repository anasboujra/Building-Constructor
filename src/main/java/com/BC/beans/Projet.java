package com.BC.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Projet")
public class Projet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre ;
	private String adresse ;
	
	@Column(name="prix_vente")
	private Double prixVente ;
	
	@Column(name="nb_etage")
	private Long nbEtage ;
	
	@Column(name="nb_app")
	private Long nbApp;
	
	@Column(name="nb_chambres")
	private Long nbChambres;
	
	@Column(name="date_debut")
	private String dateDebut;
	
	@Column(name="date_fin")
	private String dateFin;
	private String surface;
	
	@Column(name="nb_app_vendues")
	private Long nbAppVendues=(long) 0;
	
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name="id_equipe")
	private Equipe equipe;
	
	public Projet() {
		
	}

	public Projet(Long id, String titre, byte[] image, String adresse, Double prixVente, Long nbEtage, Long nbApp,
			Long nbChambres, String dateDebut, String dateFin, String surface, Long nbAppVendues, Equipe equipe) {
		this.id = id;
		this.titre = titre;
		this.image = image;
		this.adresse = adresse;
		this.prixVente = prixVente;
		this.nbEtage = nbEtage;
		this.nbApp = nbApp;
		this.nbChambres = nbChambres;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.surface = surface;
		this.nbAppVendues = nbAppVendues;
		this.equipe = equipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}

	public Long getNbEtage() {
		return nbEtage;
	}

	public void setNbEtage(Long nbEtage) {
		this.nbEtage = nbEtage;
	}

	public Long getNbApp() {
		return nbApp;
	}

	public void setNbApp(Long nbApp) {
		this.nbApp = nbApp;
	}

	public Long getNbChambres() {
		return nbChambres;
	}

	public void setNbChambres(Long nbChambres) {
		this.nbChambres = nbChambres;
	}



	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public Long getNbAppVendues() {
		return nbAppVendues;
	}

	public void setNbAppVendues(Long nbAppVendues) {
		this.nbAppVendues = nbAppVendues;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	
	
	
	public void ajouterVente() {
		 this.nbAppVendues += 1;
	}
	
	public void annulerVente() {
		 this.nbAppVendues -= 1;
	}
	
	
}
