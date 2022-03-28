package com.BC.controllers.dg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.CEDao;
import com.BC.services.FormDG;

//done 

@WebServlet("/dg-update-chef")
public class UpdateChef extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CEDao ceDao = new CEDao() ;
		request.setAttribute("ce", ceDao.findByColumn("id", Long.parseLong(id) )) ;
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/DG/modifierChefEquipe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormDG form = new FormDG() ;
		form.modifierAdmin(request);
		request.setAttribute("message", "Enregistrement avec succès");
		doGet(request, response);
	}

}
