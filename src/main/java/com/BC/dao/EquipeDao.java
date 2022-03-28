package com.BC.dao;


import com.BC.beans.Equipe;

public class EquipeDao extends DaoHibernateFactory<Equipe> {
	
	public EquipeDao() {
		super(Equipe.class);
	}
	

}
