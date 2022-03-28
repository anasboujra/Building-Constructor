package com.BC.controllers.rh;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormEquipe;

@WebServlet("/rh-supprimer-equipe")
public class SupprimerEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SupprimerEquipe() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormEquipe form = new FormEquipe();
		try {
			request.setAttribute("message", form.supprimerEquipe(request));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    request.getRequestDispatcher("rh-equipes").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
