package com.BC.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client extends Utilisateur {

	public Client() {
		super();
	}
	
	public Client(Long id, String cin, String nom, String prenom, String tele, String email, String motDePasse,
			Date dateCreation) {
		super(id, cin, nom, prenom, tele, email, motDePasse, dateCreation);
	}
	
	
}
