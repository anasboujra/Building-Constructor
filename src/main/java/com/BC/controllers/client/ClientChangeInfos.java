package com.BC.controllers.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.beans.Client;
import com.BC.services.FormClient;

//done
@WebServlet("/client-change-infos")
public class ClientChangeInfos extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private static final String ATT_FORM = "form";
	private static final String ATT_CLIENT = "client";
	private static final String ATT_SESSION_USER = "sessionUser";
	
	private static final String VUE_CHANGE_INFOS = "/WEB-INF/view/client/change-infos.jsp";
	private static final String VUE_PROFILE = "client-profile";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_CHANGE_INFOS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormClient form = new FormClient();
		Client client = form.modifierDonnees(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_USER, client);			
			response.sendRedirect(VUE_PROFILE);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_CLIENT, client);
			this.getServletContext().getRequestDispatcher(VUE_CHANGE_INFOS).forward(request, response);
		}

	}

}