package com.BC.beans;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Equipe")
public class Equipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToOne
	@JoinColumn(name="id_chef")
	private CE ce;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "equipe", cascade = CascadeType.ALL)
    private List<Employe> employe=new ArrayList<>();
	public Equipe() {
		
	}

	public Equipe(Long id, String nom, CE ce) {
		super();
		this.id = id;
		this.nom = nom;
		this.ce = ce;
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

	public CE getCe() {
		return ce;
	}

	public void setCe(CE ce) {
		this.ce = ce;
	}

	public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}
	
	public void addEmploye(Employe employe) {
		this.employe.add(employe);
	}
	
	
	
}
