package com.BC.controllers.ce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormEquipe;

//done

@WebServlet("/ce-mon-equipe")
public class MonEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormEquipe form= new FormEquipe();
		request.setAttribute("monEquipe", form.getMyTeam(request));
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CE/monEquipe.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
