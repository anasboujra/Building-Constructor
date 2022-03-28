package com.BC.controllers.dg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormDG;

//done 

@WebServlet("/dg-delete-rf")
public class DeleteRF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteRF() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       FormDG form = new FormDG();
       form.supprimerRF(request);
       request.setAttribute("message", "Suppression réussie");
       request.getRequestDispatcher("dg-liste-rf").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}