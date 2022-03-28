package com.BC.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.CE;
import com.BC.beans.Credit;
import com.BC.beans.DG;
import com.BC.beans.RF;
import com.BC.beans.RH;
import com.BC.beans.Salaire;
import com.BC.beans.Utilisateur;
import com.BC.dao.CEDao;
import com.BC.dao.CreditDao;
import com.BC.dao.DGDao;
import com.BC.dao.RFDao;
import com.BC.dao.RHDao;
import com.BC.dao.SalaireDao;



public class FormAdmin {
	
	private final static String CHAMP_PRENOM = "prenom";
	private final static String CHAMP_NOM = "nom";
	private final static String CHAMP_CIN = "cin";
	private final static String CHAMP_TELE = "tele";
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_MOTDEPASSE = "motDePasse";
	private final static String CHAMP_MOTDEPASSE_CONF = "motDePasseConf";
	private static final String CHAMP_CODE = "code";
	
	private static final String ATT_EMAIL_CODE = "emailCode";
	private static final String ATT_USER_TYPE = "userType";

	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	private String type;
	
	private DGDao dgDao = new DGDao();
	private RFDao rfDao = new RFDao() ;
	private RHDao rhDao = new RHDao() ;
	private CEDao ceDao = new CEDao() ;
	private CreditDao creditDao = new CreditDao();
	private SalaireDao salaireDao=new SalaireDao();
	
	
	
	
	public Utilisateur connexion(HttpServletRequest request) {
		
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		String motDePasseMD5 = Validator.crypterMotDePasseMD5(motDePasse);
		
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
		
		return verifyUser(email, motDePasseMD5 , request);
	}
	

	
	public Utilisateur verifyUser(String email, String motDePasseMD5 , HttpServletRequest request) {
		Utilisateur user;

		if(erreurs.isEmpty()) {
			user = dgDao.verify(email, motDePasseMD5);
			if(user != null) {
				type="dg";
				DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate currentDate=LocalDate.parse( LocalDate.now().toString() ,format);
				List<Credit> creditList = creditDao.findAllByColumn("valider", "false");
				List<Credit> credits=new ArrayList<Credit>();
				for(Credit credit : creditList) {
					LocalDate date=LocalDate.parse(credit.getDateEpargne(), format);
					if( currentDate.isAfter(date) || currentDate.isEqual(date)) {
			    	   credits.add(credit);
					}			       
				}
				if(! credits.isEmpty()) {
					HttpSession session = request.getSession();
					session.setAttribute("credits", credits);
				}
				return user;
				
			} else {
				user = rfDao.verify(email, motDePasseMD5);
				if(user != null) {
					type="rf";
					LocalDate currentDate=LocalDate.now();					
					Integer mois = currentDate.getMonthValue();
					Integer annee=currentDate.getYear();
					String moisAnnee=mois.toString()+"-"+annee.toString();
					List<Salaire> salaireList = salaireDao.findAllByColumn("mois", moisAnnee);
					if(salaireList.isEmpty()) {
						HttpSession session = request.getSession();
						session.setAttribute("RFNotifications", "salaires");
					}
					return user;
				}else {
					user = rhDao.verify(email, motDePasseMD5);
					if(user != null) {
						type="rh";
						return user;
					}else {
						user = ceDao.verify(email, motDePasseMD5);
						if(user != null) {
							type="ce";
							return user;
						}
					}
				}
			}
		}
		resultat = "Echec de la connexion";
		user = new Utilisateur();
		user.setEmail(email);
		user.setMotDePasse(motDePasseMD5);
		return user;
	}
	
	
	public Utilisateur motDePasseOublie(HttpServletRequest request) {
		
		Utilisateur user = null;
		String email = request.getParameter(CHAMP_EMAIL);
		
		try {
			Validator.validationEmail(email);
		}catch(Exception e){
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		
		if(erreurs.isEmpty()) {
			user = dgDao.findByColumn("email", email);
			if(user != null) {
				type="dg";
				return user;
			} else {
				user = rfDao.findByColumn("email", email);
				if(user != null) {
					type="rf";
					return user;
				} else {
					user = rhDao.findByColumn("email", email);
					if(user != null) {
						type="rh";
						return user;
					} else {
						user = ceDao.findByColumn("email", email);
						if(user != null) {
							type="ce";
							return user;
						}
					}
				}
			}
		}
		
		resultat = "Il n'y a pas de compte associé à cet email";
		user = new Utilisateur();
		user.setEmail(email);		
		return user;
	}
	
	
	
	public void newPassword(HttpServletRequest request) {
		
		Utilisateur user = null;
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		String motDePasseConf = request.getParameter(CHAMP_MOTDEPASSE_CONF);
		String motDePasseMD5 = Validator.crypterMotDePasseMD5(motDePasse);
		
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
		
		if(erreurs.isEmpty()) {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute(ATT_EMAIL_CODE);
			String type = (String) session.getAttribute(ATT_USER_TYPE);
			
			switch(type) {
			case "dg":
				user = dgDao.findByColumn("email", email);
				if(user != null) {
					user.setMotDePasse(motDePasseMD5);
					dgDao.update((DG) user);
				}break;
				
			case "rf":
				user = rfDao.findByColumn("email", email);
				if(user != null) {
					user.setMotDePasse(motDePasseMD5);
					rfDao.update((RF) user);
				}break;
				
			case "rh":
				user = rhDao.findByColumn("email", email);
				if(user != null) {
					user.setMotDePasse(motDePasseMD5);
					rhDao.update((RH) user);
				}break;
				
			case "ce":
				user = ceDao.findByColumn("email", email);
				if(user != null) {
					user.setMotDePasse(motDePasseMD5);
					ceDao.update((CE) user);
				}break;
			}
		}
	}
	
	
	
	public String verifierCode(HttpServletRequest request) {
		String code = request.getParameter(CHAMP_CODE);
		try {
			Validator.validationCode(code);
		}catch(Exception e){
			erreurs.put(CHAMP_CODE, e.getMessage());
		}
		
		if(erreurs.isEmpty()) {
			resultat = "Le code n'est pas valid.";
			return code;
		}
		return null;
	}
	

	
	
	public Utilisateur modifierDonnees(HttpServletRequest request) {
		
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		String motDePasseConf = request.getParameter(CHAMP_MOTDEPASSE_CONF);
		String motDePasseMD5 = Validator.crypterMotDePasseMD5(motDePasse);
		
		HttpSession session = request.getSession();
		String type=(String) session.getAttribute(ATT_USER_TYPE);
		
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
		
		if(erreurs.isEmpty()) {
			if(type.equals("dg")) {
				DG dg = (DG) session.getAttribute("sessionUser");
				dg.setCin(cin);
				dg.setEmail(email);
				dg.setNom(nom);
				dg.setPrenom(prenom);
				dg.setTele(tele);
                dg.setMotDePasse(motDePasseMD5);
				dgDao.update(dg);
				return dg;
			} 
			
			else if(type.equals("rf")) {
				RF rf = (RF) session.getAttribute("sessionUser");
				rf.setPrenom(prenom);
				rf.setNom(nom);
				rf.setCin(cin);
				rf.setTele(tele);
				rf.setEmail(email);
				rf.setMotDePasse(motDePasseMD5);
				rfDao.update(rf);
				return rf;
			}
			
			else if(type.equals("rh")) {
				RH rh = (RH) session.getAttribute("sessionUser");
				rh.setPrenom(prenom);
				rh.setNom(nom);
				rh.setCin(cin);
				rh.setTele(tele);
				rh.setEmail(email);
				rh.setMotDePasse(motDePasseMD5);
				rhDao.update(rh);	
				return rh;
			}
			
			else if(type.equals("ce")) {
				CE ce = (CE) session.getAttribute("sessionUser");
				ce.setPrenom(prenom);
				ce.setNom(nom);
				ce.setCin(cin);
				ce.setTele(tele);
				ce.setEmail(email);
				ce.setMotDePasse(motDePasseMD5);
				ceDao.update(ce);
				return ce;
			}
		}
		
		resultat = "Echec de la modification";
		Utilisateur user = new Utilisateur();
		user.setPrenom(prenom);
		user.setNom(nom);
		user.setCin(cin);
		user.setTele(tele);
		user.setEmail(email);
		user.setMotDePasse(motDePasseMD5);
		return user;
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
