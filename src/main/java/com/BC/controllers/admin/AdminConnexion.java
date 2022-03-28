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
@WebServlet("/login-admin")
public class AdminConnexion extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private static final String ATT_FORM = "form";
	private static final String ATT_USER = "user";
	private static final String ATT_USER_TYPE = "userType";
	private static final String ATT_SESSION_USER = "sessionUser";

	
	private static final String VUE_CONNEXION = "/WEB-INF/view/admin/login.jsp";
	private static final String VUE_PROFILE = "admin-profile";
	private static final String VUE_DG = "dg-dashboard";
	private static final String VUE_RF = "rf-dashboard";
	private static final String VUE_RH = "rh-dashboard";

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormAdmin form = new FormAdmin();
		Utilisateur user = form.connexion(request);
		HttpSession session = request.getSession();
		String type = form.getType();
		
		if(type != null) {
			session.setAttribute(ATT_SESSION_USER, user);
			session.setAttribute(ATT_USER_TYPE, type);
			
			if(type.equals("dg")) {
				response.sendRedirect(VUE_DG);
			}
			else if(type.equals("rf")) {
				response.sendRedirect(VUE_RF);
			}
			else if(type.equals("rh")) {
				response.sendRedirect(VUE_RH);
			}
			else {
			response.sendRedirect(VUE_PROFILE);
			}
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_USER, user);
			session.setAttribute(ATT_SESSION_USER, null);
			session.setAttribute(ATT_USER_TYPE, null);
			
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
	}
	
}
