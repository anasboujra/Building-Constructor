package com.BC.dao;

import java.util.List;

import com.BC.beans.Transaction;
import com.BC.util.HibernateUtil;

public class TransactionDao extends DaoHibernateFactory<Transaction>{
	
	public TransactionDao() {
		super(Transaction.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> findAllAnneeValP(Integer annee) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	List<Transaction> transactions = (List<Transaction>)currentSession.createQuery("from "+persistentClass.getSimpleName()+
        		" e where e.annee = :annee and e.valeur > 0").setParameter("annee", annee).getResultList();
    	
        currentSession.close();
        return transactions;
    }
	
	@SuppressWarnings("unchecked")
	public List<Transaction> findAllMoisValP(Integer mois, Integer annee) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	List<Transaction> transactions = (List<Transaction>)currentSession.createQuery("from "+persistentClass.getSimpleName()+
    			" e where e.mois = :mois and e.annee = :annee and e.valeur > 0").setParameter("mois", mois)
    			.setParameter("annee", annee).getResultList();
        currentSession.close();
        return transactions;
    }
	
	@SuppressWarnings("unchecked")
	public List<Transaction> findAllAnneeValN(Integer annee) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	List<Transaction> transactions = (List<Transaction>)currentSession.createQuery("from "+persistentClass.getSimpleName()+
    			" e where e.annee = :annee and e.valeur < 0").setParameter("annee", annee).getResultList();
        currentSession.close();
        return transactions;
    }
	
	@SuppressWarnings("unchecked")
	public List<Transaction> findAllMoisValN(Integer mois, Integer annee) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	List<Transaction> transactions = (List<Transaction>)currentSession.createQuery("from "+persistentClass.getSimpleName()+
    			" e where e.mois = :mois and e.annee = :annee and e.valeur < 0").setParameter("mois", mois)
    			.setParameter("annee", annee).getResultList();
        currentSession.close();
        return transactions;
    }
	

}
