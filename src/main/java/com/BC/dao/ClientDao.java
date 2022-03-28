package com.BC.dao;

import com.BC.beans.Client;
import com.BC.util.HibernateUtil;

public class ClientDao extends DaoHibernateFactory<Client> {
	
	
	public ClientDao() {
		super(Client.class);
	}
	
	public Client verify(String email, String motDePasse) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	Client client = (Client) currentSession.createQuery("from Client c where c.email = :email").setParameter("email", email).uniqueResult();
    	currentSession.close();
    	if(client != null && motDePasse.equals(client.getMotDePasse())) {
    			return client;
    	}
      	return null;
	}
	
	
	
}
