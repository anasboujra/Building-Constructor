package com.BC.dao;

import com.BC.beans.Salaire;

public class SalaireDao extends DaoHibernateFactory<Salaire> {
	

	public SalaireDao() {
		super(Salaire.class);
	}
	
}
