package com.BC.controllers.dg;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormDG;

//done 

@WebServlet("/dg-delete-ce")
public class DeleteCE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteCE() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       FormDG form = new FormDG();
       try {
    	   request.setAttribute("message", form.supprimerCE(request));
	} catch (ParseException e) {
		e.printStackTrace();
	}
       request.getRequestDispatcher("dg-liste-ce").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
