package com.BC.controllers.rh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.beans.Message;
import com.BC.services.FormMessage;


//done
@WebServlet("/rh-messages")
public class Messages extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	private static final String ATT_MESSAGE = "message";
	private static final String ATT_REPONDRE = "repondre";
	private static final String ATT_SUPPRIMER = "supprimer";
	private static final String ATT_MESSAGES = "messages";
	
	private static final String VUE_MESSAGES = "/WEB-INF/view/admin/RH/messages.jsp";
	private static final String VUE_MESSAGE = "rh-messages";
	private static final String VUE_DETAILS_MESSAGE = "/WEB-INF/view/admin/RH/details-message.jsp";
	private static final String VUE_REPONDRE_MESSAGE = "/WEB-INF/view/admin/RH/repondre-message.jsp";

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idAfficher = request.getParameter(ATT_MESSAGE);
		String idRepondre = request.getParameter(ATT_REPONDRE);
		String idSupprimer = request.getParameter(ATT_SUPPRIMER);
		
		if(idAfficher != null) {
			FormMessage form = new FormMessage();
			Message message = form.afficherMessage(idAfficher);
			request.setAttribute(ATT_MESSAGE, message);
			
			this.getServletContext().getRequestDispatcher(VUE_DETAILS_MESSAGE).forward(request, response);
			
		} else if(idRepondre != null) {
			FormMessage form = new FormMessage();
			Message message = form.afficherMessage(idRepondre);
			request.setAttribute(ATT_MESSAGE, message);
			
			this.getServletContext().getRequestDispatcher(VUE_REPONDRE_MESSAGE).forward(request, response);
			
		} else if(idSupprimer != null) {
			FormMessage form = new FormMessage();
			form.supprimerMessage(idSupprimer);

			response.sendRedirect(VUE_MESSAGE);
			
		} else {
			FormMessage form = new FormMessage();
			List<Message> messages = form.messagesNonRep();
			request.setAttribute(ATT_MESSAGES, messages);

			this.getServletContext().getRequestDispatcher(VUE_MESSAGES).forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormMessage form = new FormMessage();
		form.repondreMessage(request);
		
		response.sendRedirect(VUE_MESSAGE);
	}
	
}
