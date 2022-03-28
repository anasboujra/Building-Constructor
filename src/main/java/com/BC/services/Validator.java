package com.BC.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validator {
	
	public static void validationEmail(String email) throws Exception{
		if(email==null || email.length()==0) {
			throw new Exception("Saisir une adresse email");
		}
	}

	public static void validationMotDePasee(String motDePasse) throws Exception {
		if(motDePasse==null || motDePasse.length()==0) {
			throw new Exception("Saisir un mot de passe");
		}
	}

	public static void validationPrenom(String prenom) throws Exception {
		if(prenom==null || prenom.length()==0) {
			throw new Exception("Saisir un prenom");
		}
		
	}

	public static void validationNom(String nom) throws Exception {
		if(nom==null || nom.length()==0) {
			throw new Exception("Saisir un nom");
		}
		
	}

	public static void validationCin(String cin) throws Exception {
		if(cin==null || cin.length()==0) {
			throw new Exception("Saisir un cin");
		}
	}
	
	
	public static void validationType(String type) throws Exception {
		if(type==null || type.length()==0) {
			throw new Exception("Saisir un type");
		}
	}
	
	public static void validationContenu(String contenu) throws Exception {
		if(contenu==null || contenu.length()==0) {
			throw new Exception("Saisir un message");
		}
		
	}

	public static void validationTele(String tele) throws Exception {
		if(tele==null || tele.length()==0) {
			throw new Exception("Saisir un numero de telephone");
		}
		
	}
	
	public static void validationSalaire(String salaire) throws Exception {
		if(salaire==null || salaire.isEmpty() || salaire.contains("[a-zA-Z]") ) {
			throw new Exception("Salaire n'est pas valide.");
		}
		
	}

	public static void validationMotDePaseeConf(String motDePasse, String motDePasseConf) throws Exception {
		if(motDePasseConf==null || motDePasseConf.length()==0) {
			throw new Exception("Saisir une confirmation");
		}else if(!motDePasse.equals(motDePasseConf)) {
			throw new Exception("La confirmation est incorrecte");
		}	
	}
	
	
	public static void validationCode(String code) throws Exception {
		if(code==null || code.length()==0) {
			throw new Exception("Le code n'est pas valid.");
		}
		
	}
	
	
	public static String crypterMotDePasseMD5(String motDePasse) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = motDePasse.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
