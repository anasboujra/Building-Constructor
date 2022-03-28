package com.BC.controllers.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.beans.Client;
import com.BC.services.EnvoyerEmail;
import com.BC.services.FormClient;

//done
@WebServlet("/register-client")
public class ClientRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_FORM = "form";
	private static final String ATT_CLIENT = "client";
	private static final String ATT_USER_TYPE = "userType";
	private static final String ATT_SESSION_USER = "sessionUser";
	
	private static final String VUE_REGISTER = "/WEB-INF/view/client/register.jsp";
	private static final String VUE_CONNEXION = "login-client";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_REGISTER).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormClient form = new FormClient();
		Client client = form.creerCompte(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty() && form.getResultat()==null) {
			EnvoyerEmail.envoyerSucces(client.getEmail());
			response.sendRedirect(VUE_CONNEXION);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_CLIENT, client);
			session.setAttribute(ATT_SESSION_USER, null);
			session.setAttribute(ATT_USER_TYPE, null);
			this.getServletContext().getRequestDispatcher(VUE_REGISTER).forward(request, response);
		}

	}
}
