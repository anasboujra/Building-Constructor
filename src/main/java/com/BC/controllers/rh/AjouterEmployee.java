package com.BC.controllers.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormEmploye;

@WebServlet("/rh-creer-employe")
public class AjouterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterEmployee() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/RH/ajouterEmployee.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormEmploye form=new FormEmploye();
		form.creerEmploye(request);
		request.setAttribute("message", "Enregistrement avec succès");
		doGet(request, response);
	}

}
