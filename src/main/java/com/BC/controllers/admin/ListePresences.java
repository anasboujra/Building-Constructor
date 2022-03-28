package com.BC.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.beans.Absence;
import com.BC.beans.Equipe;
import com.BC.dao.AbsenceDao;
import com.BC.dao.EquipeDao;


@WebServlet("/admin-presences")
public class ListePresences extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListePresences() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbsenceDao absencedao=new AbsenceDao();
		EquipeDao equipedao=new EquipeDao();
		List<Absence> absences=absencedao.findAll();
		List<Equipe> equipes=equipedao.findAll();
		request.setAttribute("equipes", equipes);
		request.setAttribute("absences",absences);
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listePresence.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
