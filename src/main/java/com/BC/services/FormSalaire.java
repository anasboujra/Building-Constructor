package com.BC.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.BC.beans.Employe;
import com.BC.beans.Salaire;
import com.BC.dao.EmployeDao;
import com.BC.dao.SalaireDao;

public class FormSalaire {

	private EmployeDao employeDao= new EmployeDao();
	private SalaireDao salaireDao = new SalaireDao();
	DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	FormTransaction form=new FormTransaction();
	
	
	public void envoyerSalaires(HttpServletRequest request) {
		
		List<Employe> employeList= employeDao.findAll();
		
		for(Employe employe: employeList) {
			Salaire salaire= new Salaire();
			salaire.setEmploye(employe);
			salaire.setSalaire(employe.getSalaireActuel());
			LocalDate currentDate=LocalDate.now();
			Integer mois = currentDate.getMonthValue();
			Integer annee=currentDate.getYear();
			
			salaire.setMois(mois.toString()+"-"+annee.toString());
			
			
			form.ajouterTransaction(mois,annee, -employe.getSalaireActuel(), "Salaire");
			salaireDao.add(salaire);
		}
		HttpSession session = request.getSession();
		session.removeAttribute("RFNotifications");
	}
	

}
