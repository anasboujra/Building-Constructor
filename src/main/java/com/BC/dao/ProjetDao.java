package com.BC.dao;

import java.util.List;

import com.BC.beans.Projet;
import com.BC.util.HibernateUtil;

public class ProjetDao extends DaoHibernateFactory<Projet>{

	public ProjetDao() {
		super(Projet.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Projet> findNewest() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
        List<Projet> entities = (List<Projet>) currentSession.createQuery("from Projet e where e.nbAppVendues < e.nbApp "
        		+"order by e.nbAppVendues desc").setMaxResults(6).getResultList();
        currentSession.close();
        return entities;
	}
	
}
