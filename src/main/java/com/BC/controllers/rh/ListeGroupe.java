package com.BC.controllers.rh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.EquipeDao;


@WebServlet("/rh-equipes")
public class ListeGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListeGroupe() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EquipeDao equipeDao=new EquipeDao();
		request.setAttribute("equipes", equipeDao.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/RH/listeGroupe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
