package com.BC.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormEmploye;

//done

@WebServlet("/admin-delete-employe")
public class DeleteEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteEmploye() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormEmploye form = new FormEmploye();
		form.supprimerEmploye(request);
		request.setAttribute("message", "Suppression avec succès");
		request.getRequestDispatcher("admin-employees").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
