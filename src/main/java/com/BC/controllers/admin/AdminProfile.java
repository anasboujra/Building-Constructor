package com.BC.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.beans.Utilisateur;
import com.BC.services.FormAdmin;



//done
@WebServlet("/admin-profile")
public class AdminProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_FORM = "form";
	private static final String ATT_UTILISATEUR = "utilisateur";
	private static final String ATT_SESSION_USER = "sessionUser";
	
	private static final String VUE_PROFILE = "/WEB-INF/view/admin/profile.jsp";
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_PROFILE).forward(request, response) ;
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormAdmin form = new FormAdmin();
		Utilisateur utilisateur = form.modifierDonnees(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_USER, utilisateur);	
			request.setAttribute("message", "Enregistrement avec succès");
		} else {
			
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_UTILISATEUR, utilisateur);
		}
		
		this.getServletContext().getRequestDispatcher(VUE_PROFILE).forward(request, response);
		
	}

}
