package com.BC.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.Credit;
import com.BC.dao.CreditDao;

public class FormCredit {
	
	private final static String CHAMP_VALEUR="valeur";
	private final static String CHAMP_TAUX="taux";
	private final static String CHAMP_DATEEMPRUNT="dateEmprunt";
	private final static String CHAMP_DATEEPARGNE="dateEpargne";
	private final static String CHAMP_BANQUE="banque";
	private final static String CHAMP_ID="id";
	
	private CreditDao creditDao=new CreditDao();
	private FormTransaction form=new FormTransaction();
	
	
	
	
	
	public Credit creerCredit(HttpServletRequest request) {
		
		Double valeur = Double.parseDouble(request.getParameter(CHAMP_VALEUR)) ;
		Double taux =Double.parseDouble(request.getParameter(CHAMP_TAUX)) ;
		String dateEmprunt = request.getParameter(CHAMP_DATEEMPRUNT);
		String dateEpargne = request.getParameter(CHAMP_DATEEPARGNE);
		String banque = request.getParameter(CHAMP_BANQUE);
		
		Credit credit=new Credit();
		
		credit.setValeur(valeur);
		credit.setTaux(taux);
		credit.setDateEmprunt(dateEmprunt);
		credit.setDateEpargne(dateEpargne);
		credit.setBanque(banque);
		credit.setValider("false");

		DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date=LocalDate.parse(dateEmprunt, format);
		
		
		
		form.ajouterTransaction(date.getMonthValue(),date.getYear(), valeur, "Credit");
		creditDao.add(credit);
		return credit;
	}
	
	
	public String payerCredit(HttpServletRequest request) {
		String id = request.getParameter(CHAMP_ID);
		Credit credit=creditDao.findByColumn("id",Long.parseLong(id));
		
		if(credit == null) return "failed";
		if(credit.getValider().equals("true")) return "failed";
		
		credit.setValider("true");
		creditDao.update(credit);
		
		LocalDate currentDate=LocalDate.now();		
		Integer mois = currentDate.getMonthValue();
		Integer annee=currentDate.getYear();
		Double taux = Double.parseDouble(credit.getTaux().toString())/100;
		form.ajouterTransaction(mois,annee, -credit.getValeur()*(1+taux), "Credit");
		
		
		
		DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Credit> creditList=creditDao.findAllByColumn("valider", "false");
		List<Credit> credits=new ArrayList<Credit>();
		for(Credit LeftToPay : creditList) {
			
			
	       LocalDate date=LocalDate.parse(LeftToPay.getDateEpargne(), format);
	       if( currentDate.isAfter(date) || currentDate.isEqual(date)) {
	    	   credits.add(LeftToPay);
	    	   
	       }			       
			
		}
		HttpSession session = request.getSession();
		session.removeAttribute("credits");
		
		if(! credits.isEmpty()) {			
			session.setAttribute("credits", credits);
		}
		
		return "success";
	}

}