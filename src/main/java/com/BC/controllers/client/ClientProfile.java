package com.BC.controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.BC.beans.DemandeAchat;
import com.BC.services.FormDemande;

//done
@WebServlet("/client-profile")
public class ClientProfile extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private static final String ATT_DEMANDES = "demandes";
	private static final String ATT_DEMANDE = "demande";
	private static final String ATT_ANNULER = "annuler";

	
	private static final String VUE_PROFILE = "client-profile";
	private static final String VUE_PROFILE_CLIENT = "/WEB-INF/view/client/profile.jsp";
	private static final String VUE_DETAILS_DEMANDE = "/WEB-INF/view/client/details-demande.jsp";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idDemande = request.getParameter(ATT_DEMANDE);
		String idAnnuler = request.getParameter(ATT_ANNULER);
		
		if(idDemande != null) {
			FormDemande form = new FormDemande();
			DemandeAchat demande = form.afficherDemande(request);
			request.setAttribute(ATT_DEMANDE, demande);
			
			this.getServletContext().getRequestDispatcher(VUE_DETAILS_DEMANDE).forward(request, response);

		} else if(idAnnuler != null) {
			FormDemande form = new FormDemande();
			form.annulerDemande(request);

			response.sendRedirect(VUE_PROFILE);
		} else {
			
			FormDemande form = new FormDemande();
			List<DemandeAchat> demandes = form.demandesClient(request);
			request.setAttribute(ATT_DEMANDES, demandes);

			this.getServletContext().getRequestDispatcher(VUE_PROFILE_CLIENT).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
