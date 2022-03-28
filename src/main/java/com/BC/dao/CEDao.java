package com.BC.dao;

import java.util.List;

import com.BC.beans.CE;
import com.BC.util.HibernateUtil;

public class CEDao extends DaoHibernateFactory<CE>{

	public CEDao() {
		super(CE.class);
	}

	
	public CE verify(String email, String motDePasse) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	CE ce = (CE) currentSession.createQuery("from CE e where e.email = :email").setParameter("email", email).uniqueResult();
    	currentSession.close();
    	if(ce != null && motDePasse.equals(ce.getMotDePasse())) {
    			return ce;
    	}
      	return null;
	}
	
	public List<CE> findAllFreeCE() {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
		List<CE> entities = (List<CE>) currentSession.createQuery("from "+persistentClass.getSimpleName()+" ce where ce.equipe="+null).getResultList();
        currentSession.close();
        return entities;
    }

}
