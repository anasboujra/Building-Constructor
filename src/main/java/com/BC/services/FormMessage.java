package com.BC.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.Client;
import com.BC.beans.Message;
import com.BC.dao.MessageDao;

public class FormMessage {
	
	private final static String CHAMP_ID = "id";
	private final static String CHAMP_PRENOM = "prenom";
	private final static String CHAMP_NOM = "nom";
	private final static String CHAMP_TELE = "tele";
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_CONTENU = "contenu";
	private final static String CHAMP_REPONSE = "reponse";
	
	private static final String ATT_SESSION_USER = "sessionUser";
	
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	private MessageDao messageDao = new MessageDao();
	
	
	
	public Message creerMessage(HttpServletRequest request) {
		
		Message message = null;
		String prenom = request.getParameter(CHAMP_PRENOM);
		String nom = request.getParameter(CHAMP_NOM);
		String tele = request.getParameter(CHAMP_TELE);
		String email = request.getParameter(CHAMP_EMAIL);
		String contenu = request.getParameter(CHAMP_CONTENU);
		
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
			Validator.validationContenu(contenu);
		}catch(Exception e){
			erreurs.put(CHAMP_CONTENU, e.getMessage());
		}
		
		
		message = new Message();
		message.setPrenom(prenom);
		message.setNom(nom);
		message.setTele(tele);
		message.setEmail(email);
		message.setContenu(contenu);
		
		
		if(erreurs.isEmpty()) {
			messageDao.add(message);
			return message;
	
		}
		resultat = "Echec de l'operation";
		return message;
	}
	
	
	public List<Message> messagesClient(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute(ATT_SESSION_USER);
		
		List<Message> messages = messageDao.findAllByColumn("email", client.getEmail());
		return messages;
	}
	
	
	public List<Message> messagesNonRep() {
		
		List<Message> allMessages = messageDao.findAll();
		List<Message> messages = new ArrayList<Message>();
		
		for(Message message : allMessages) {
			if(message.getReponse() == null) {
				messages.add(message);
			}
		}
		return messages;
	}
	
	
	public Message afficherMessage(String idMessage) {

		Message message = messageDao.findByColumn("id", Long.parseLong(idMessage));
		return message;
	}
	
	
	public void supprimerMessage(String id) {
		Message message = messageDao.findByColumn("id", Long.parseLong(id));
		
		messageDao.delete(message);
    }
	
	
	public void repondreMessage(HttpServletRequest request) {
		
		String id = request.getParameter(CHAMP_ID);
		String email = request.getParameter(CHAMP_EMAIL);
		String reponse = request.getParameter(CHAMP_REPONSE);
		
		Message message = messageDao.findByColumn("id", Long.parseLong(id));
		
		if(message != null) {
			message.setReponse(reponse);
			String text = reponse + "\n\n(Votre message: " + message.getContenu() + ")";
			EnvoyerEmail.envoyerEmail("Réponse à votre message: "+id, text, email);
			
			messageDao.update(message);
		}
		
    }
	
	
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}
	
}
