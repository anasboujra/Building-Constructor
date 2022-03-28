package com.BC.services;


import java.io.*;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.BC.beans.Consomation;
import com.BC.beans.Equipe;
import com.BC.beans.MatierePremiere;
import com.BC.beans.Projet;
import com.BC.dao.ConsomationDao;
import com.BC.dao.EquipeDao;
import com.BC.dao.MatierePremiereDao;
import com.BC.dao.ProjetDao;

public class FormProjet {
	private final static String CHAMP_TITRE = "titre";
	private final static String CHAMP_ADRESSE = "adresse";
	private final static String CHAMP_DATE_DEBUT = "dateDebut";
	private final static String CHAMP_DATE_FIN = "dateFin";
	private final static String CHAMP_SURFACE = "surface";
	private final static String CHAMP_NOMBRE_ETAGE = "nombreEtage";
	private final static String CHAMP_NOMBRE_CHAMBRE = "nombreChambre";
	private final static String CHAMP_PRIX_VENTE = "prixVente";
	private final static String CHAMP_NOMBRE_APPARTEMENT = "nombreAppartement";
	private final static String CHAMP_EQUIPE = "equipe";
	private final static String CHAMP_IMAGE = "image";
	
	private EquipeDao equipedao=new EquipeDao();
	private ProjetDao projetDao=new ProjetDao();
	private ConsomationDao consomationDao=new ConsomationDao();
	private MatierePremiereDao mpDao=new MatierePremiereDao();
	
	

	public void creerProjet(HttpServletRequest request) throws IOException, ServletException, ParseException {
		Projet projet=new Projet();

		Part filePart = request.getPart(CHAMP_IMAGE);
        InputStream inputStream = filePart.getInputStream();
        byte[] image = inputStream.readAllBytes(); 
        inputStream.close();
         
        String titre=request.getParameter(CHAMP_TITRE) ;
        String adresse=request.getParameter(CHAMP_ADRESSE);
        String dateDebut=request.getParameter(CHAMP_DATE_DEBUT);
        String dateFin=request.getParameter(CHAMP_DATE_FIN);
        String surface=request.getParameter(CHAMP_SURFACE);
        Long nbrEtage=Long.parseLong(request.getParameter(CHAMP_NOMBRE_ETAGE));
        Double prixVente= Double.parseDouble(request.getParameter(CHAMP_PRIX_VENTE));
        Long nbrAppartement=Long.parseLong(request.getParameter(CHAMP_NOMBRE_APPARTEMENT)) ;
        Long nbrChambre=Long.parseLong(request.getParameter(CHAMP_NOMBRE_CHAMBRE));
        //affectation
        projet.setTitre(titre);
        projet.setImage(image);
        projet.setAdresse(adresse);
        projet.setDateDebut(dateDebut);
        projet.setDateFin(dateFin);
        projet.setSurface(surface);
        projet.setNbEtage(nbrEtage);
        projet.setNbApp(nbrAppartement);
        projet.setNbChambres(nbrChambre);
    	projet.setPrixVente(prixVente);
    	
		//equipe
    	String id_equipe = request.getParameter(CHAMP_EQUIPE);
    	Equipe equipe=equipedao.findByColumn("id",Long.parseLong(id_equipe) );
    	//equipe-->projet
    	projet.setEquipe(equipe);
    	projetDao.add(projet);
         
	
    	List<MatierePremiere> mpList=mpDao.findAll();
    	for( MatierePremiere matiere: mpList) {
    		String mp_id =matiere.getId().toString();
        
    		if(! request.getParameter(mp_id).isEmpty()){
    			Double consomationValue=Double.parseDouble(request.getParameter(mp_id));
	          	Consomation consomation=new Consomation();
	        	consomation.setQteConsomee(consomationValue);
	        	consomation.setMp(matiere);
	        	consomation.setProjet(projet);
	        	consomationDao.add(consomation);
	        	matiere.setPrix(matiere.getPrix()*(1-consomationValue/matiere.getQuantiteStockee()));
	        	matiere.setQuantiteStockee(matiere.getQuantiteStockee()-consomationValue);
	        	mpDao.update(matiere);
           }
	   }
	}
	
	
	
	
	
	
	
	public List<Projet> allProjets() {
		
		List<Projet> projets = projetDao.findAll();;
		return projets;
	}
	
	
	public List<Projet> showProjets() {
		
		List<Projet> projets = projetDao.findNewest();;
		return projets;
	}
	
	
	
}