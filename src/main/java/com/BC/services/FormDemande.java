package com.BC.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.Client;
import com.BC.beans.DemandeAchat;
import com.BC.beans.Projet;
import com.BC.dao.DemandeAchatDao;
import com.BC.dao.ProjetDao;

public class FormDemande {
	
	private static final String ID_PROJET = "projet";
	private static final String ID_DEMANDE = "demande";

	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_ANNULER = "annuler";
	private static final String ATT_CONFIRMER = "confirmer";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	private ProjetDao projetDao = new ProjetDao();
	private DemandeAchatDao demandeDao = new DemandeAchatDao();
	
	
	
	
	public void creerDemande(HttpServletRequest request) {
		DemandeAchat demande = new DemandeAchat();
		demande.setEtat("En traitement");
		
		String idProjet = request.getParameter(ID_PROJET);
		Projet projet = projetDao.findByColumn("id", Long.parseLong(idProjet));
		
		if(projet != null) {
			if(projet.getNbApp() > projet.getNbAppVendues()) {
				
				projet.ajouterVente();
				projetDao.update(projet);
				
				demande.setProjet(projet);
				
				HttpSession session = request.getSession();
				Client client = (Client) session.getAttribute(ATT_SESSION_USER);
				demande.setClient(client);
				
				LocalDateTime date = demande.getDateDemande().plusDays(3).withHour(10).withMinute(0).withSecond(0).withNano(0);
				String day = date.getDayOfWeek().toString();
				
				if(day.equals("SATURDAY")) {
					date = date.plusDays(2);
				} else if(day.equals("SUNDAY")) {
					date = date.plusDays(1);
				}
				
				demande.setDateRDV(date);
				
				demandeDao.add(demande);
			}
		}
	}
	

	public List<DemandeAchat> demandesClient(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute(ATT_SESSION_USER);
		
		List<DemandeAchat> demandes = demandeDao.findAllByColumn("client.id", client.getId());
		return demandes;
	}
	
	
	public DemandeAchat afficherDemande(HttpServletRequest request) {
		String idDemande = request.getParameter(ID_DEMANDE);

		DemandeAchat demande = demandeDao.findByColumn("id", Long.parseLong(idDemande));
		return demande;
	}
	
	public void annulerDemande(HttpServletRequest request) {
		String id = request.getParameter(ATT_ANNULER);
		DemandeAchat demande = demandeDao.findByColumn("id", Long.parseLong(id));
		
		Projet projet = projetDao.findByColumn("id", demande.getProjet().getId());
		
		projet.annulerVente();
		projetDao.update(projet);
		
		demandeDao.delete(demande);
    }
	
	public void confirmerDemande(HttpServletRequest request) {
		String id = request.getParameter(ATT_CONFIRMER);
		DemandeAchat demande = demandeDao.findByColumn("id", Long.parseLong(id));
		
		
		LocalDateTime currentDateTime=LocalDateTime.now();
		demande.setEtat("Vendu");
		demande.setDateAchat(currentDateTime);
		
		demandeDao.update(demande);
		
		LocalDate currentDate=LocalDate.now();
		Integer mois = currentDate.getMonthValue();
	    Integer annee=currentDate.getYear();

	    FormTransaction form=new FormTransaction();
	    form.ajouterTransaction(mois,annee, demande.getProjet().getPrixVente(), "Vente");
		
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}
	
	

}
