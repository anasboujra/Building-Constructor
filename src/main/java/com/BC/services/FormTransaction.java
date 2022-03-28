package com.BC.services;

import com.BC.beans.Transaction;
import com.BC.dao.TransactionDao;

public class FormTransaction {

	private TransactionDao transactionDao= new TransactionDao();
	public void ajouterTransaction(Integer mois , Integer annee , Double valeur, String source) {
		Transaction transaction=new Transaction();
		
		transaction.setAnnee(annee);
		transaction.setMois(mois);
		transaction.setValeur(valeur);
		transaction.setSource(source);
		
		transactionDao.add(transaction);
	}
}
