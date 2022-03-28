package com.BC.controllers.dg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.beans.RF;
import com.BC.dao.RFDao;

//done 

@WebServlet("/dg-liste-rf")
public class RFinancieres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RFinancieres() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RFDao ceDao = new RFDao() ;
		ArrayList<RF> rf =  (ArrayList<RF>) ceDao.findAll() ;
		request.setAttribute("RFs", rf);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/DG/R.Financieres.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
