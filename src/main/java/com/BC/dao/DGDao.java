package com.BC.dao;

import com.BC.beans.DG;
import com.BC.util.HibernateUtil;

public class DGDao extends DaoHibernateFactory<DG>{

	public DGDao() {
		super(DG.class);
	}
	
	
	public DG verify(String email, String motDePasse) {
		
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	DG dg = (DG) currentSession.createQuery("from DG e where e.email = :email").setParameter("email", email).uniqueResult();
    	currentSession.close();
    	if(dg != null && motDePasse.equals(dg.getMotDePasse())) {
    			return dg;
    	}
      	return null;
	}
}
