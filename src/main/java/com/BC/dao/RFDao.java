package com.BC.dao;

import com.BC.beans.RF;
import com.BC.util.HibernateUtil;

public class RFDao extends DaoHibernateFactory<RF>{

	public RFDao() {
		super(RF.class);
	}
	
	
	public RF verify(String email, String motDePasse) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	RF rf = (RF) currentSession.createQuery("from RF e where e.email = :email").setParameter("email", email).uniqueResult();
    	currentSession.close();
    	if(rf != null && motDePasse.equals(rf.getMotDePasse())) {
    			return rf;
    	}
      	return null;
	}
}
