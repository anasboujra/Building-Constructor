package com.BC.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.EmployeDao;
import com.BC.services.FormEmploye;

//done

@WebServlet("/admin-update-employe")
public class UpdateEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		EmployeDao employeDao = new EmployeDao() ;
		request.setAttribute("employe", employeDao.findByColumn("id", Long.parseLong(id))) ;
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/modifierEmploye.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormEmploye form = new FormEmploye() ;
		form.modifierEmploye(request);
		request.setAttribute("message", "Enregistrement avec succès");
		doGet(request, response);
	}

}
