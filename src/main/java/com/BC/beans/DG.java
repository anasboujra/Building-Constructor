package com.BC.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DG")
public class DG extends Utilisateur{
	
	public DG() {
		super();
	}

	public DG(Long id, String cin, String nom, String prenom, String tele, String email, String motDePasse,
			Date dateCreation) {
		super(id, cin, nom, prenom, tele, email, motDePasse, dateCreation);
	}

	
}
