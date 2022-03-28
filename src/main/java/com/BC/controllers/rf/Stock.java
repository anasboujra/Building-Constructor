package com.BC.controllers.rf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.MatierePremiereDao;
import com.BC.services.FormMatierePremiere;

//done

@WebServlet("/rf-stock")
public class Stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Stock() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MatierePremiereDao mpDao = new MatierePremiereDao() ;
		request.setAttribute("mps", mpDao.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/RF/stock.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormMatierePremiere form=new FormMatierePremiere();
		form.insererAuStock(request);
		request.setAttribute("messageInsert", "Enregistrement avec succès");
		doGet(request, response);
	}

}
