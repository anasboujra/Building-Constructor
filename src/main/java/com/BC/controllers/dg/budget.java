package com.BC.controllers.dg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.beans.Credit;
import com.BC.services.FormCredit;

//done

@WebServlet("/dg-budget")
public class budget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public budget() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/DG/budget.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormCredit form = new FormCredit();
		Credit credit = form.creerCredit(request);
		request.setAttribute("credit", credit);
		request.setAttribute("message", "Credit a été ajouté");
		doGet(request, response);
	}

}
