package com.BC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.BC.util.HibernateUtil;

public class DaoHibernateFactory<T> implements DaoInterface<T> {
	
	protected Session currentSession;
	protected Transaction currentTransaction;
    protected Class<T> persistentClass;
	
    
	public DaoHibernateFactory(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	
	@Override
    public void add(T entity) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        currentSession.save(entity);
        currentTransaction.commit();
        currentSession.close();
    }
 
	@Override
    public void update(T entity) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    	currentSession.update(entity);
        currentTransaction.commit();
        currentSession.close();
    }
	
	@Override
    public void delete(T entity) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    	currentSession.delete(entity);
        currentTransaction.commit();
        currentSession.close();
    }
 
	@SuppressWarnings("unchecked")
	@Override
    public T findByColumn(String column, String condition) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        T entity = (T) currentSession.createQuery("from " + persistentClass.getSimpleName() + " e where e."
        		+ column + " = :condition").setParameter("condition", condition).uniqueResult();
        currentSession.close();
        return entity; 
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public T findByColumn(String column, Long condition) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        T entity = (T) currentSession.createQuery("from " + persistentClass.getSimpleName() + " e where e."
        		+ column + " = :condition").setParameter("condition", condition).uniqueResult();
        currentSession.close();
        return entity; 
    }
 
	@Override
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        List<T> entities = (List<T>) currentSession.createQuery("from "+persistentClass.getSimpleName()).getResultList();
        currentSession.close();
        return entities;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByColumn(String column, String condition) {
		currentSession = HibernateUtil.getSessionFactory().openSession();
        List<T> entities = (List<T>) currentSession.createQuery("from " + persistentClass.getSimpleName() + " e where e."
        		+ column + " = :condition").setParameter("condition", condition).getResultList();
        currentSession.close();
        return entities;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByColumn(String column, Long condition) {
		currentSession = HibernateUtil.getSessionFactory().openSession();
        List<T> entities = (List<T>) currentSession.createQuery("from " + persistentClass.getSimpleName() + " e where e."
        		+ column + " = :condition").setParameter("condition", condition).getResultList();
        currentSession.close();
        return entities;
	}
	
}
