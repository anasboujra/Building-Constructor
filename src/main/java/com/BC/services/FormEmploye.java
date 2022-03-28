package com.BC.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.BC.beans.Absence;
import com.BC.beans.Employe;
import com.BC.beans.Equipe;
import com.BC.beans.Salaire;
import com.BC.dao.AbsenceDao;
import com.BC.dao.EmployeDao;
import com.BC.dao.EquipeDao;
import com.BC.dao.SalaireDao;

public class FormEmploye {
	
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_PRENOM = "prenom";
	private final static String CHAMP_NOM = "nom";
	private final static String CHAMP_CIN = "cin";
	private final static String CHAMP_TELE = "tele";
	private final static String CHAMP_SALAIRE = "salaire";
	private final static String CHAMP_ID = "id";

	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	private String type = null;
	
	private EmployeDao employeDao = new EmployeDao();
	private Employe employe = new Employe();
	
	
	
	public Employe creerEmploye(HttpServletRequest request) {
		
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		Double salaire = Double.parseDouble(request.getParameter(CHAMP_SALAIRE));
				
		
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

		
		
		employe.setPrenom(prenom);
		employe.setNom(nom);
		employe.setCin(cin);
		employe.setTele(tele);
		employe.setEmail(email);
		employe.setSalaireActuel(salaire);
		
		if(erreurs.isEmpty()) {
			employeDao.add(employe);
			return employe;
	
		}
		resultat = "Echec de la creation";
		return employe;
	}
	
	

	public void supprimerEmploye(HttpServletRequest request) {
		String id = request.getParameter(CHAMP_ID) ;
		employe=employeDao.findByColumn("id", Long.parseLong(id));
		
		SalaireDao salaireDao=new SalaireDao();
		List<Salaire> listSalaire = salaireDao.findAllByColumn("employe.id", employe.getId());
		for(Salaire salaire : listSalaire) {
		  salaireDao.delete(salaire);
		}

		AbsenceDao absenceDao = new AbsenceDao();
		List<Absence> listAbsence = absenceDao.findAllByColumn("employe.id", employe.getId());
		for(Absence absence : listAbsence) {
		  absenceDao.delete(absence);
		}
		
		if(employe.getEquipe()!=null) {
			
		Equipe equipe=employe.getEquipe();	
		List<Employe> employeList=equipe.getEmploye();
		employeList.remove(employe);
		equipe.setEmploye(employeList);
		EquipeDao equipeDao = new EquipeDao();
		equipeDao.update(equipe);
		
		}

		employeDao.delete(employe);
	}
	
	

	public void modifierEmploye(HttpServletRequest request) {
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		String salaire = request.getParameter(CHAMP_SALAIRE);
		String id = request.getParameter(CHAMP_ID);
		
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
			Validator.validationSalaire( salaire );
		}catch(Exception e){
			erreurs.put(CHAMP_SALAIRE, e.getMessage());
		}
		
		
		if(erreurs.isEmpty()) {
			employe = employeDao.findByColumn("id",Long.parseLong(id) );
			employe.setPrenom(prenom);
			employe.setNom(nom);
			employe.setCin(cin);
			employe.setTele(tele);
			employe.setEmail(email);
			employe.setSalaireActuel(Double.parseDouble(salaire));
				
			employeDao.update(employe);		
	
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
