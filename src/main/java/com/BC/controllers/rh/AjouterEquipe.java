package com.BC.controllers.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.CEDao;
import com.BC.dao.EmployeDao;
import com.BC.services.FormEquipe;

@WebServlet("/rh-creer-equipe")
public class AjouterEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeDao employe=new EmployeDao();
		request.setAttribute("employes", employe.findAllFreeEmployes());

		CEDao ceDao=new CEDao();
		request.setAttribute("chefs", ceDao.findAllFreeCE());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/RH/ajouterGroupe.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FormEquipe form = new FormEquipe() ;
		form.creerEquipe(request);
		request.setAttribute("message", "Enregistrement avec succès");
		doGet(request, response);
		
	}

}
