package com.BC.dao;

import java.util.List;

import com.BC.beans.Employe;
import com.BC.util.HibernateUtil;

public class EmployeDao extends DaoHibernateFactory<Employe> {

	
	public EmployeDao() {
		super(Employe.class);
	}
	
	public List<Employe> findAllFreeEmployes() {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
		List<Employe> entities = (List<Employe>) currentSession.createQuery("from "+persistentClass.getSimpleName()+" e where e.equipe="+null).getResultList();
        currentSession.close();
        return entities;
    }
}
