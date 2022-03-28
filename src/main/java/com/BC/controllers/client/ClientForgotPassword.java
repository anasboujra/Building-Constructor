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
@WebServlet("/forgot-password-client")
public class ClientForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_FORM = "form";
	private static final String ATT_CLIENT = "client";
	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_CODE = "code";
	private static final String ATT_EMAIL = "email";
	
	private static final String VUE_FORGOT_PASSWORD = "/WEB-INF/view/client/forgot-password.jsp";
	private static final String VUE_VERIFIER_CODE = "verifier-code-client";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_FORGOT_PASSWORD).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormClient form = new FormClient();
		Client client = form.motDePasseOublie(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty() && form.getResultat()==null) {
			String code = EnvoyerEmail.getRandom();
			String email = client.getEmail();
			session.setAttribute(ATT_CODE, code);
			session.setAttribute(ATT_EMAIL, email);
			
			EnvoyerEmail.envoyerCode(email, code);
			response.sendRedirect(VUE_VERIFIER_CODE);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_CLIENT, client);
			session.setAttribute(ATT_SESSION_USER, null);
			session.setAttribute(ATT_CODE, null);
			session.setAttribute(ATT_EMAIL, null);
			this.getServletContext().getRequestDispatcher(VUE_FORGOT_PASSWORD).forward(request, response);
		}

	}

}
