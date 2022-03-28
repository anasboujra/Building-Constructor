package com.BC.controllers.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormDG;


@WebServlet("/rh-dashboard")
public class RH extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RH() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormDG form = new FormDG();
		form.dgGetStatistiques(request);
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/RH/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
