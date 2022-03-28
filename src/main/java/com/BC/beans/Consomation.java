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
@Table(name="Consomation")
public class Consomation {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_projet")
	private Projet projet;

	@ManyToOne
	@JoinColumn(name="id_mp")
	private MatierePremiere mp;
	
	@Column(name="qte_consomee")
	private Double QteConsomee;

	
	
	
	
	public Consomation() {
	
	}
	
	

	public Consomation(Long id, Projet projet, MatierePremiere mp, Double qteConsomee) {
		super();
		this.id = id;
		this.projet = projet;
		this.mp = mp;
		QteConsomee = qteConsomee;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public MatierePremiere getMp() {
		return mp;
	}

	public void setMp(MatierePremiere mp) {
		this.mp = mp;
	}

	public Double getQteConsomee() {
		return QteConsomee;
	}

	public void setQteConsomee(Double qteConsomee) {
		QteConsomee = qteConsomee;
	}
	
	
}
