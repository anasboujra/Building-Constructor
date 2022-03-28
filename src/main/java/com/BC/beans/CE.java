package com.BC.beans;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CE")
public class CE extends Utilisateur{
	

	@OneToOne
	@JoinColumn(name="id_equipe")
	private Equipe equipe=null;

	
	public CE() {
		super();
	}

	public CE(Equipe equipe) {
		super();
		this.equipe = equipe;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	

	

}
