package com.BC.controllers.dg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.beans.Utilisateur;
import com.BC.services.FormDG;

//done
@WebServlet("/dg-ajouter-admin")
public class AjouterAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_FORM = "form";
	private static final String ATT_UTILISATEUR = "utilisateur";
	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_USER_TYPE = "userType";
	
	
	
	private static final String VUE_PROFILE = "admin-profile";
	private static final String VUE_AJOUTER_ADMIN = "/WEB-INF/view/admin/DG/ajouter-admin.jsp";
	private static final String VUE_LISTE_RF = "dg-liste-rf";
	private static final String VUE_LISTE_RH = "dg-liste-rh";
	private static final String VUE_LISTE_CE = "dg-liste-ce";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		if(session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("dg")) {
			
			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_ADMIN).forward(request, response) ;
		}else {
			response.sendRedirect(VUE_PROFILE);
		}
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FormDG form = new FormDG() ;
		Utilisateur utilisateur = form.creerAdmin(request) ;
				
		if(form.getErreurs().isEmpty()) {
					
			if(form.getType().equals("rf")) {
				response.sendRedirect(VUE_LISTE_RF);
			}else if(form.getType().equals("rh")) {
				response.sendRedirect(VUE_LISTE_RH);
			}else {
				response.sendRedirect(VUE_LISTE_CE);
			} 
				
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_UTILISATEUR, utilisateur);
			request.setAttribute("errorMessage", "Enregistrement échoué");	
			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_ADMIN).forward(request, response); 
		}
	}

}
