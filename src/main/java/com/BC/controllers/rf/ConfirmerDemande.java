package com.BC.controllers.rf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormDemande;


@WebServlet("/rf-confirmer-demande")
public class ConfirmerDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConfirmerDemande() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormDemande form = new FormDemande();
		form.confirmerDemande(request);
		request.setAttribute("message", "Demande confirmeée avec succès");
		request.getRequestDispatcher("rf-demandes-achats").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
