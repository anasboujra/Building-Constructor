package com.BC.controllers.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.services.FormClient;


//done
@WebServlet("/new-password-client")
public class ClientNewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_FORM = "form";
	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_EMAIL_CODE = "emailCode";

	
	private static final String VUE_NEW_PASSWORD = "/WEB-INF/view/client/new-password.jsp";
	private static final String VUE_CONNEXION = "login-client";
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
		FormClient form = new FormClient();
		form.newPassword(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_EMAIL_CODE, null);
			response.sendRedirect(VUE_CONNEXION);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			session.setAttribute(ATT_SESSION_USER, null);
			this.getServletContext().getRequestDispatcher(VUE_NEW_PASSWORD).forward(request, response);
		}

	}
}
