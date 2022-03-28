package com.BC.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.SalaireDao;

//done

@WebServlet("/admin-archive-salaires")
public class ArchiveSalaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalaireDao salaireDao= new SalaireDao();
		request.setAttribute("wages", salaireDao.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/archiveSalaires.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

