package com.BC.controllers.rf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormDemande;

@WebServlet("/rf-annuler-demande")
public class AnnulerDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AnnulerDemande() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormDemande form = new FormDemande();
		form.annulerDemande(request);
		request.setAttribute("message", "Demande annulée avec succès");
		request.getRequestDispatcher("rf-demandes-achats").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}