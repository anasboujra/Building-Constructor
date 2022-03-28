package com.BC.dao;


import com.BC.beans.Credit;

public class CreditDao extends DaoHibernateFactory<Credit>{

	public CreditDao() {
		super(Credit.class);
	}
	
	
}
