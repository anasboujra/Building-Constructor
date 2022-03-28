package com.BC.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.CE;
import com.BC.beans.DG;
import com.BC.beans.Employe;
import com.BC.beans.Equipe;
import com.BC.beans.Projet;
import com.BC.beans.RF;
import com.BC.beans.RH;
import com.BC.beans.Transaction;
import com.BC.beans.Utilisateur;
import com.BC.dao.CEDao;
import com.BC.dao.DGDao;
import com.BC.dao.EmployeDao;
import com.BC.dao.EquipeDao;
import com.BC.dao.ProjetDao;
import com.BC.dao.RFDao;
import com.BC.dao.RHDao;
import com.BC.dao.TransactionDao;

public class FormDG {
	
	private final static String CHAMP_PRENOM = "prenom"; 
	private final static String CHAMP_NOM = "nom";
	private final static String CHAMP_CIN = "cin";
	private final static String CHAMP_TELE = "tele";
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_MOTDEPASSE = "motDePasse";
	private final static String CHAMP_TYPE = "type";
	private final static String CHAMP_ID = "id";
	private final static String CHAMP_MOTDEPASSE_CONF = "motDePasseConf";
	

	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	private DGDao dgDao = new DGDao() ;
	private RFDao rfDao = new RFDao() ;
	private RHDao rhDao = new RHDao() ;
	private CEDao ceDao = new CEDao() ;
	private EquipeDao equipeDao = new EquipeDao();
	private EmployeDao employeDao = new EmployeDao() ;
	private ProjetDao projetDao = new ProjetDao() ;
	TransactionDao transactionDao=new TransactionDao();
	
