package com.BC.controllers.rf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.DemandeAchatDao;


@WebServlet("/rf-demandes-achats")
public class DemandeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DemandeClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DemandeAchatDao demandeDao=new DemandeAchatDao();
		request.setAttribute("demandes", demandeDao.findAllByColumn("etat", "En traitement") );
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/RF/demandeClient.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
