package com.BC.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.Absence;
import com.BC.beans.CE;
import com.BC.beans.Employe;
import com.BC.beans.Equipe;
import com.BC.beans.Projet;
import com.BC.beans.Salaire;
import com.BC.dao.AbsenceDao;
import com.BC.dao.CEDao;
import com.BC.dao.EmployeDao;
import com.BC.dao.EquipeDao;
import com.BC.dao.ProjetDao;
import com.BC.dao.SalaireDao;

public class FormEquipe {
		
		private final static String CHAMP_TITRE = "titre";
		private final static String CHAMP_EMPLOYEES = "emp[]";
		private final static String CHAMP_CHEF = "chef";
		private final static String CHAMP_ID = "id";
		private final static String CHAMP_ABS = "check";
		
		private Map<String, String> erreurs = new HashMap<String, String>();
		private String resultat;
		private Equipe equipe = new Equipe();
	    private EquipeDao equipeDao = new EquipeDao() ;	
	    private Employe employe = new Employe();
	    private EmployeDao employeDao = new EmployeDao();
		private CE ce = new CE() ;
		private CEDao ceDao = new CEDao() ;
	    
		public void creerEquipe(HttpServletRequest request) {
			
			String titre = request.getParameter(CHAMP_TITRE);
			String[] employees = request.getParameterValues(CHAMP_EMPLOYEES);
			String chef = request.getParameter(CHAMP_CHEF);
			
			
			ce = ceDao.findByColumn("id", Long.parseLong(chef) );
			
			
			equipe.setNom(titre);
			equipe.setCe(ce);
			ce.setEquipe(equipe);
			
			equipeDao.add(equipe);
			ceDao.update(ce);
		
			for(String i : employees) {
				
			    employe =  employeDao.findByColumn("id",Long.parseLong(i));
				
				employe.setEquipe(equipe);
				
				employeDao.update(employe);
				
			}
			
		}

        public String supprimerEquipe(HttpServletRequest request) throws ParseException {
        	String id = request.getParameter(CHAMP_ID);
        	equipe=equipeDao.findByColumn("id", Long.parseLong(id) );

        	if(equipe == null ) return "NotFound";
        	
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
        	for( Employe  employe : employeList) {
        		
        				employe.setEquipe(null);
        				employeDao.update(employe);
        			      		
        	}
        	
        	ce=equipe.getCe();
        	ce.setEquipe(null);
        	ceDao.update(ce);
        	equipe.getEmploye().clear();
        	equipeDao.update(equipe);
        	equipeDao.delete(equipe);
        	
        	return "success";
        	
        }
				
		
		public Map<String, String> getErreurs() {
			return erreurs;
		}

		public String getResultat() {
			return resultat;
		}
		
		public List<Employe> getMyTeam(HttpServletRequest request){
			HttpSession session=request.getSession();
			CE ceSession= (CE) session.getAttribute("sessionUser");						
			CE ce = ceDao.findByColumn("id", ceSession.getId());
			if(ce.getEquipe() != null ) {
				return ce.getEquipe().getEmploye();
			}
			return null;
		}
		
		public List<Salaire> getWagesTeam(HttpServletRequest request){
			List<Salaire> Wages=new ArrayList<Salaire>();
			
			HttpSession session=request.getSession();
			CE ceSession= (CE) session.getAttribute("sessionUser");						
			CE ce = ceDao.findByColumn("id", ceSession.getId());
			SalaireDao salaireDao = new SalaireDao();
			
			if(ce.getEquipe() != null) {
				for(Employe employe : ce.getEquipe().getEmploye() ) {
					List<Salaire> WagesEmp=salaireDao.findAllByColumn("employe.id", employe.getId()) ;
	                Wages.addAll(WagesEmp);
				}	
			}
			
			return Wages;
		}
		
		public void noterAbsence(HttpServletRequest request) {
			
			    AbsenceDao absenceDao=new AbsenceDao();
			    
			    Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
			    String Today = formatter.format(date);
			    
			    String[] emp_id=request.getParameterValues(CHAMP_ABS);
			    List<String> list ;
			    
			    if(emp_id!=null)  list = Arrays.asList(emp_id);
			    else list =new ArrayList<>();
			    
			    HttpSession session=request.getSession();
			    
			    CE ce= (CE) session.getAttribute("sessionUser");
			    equipe=ce.getEquipe();
			    
			for(Employe employe:equipe.getEmploye()) {	
				Long count=absenceDao.count(employe.getId() , Today);
				Absence absence;
				Boolean present=list.contains(employe.getId().toString());
				if(count==0) {
					absence=new Absence();
					absence.setPresent(present);
					absence.setEmploye(employe);
					absence.setDate(Today);
					absenceDao.add(absence);
				}
				else {
					absence=absenceDao.find(employe.getId(), Today) ;
				    absence.setPresent(present);
				    absence.setEmploye(employe);
				    absence.setDate(Today);
				    absenceDao.update(absence);
				}
			}
			
		
			
		}
		
		
}
