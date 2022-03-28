package com.BC.controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.beans.Message;
import com.BC.services.FormMessage;

//done
@WebServlet("/messages-client")
public class ClientMessages extends HttpServlet {
private static final long serialVersionUID = 1L;
    

	private static final String ATT_USER_TYPE = "userType";
	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_FORM = "form";
	private static final String ATT_MESSAGE = "message";
	private static final String ATT_SUPPRIMER = "supprimer";
	private static final String ATT_MESSAGES = "messages";
	
	private static final String VUE_CLIENT_MESSAGES = "/WEB-INF/view/client/messages.jsp";
	private static final String VUE_MESSAGE = "messages-client";
	private static final String VUE_INDEX = "/WEB-INF/view/index.jsp";
	private static final String VUE_DETAILS_MESSAGE = "/WEB-INF/view/client/details-message.jsp";
	private static final String VUE_ACCUEIL = "accueil";

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		
		if(session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("client")) {
			
			String idAfficher = request.getParameter(ATT_MESSAGE);
			String idSupprimer = request.getParameter(ATT_SUPPRIMER);
			
			if(idAfficher != null) {
				FormMessage form = new FormMessage();
				Message message = form.afficherMessage(idAfficher);
				request.setAttribute(ATT_MESSAGE, message);
				
				this.getServletContext().getRequestDispatcher(VUE_DETAILS_MESSAGE).forward(request, response);
			} else if(idSupprimer != null) {
				FormMessage form = new FormMessage();
				form.supprimerMessage(idSupprimer);

				response.sendRedirect(VUE_MESSAGE);
			} else {
				FormMessage form = new FormMessage();
				List<Message> messages = form.messagesClient(request);
				request.setAttribute(ATT_MESSAGES, messages);

				this.getServletContext().getRequestDispatcher(VUE_CLIENT_MESSAGES).forward(request, response);
			}
		} else {
			response.sendRedirect(VUE_ACCUEIL);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormMessage form = new FormMessage();
		Message message = form.creerMessage(request);
				
		if(form.getErreurs().isEmpty()) {
			response.sendRedirect(VUE_MESSAGE);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_MESSAGE, message);
			this.getServletContext().getRequestDispatcher(VUE_INDEX).forward(request, response);
			
		}

	}
}
