package com.BC.controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.beans.Projet;
import com.BC.services.FormProjet;
import com.BC.services.FormDemande;

//done
@WebServlet("/client-demande")
public class ClientDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_PROJETS = "projets";
	private static final String ID_PROJET = "projet";
	
	
	private static final String VUE_DEMANDE = "/WEB-INF/view/client/demande.jsp";
	private static final String VUE_PROFILE = "client-profile";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProjet = request.getParameter(ID_PROJET);
		
		if(idProjet != null) {
			FormDemande form = new FormDemande();
			form.creerDemande(request);
			response.sendRedirect(VUE_PROFILE);
		} else {
			FormProjet form = new FormProjet();
			List<Projet> projets = form.allProjets();
			request.setAttribute(ATT_PROJETS, projets);

			this.getServletContext().getRequestDispatcher(VUE_DEMANDE).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}