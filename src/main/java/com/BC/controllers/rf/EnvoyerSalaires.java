package com.BC.controllers.rf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormSalaire;

//done 

@WebServlet("/rf-envoyer-salaires")
public class EnvoyerSalaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EnvoyerSalaires() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormSalaire form = new FormSalaire();
		form.envoyerSalaires(request);
		request.setAttribute("message", "Les salaires sont envoyés");
		request.getRequestDispatcher("rf-dashboard").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
