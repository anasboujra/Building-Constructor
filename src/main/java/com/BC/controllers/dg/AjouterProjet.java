package com.BC.controllers.dg;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.EquipeDao;
import com.BC.dao.MatierePremiereDao;
import com.BC.services.FormProjet;

//done

@WebServlet("/dg-ajouter-projet")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 10,  // 10 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15 // 15 MB
)
public class AjouterProjet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String VUE_AJOUTER = "/WEB-INF/view/admin/DG/ajouter-projet.jsp";
	private static final String VUE_LISTE = "admin-projets";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EquipeDao equipeDao=new EquipeDao();
		request.setAttribute("equipes", equipeDao.findAll());
		
		MatierePremiereDao mpDao = new MatierePremiereDao();
		request.setAttribute("mps", mpDao.findAll());
		
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER).forward(request, response) ;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormProjet form = new FormProjet();
		try {
			form.creerProjet(request);
		} catch (IOException | ServletException | ParseException e) {
			e.printStackTrace() ;
		}


		request.setAttribute("message", "Enregistrement avec succès");
		request.getRequestDispatcher(VUE_LISTE).forward(request, response);
	}

}
