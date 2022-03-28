package com.BC.dao;

import com.BC.beans.RH;
import com.BC.util.HibernateUtil;

public class RHDao extends DaoHibernateFactory<RH>{

	public RHDao() {
		super(RH.class);
	}
	
	
	public RH verify(String email, String motDePasse) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	RH rh = (RH) currentSession.createQuery("from RH e where e.email = :email").setParameter("email", email).uniqueResult();
    	currentSession.close();
    	if(rh != null && motDePasse.equals(rh.getMotDePasse())) {
    			return rh;
    	}
      	return null;
	}

}
