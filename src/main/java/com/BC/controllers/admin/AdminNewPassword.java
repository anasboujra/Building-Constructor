package com.BC.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.services.FormAdmin;

//done
@WebServlet("/new-password-admin")
public class AdminNewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_FORM = "form";
	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_USER_TYPE = "userType";
	private static final String ATT_EMAIL_CODE = "emailCode";
	
	private static final String VUE_NEW_PASSWORD = "/WEB-INF/view/admin/new-password.jsp";
	private static final String VUE_CONNEXION = "login-admin";
	private static final String VUE_ACCUEIL = "accueil";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		if(session.getAttribute(ATT_SESSION_USER) == null && session.getAttribute(ATT_EMAIL_CODE)!=null) {
			this.getServletContext().getRequestDispatcher(VUE_NEW_PASSWORD).forward(request, response);
		}else {
			response.sendRedirect(VUE_ACCUEIL);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormAdmin form = new FormAdmin();
		form.newPassword(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_EMAIL_CODE, null);
			session.setAttribute(ATT_USER_TYPE, null);
			response.sendRedirect(VUE_CONNEXION);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			session.setAttribute(ATT_SESSION_USER, null);
			this.getServletContext().getRequestDispatcher(VUE_NEW_PASSWORD).forward(request, response);
		}

	}
}