package com.BC.services;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.Client;
import com.BC.dao.ClientDao;


public class FormClient {
	
	private final static String CHAMP_PRENOM = "prenom";
	private final static String CHAMP_NOM = "nom";
	private final static String CHAMP_CIN = "cin";
	private final static String CHAMP_TELE = "tele";
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_OLDMOTDEPASSE = "oldMotDePasse";
	private final static String CHAMP_MOTDEPASSE = "motDePasse";
	private final static String CHAMP_MOTDEPASSE_CONF = "motDePasseConf";
	private static final String CHAMP_CODE = "code";

	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_EMAIL_CODE = "emailCode";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	private ClientDao clientDao = new ClientDao();
	
	
	public Client connexion(HttpServletRequest request) {
		
		Client client = null;
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
		
		if(erreurs.isEmpty()) {
			client = clientDao.verify(email, motDePasseMD5);
			if(client != null) {
				return client;
			}
		}
		resultat = "Echec de la connexion";
		client = new Client();
		client.setEmail(email);
		client.setMotDePasse(motDePasseMD5);
		
		return client;
	}
	
	
	
	public Client creerCompte(HttpServletRequest request) {
		
		Client client = null;
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		String motDePasseConf = request.getParameter(CHAMP_MOTDEPASSE_CONF);
		String motDePasseMD5 = Validator.crypterMotDePasseMD5(motDePasse);
		
		
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
		
		client = new Client();
		client.setPrenom(prenom);
		client.setNom(nom);
		client.setCin(cin);
		client.setTele(tele);
		client.setEmail(email);
		client.setMotDePasse(motDePasseMD5);
		
		
		if(erreurs.isEmpty()) {
			clientDao.add(client);
			return client;
	
		}
		resultat = "Echec de la creation";
		return client;
	}


	public Client motDePasseOublie(HttpServletRequest request) {
		
		Client client = null;
		String email = request.getParameter(CHAMP_EMAIL);
		
		try {
			Validator.validationEmail(email);
		}catch(Exception e){
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		
		if(erreurs.isEmpty()) {
			client = clientDao.findByColumn("email", email);
			if(client != null) {
				return client;
			}else {
				resultat = "Il n'y a pas de compte associé à cet email";
			}
		}
		client = new Client();
		client.setEmail(email);		
		return client;
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
	
	public void newPassword(HttpServletRequest request) {
		
		Client client = null;
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
			client = clientDao.findByColumn("email", email);
			if(client != null) {
				client.setMotDePasse(motDePasseMD5);
				clientDao.update(client);
			}
		}
	}
	
	public Client changePassword(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute(ATT_SESSION_USER);
		String email = client.getEmail();
		String oldMotDePasse = request.getParameter(CHAMP_OLDMOTDEPASSE);
		String oldMotDePasseMD5 = Validator.crypterMotDePasseMD5(oldMotDePasse);
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		String motDePasseConf = request.getParameter(CHAMP_MOTDEPASSE_CONF);
		String motDePasseMD5 = Validator.crypterMotDePasseMD5(motDePasse);
		
		try {
			Validator.validationMotDePasee(oldMotDePasse);
		}catch(Exception e){
			erreurs.put(CHAMP_OLDMOTDEPASSE, e.getMessage());
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
			client = clientDao.verify(email, oldMotDePasseMD5);
			if(client != null) {
				client.setMotDePasse(motDePasseMD5);
				clientDao.update(client);
				return client;
			} else {
				erreurs.put(CHAMP_OLDMOTDEPASSE, "Mot de passe incorrect");
			}
		}
		resultat = "Echec";
		return null;
	}
	
	
	public Client modifierDonnees(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute(ATT_SESSION_USER);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String cin = request.getParameter(CHAMP_CIN);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);


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
		
		if(erreurs.isEmpty()) {
			client.setPrenom(prenom);
			client.setNom(nom);
			client.setCin(cin);
			client.setTele(tele);
			client.setEmail(email);
			clientDao.update(client);
			return client;
		}
		Client clientChamp = new Client();
		clientChamp.setPrenom(prenom);
		clientChamp.setNom(nom);
		clientChamp.setCin(cin);
		clientChamp.setTele(tele);
		clientChamp.setEmail(email);
		
		resultat = "Echec";
		return clientChamp;
	}
	
	

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}
	
	

}