	private String type;
	
	
	
	
	public Utilisateur creerAdmin(HttpServletRequest request) {
		
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		String motDePasseConf = request.getParameter(CHAMP_MOTDEPASSE_CONF);
		String motDePasseMD5 = Validator.crypterMotDePasseMD5(motDePasse);
		
		type = request.getParameter(CHAMP_TYPE) ;
		
		
		try {
			Validator.validationPrenom(prenom);
		}catch(Exception e){
			erreurs.put(CHAMP_PRENOM, e.getMessage());
		}
		
		try {
			Validator.validationNom(nom);
		}catch(Exception e){
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		
		try {
			Validator.validationCin(cin);
		}catch(Exception e){
			erreurs.put(CHAMP_CIN, e.getMessage());
		}
		
		try {
			Validator.validationTele(tele);
		}catch(Exception e){
			erreurs.put(CHAMP_TELE, e.getMessage());
		}

		try {
			Validator.validationEmail(email);
		}catch(Exception e){
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}


		
		try {
			Validator.validationMotDePasee(motDePasse);
		}catch(Exception e){
			erreurs.put(CHAMP_MOTDEPASSE, e.getMessage());
		}
		
		try {
			Validator.validationMotDePaseeConf(motDePasse, motDePasseConf);
		}catch(Exception e){
			erreurs.put(CHAMP_MOTDEPASSE_CONF, e.getMessage());
		}
		
		try {
			Validator.validationType(type);
		}catch(Exception e){
			erreurs.put(CHAMP_TYPE, e.getMessage());
		}

		
		if(type.equals("rf")) {
			RF rf = new RF();
			rf.setPrenom(prenom);
			rf.setNom(nom);
			rf.setCin(cin);
			rf.setTele(tele);
			rf.setEmail(email);
			rf.setMotDePasse(motDePasseMD5);
			if(erreurs.isEmpty()) {
				rfDao.add(rf);
				return rf;
			}
			else {
				resultat = "Echec de la creation";
				return rf;
			}
		}
		
		else if(type.equals("rh")) {
			RH rh = new RH();
			rh.setPrenom(prenom);
			rh.setNom(nom);
			rh.setCin(cin);
			rh.setTele(tele);
			rh.setEmail(email);
			rh.setMotDePasse(motDePasseMD5);
			if(erreurs.isEmpty()) {
				rhDao.add(rh);
				return rh;
			}
			else {
				resultat = "Echec de la creation";
				return rh;
			}
		}
		
		else if(type.equals("ce")) {
			CE ce = new CE();
			ce.setPrenom(prenom);
			ce.setNom(nom);
			ce.setCin(cin);
			ce.setTele(tele);
			ce.setEmail(email);
			ce.setMotDePasse(motDePasseMD5);
			if(erreurs.isEmpty()) {
				ceDao.add(ce);
				return ce;
			}
		}
		
		resultat = "Echec de la creation";
		RH user = new RH();
		user.setPrenom(prenom);
		user.setNom(nom);
		user.setCin(cin);
		user.setTele(tele);
		user.setEmail(email);
		user.setMotDePasse(motDePasseMD5);
		
		return user;
	}
	
	
	public String supprimerCE(HttpServletRequest request) throws ParseException {
		Long id = Long.parseLong(request.getParameter(CHAMP_ID));
		CE ce = ceDao.findByColumn("id", id);
		Equipe equipe = equipeDao.findByColumn("ce.id", id);

		
    	if(equipe != null ) {

        	ProjetDao projetDao=new ProjetDao();
        	List<Projet> projetList=projetDao.findAllByColumn("equipe.id", equipe.getId());
        	
        	LocalDate currentDate=LocalDate.now();
        	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        	
        	Date Today=formatter.parse(currentDate.toString());
        	
        	
        	for(Projet projet : projetList) {
        		Date date=formatter.parse(projet.getDateFin());
        		if(date.after(Today))  return "failed";        		
        	}
        	
        	for(Projet projet : projetList) {
        		projet.setEquipe(null);
        		projetDao.update(projet);
        	} 
        	
        	List<Employe> employeList=equipe.getEmploye();
    			
    			for( Employe employe: employeList) {
    				employe.setEquipe(null);
    				employeDao.update(employe);
    			}
    			
    			employeList.clear();
    			equipe.setEmploye(employeList);
    			equipeDao.update(equipe);
    			equipeDao.delete(equipe);        	
        	
    	}
    	      	
			
		ceDao.delete(ce);
		return "success";
    }
	
	
	public void supprimerRF(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter(CHAMP_ID));
		rfDao.delete(rfDao.findByColumn("id", id));
	}
	
	
	public void supprimerRH(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter(CHAMP_ID));
		rhDao.delete(rhDao.findByColumn("id", id));
	}
	
	
	public void dgGetStatistiques(HttpServletRequest request) {
		
		LocalDate currentDate=LocalDate.now();
		Integer mois = currentDate.getMonthValue() ;
		
		Integer annee=currentDate.getYear();
		
		
		List<Transaction> listTransactionAnnee = transactionDao.findAllAnneeValP(annee);
		List<Transaction> listTransactionMois = transactionDao.findAllMoisValP(mois, annee);
		List<Transaction> listTransactionPertesMois = transactionDao.findAllMoisValN(mois, annee);
		List<Transaction> listTransactionPertesAnnee = transactionDao.findAllAnneeValN(annee);

		List<Transaction> listTransactionCredits = transactionDao.findAllByColumn("source","Credit");
		List<Transaction> listTransactionVentes = transactionDao.findAllByColumn("source","Vente");

		Double RAnnuel=0.0;
		Double RMensuel=0.0;
		Double pertesMois=0.0;
		Double pertesAnnee=0.0;
		
		Double totalCredits=0.0;
		Double totalVentes=0.0;
		
		for(Transaction transaction : listTransactionAnnee) {
			RAnnuel+=transaction.getValeur();
		}
	
		for(Transaction transaction : listTransactionMois) {
			RMensuel+=transaction.getValeur();
		}
	
		for(Transaction transaction : listTransactionPertesMois) {
			pertesMois-=transaction.getValeur();
		}		

		for(Transaction transaction : listTransactionPertesAnnee) {
			pertesAnnee-=transaction.getValeur();
		}
	
		for(Transaction transaction : listTransactionCredits) {
			totalCredits+=transaction.getValeur();
		}		

		for(Transaction transaction : listTransactionVentes) {
			totalVentes+=transaction.getValeur();
		}
		
		
		List<Projet> listProjets = projetDao.findAll();
		int nombreProjets = 0;
		int nombreProjetsFini = 0;
		
		for(Projet projet : listProjets) {
			nombreProjets++;			
			DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(projet.getDateFin().toString() , format);
	        if(currentDate.isAfter(date) || currentDate.isEqual(date)) {
	        	nombreProjetsFini++;
	        }
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("RAnnuel", RAnnuel);
		session.setAttribute("RMensuel", RMensuel);
		session.setAttribute("pertesMois", pertesMois);
		session.setAttribute("pertesAnnee", pertesAnnee);
		session.setAttribute("nombreProjets", nombreProjets);
		session.setAttribute("nombreProjetsFini", nombreProjetsFini);
		
		session.setAttribute("totalCredits", totalCredits);
		session.setAttribute("totalVentes", totalVentes);
		
		
		List<String> dates = new ArrayList<String>();
		List<Double> valeurs = new ArrayList<Double>();
		LocalDate localDate = LocalDate.now();
		
		for(int i=0; i<6; i++) {
			String date = localDate.getYear()+"-"+localDate.getMonthValue();
			dates.add(date);
			Double total = (double) 0;
			List<Transaction> transactions = transactionDao.findAllMoisValP(localDate.getMonthValue(), localDate.getYear());
			for(Transaction transaction : transactions) {
				total += transaction.getValeur();
			}
			valeurs.add(total);
			localDate = localDate.minusMonths(1);
			
		}
		
		session.setAttribute("dates", dates);
		session.setAttribute("valeurs", valeurs);
		
		
	}
	
	
	
	public void modifierAdmin(HttpServletRequest request) {
		
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		String idString = request.getParameter(CHAMP_ID);
		String type = request.getParameter("type") ;
		
		try {
			Validator.validationPrenom(prenom);
		}catch(Exception e){
			erreurs.put(CHAMP_PRENOM, e.getMessage());
		}
		
		try {
			Validator.validationNom(nom);
		}catch(Exception e){
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		
		try {
			Validator.validationCin(cin);
		}catch(Exception e){
			erreurs.put(CHAMP_CIN, e.getMessage());
		}
		
		try {
			Validator.validationTele(tele);
		}catch(Exception e){
			erreurs.put(CHAMP_TELE, e.getMessage());
		}
		
		try {
			Validator.validationEmail(email);
		}catch(Exception e){
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}

		
		Long id = Long.parseLong(idString);
		
		if(erreurs.isEmpty()) {
			if(type.equals("rf")) {
				RF rf = new RF();
				rf = rfDao.findByColumn("id", id);
				rf.setPrenom(prenom);
				rf.setNom(nom);
				rf.setCin(cin);
				rf.setTele(tele);
				rf.setEmail(email);
				rfDao.update(rf);

			}else if(type.equals("rh")){
				RH rh = new RH();
				rh = rhDao.findByColumn("id", id) ;
				rh.setPrenom(prenom);
				rh.setNom(nom);
				rh.setCin(cin);
				rh.setTele(tele);
				rh.setEmail(email);
				rhDao.update(rh);
				
			}else if(type.equals("ce")){
				CE ce = new CE();
				ce = ceDao.findByColumn("id", id);
				ce.setPrenom(prenom);
				ce.setNom(nom);
				ce.setCin(cin);
				ce.setTele(tele);
				ce.setEmail(email);
				ceDao.update(ce);
			}
		}
	}
	
	
	public void creeDG() {
		List<DG> liste = dgDao.findAll();
		if(liste.isEmpty()) {
			DG dg = new DG();
			dg.setCin("T00000");
			dg.setNom("Nom");
			dg.setPrenom("Prenom");
			dg.setTele("0600000000");
			dg.setEmail("dg@admin.com");
			String md5 = Validator.crypterMotDePasseMD5("00000000");
			dg.setMotDePasse(md5);
			dg.setDateCreation(new Date());
			
			dgDao.add(dg);
		}
		
	}
	

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}
	
	public String getType() {
		return type;
	}
	
	

}
