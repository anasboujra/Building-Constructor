package com.BC.dao;

import com.BC.beans.Absence;
import com.BC.util.HibernateUtil;

public class AbsenceDao extends DaoHibernateFactory<Absence> {

	public AbsenceDao() {
		super(Absence.class);
	}
	
	public Long count(Long id, String date) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        Long count = (Long) currentSession.createQuery("select count(*) from " + persistentClass.getSimpleName() +
        		" e where e.employe.id = :c1 and e.date = :c2").setParameter("c1", id).setParameter("c2", date).uniqueResult();
        currentSession.close();
        return count;
    }
	
	public Absence find(Long id, String date) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        Absence absence = (Absence) currentSession.createQuery("from " + persistentClass.getSimpleName() +
        		" e where e.employe.id = :c1 and e.date = :c2").setParameter("c1", id).setParameter("c2", date).uniqueResult();
        currentSession.close();
        return absence;
    }

}
