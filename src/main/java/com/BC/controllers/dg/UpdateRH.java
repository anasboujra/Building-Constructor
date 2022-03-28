package com.BC.controllers.dg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.RHDao;
import com.BC.services.FormDG;

//done 

@WebServlet("/dg-update-rh")
public class UpdateRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateRH() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		RHDao rhDao = new RHDao() ;
		request.setAttribute("rh", rhDao.findByColumn("id", Long.parseLong(id))) ;
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/DG/modifierRH.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormDG form = new FormDG() ;
		form.modifierAdmin(request);
		request.setAttribute("message", "Enregistrement avec succès");
		doGet(request, response);
	}

}
