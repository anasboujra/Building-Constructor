package com.BC.controllers.dg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.BC.beans.RH;
import com.BC.dao.RHDao;

//done 

@WebServlet("/dg-liste-rh")
public class RHumains extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RHumains() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RHDao rhDao = new RHDao() ;
		ArrayList<RH> rh =  (ArrayList<RH>) rhDao.findAll();
		request.setAttribute("RHs", rh);
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/DG/R.Humains.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
