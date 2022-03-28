package com.BC.services;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnvoyerEmail {
	
	private final static String ENVOYEUR_EMAIL = "constructor.contact@gmail.com";
	private final static String ENVOYEUR_PASSWORD = "10209080";
	
	
	
	
	public static String getRandom() {
		Random random = new Random();
		int numero = random.nextInt(99999999);
		String resultat = String.format("%08d", numero);
		return resultat;
	}
	
	public static void envoyerSucces(String destinataire) {
		String subject = "FÉLICITATIONS";
		String Text = "Bienvenue à BUILDING CONSTRUCTOR.\n\n"
				+ "Toutes nos félicitations! Votre compte a été créé avec succès.\n\n"
				+ "Cordialement";
		
		envoyerEmail(subject, Text, destinataire);
	}
	
	
	public static void envoyerCode(String destinataire, String code) {
		String subject = "Code de sécurité";
		String Text = "Bonjour,\n"
				+ "Nous avons reçu une demande de réinitialisation de votre mot de passe .\n"
				+ "Entrez le code de réinitialisation du mot de passe suivant : " + code + "\n"
				+ "(Vous pouvez changer directement votre mot de passe).";
		
		envoyerEmail(subject, Text, destinataire);
	}
	
	
	public static void envoyerEmail(String subject, String Text, String destinataire) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protocol", "smtp");    
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		try {
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(ENVOYEUR_EMAIL, ENVOYEUR_PASSWORD);
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ENVOYEUR_EMAIL));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));

			message.setSubject(subject);
			message.setText(Text);

			Transport.send(message);

		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	
}
