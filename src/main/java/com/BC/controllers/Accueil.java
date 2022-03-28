package com.BC.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import com.BC.beans.Projet;
import com.BC.services.FormProjet;

//done
@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VUE_ACCUEIL = "/WEB-INF/view/index.jsp";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormProjet form = new FormProjet();
		List<Projet> projets = form.showProjets();
		List<String> images = new ArrayList<String>();
		
		for(Projet projet : projets) {
			images.add("data:image/png;base64," + Base64.encodeBase64String(projet.getImage()));
		}
		
		request.setAttribute("projets", projets);
		request.setAttribute("images", images);
		
		this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
