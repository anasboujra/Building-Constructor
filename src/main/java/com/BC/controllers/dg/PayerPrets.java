package com.BC.controllers.dg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.services.FormCredit;

//done 

@WebServlet("/dg-payer-prets")
public class PayerPrets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PayerPrets() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormCredit form = new FormCredit();
		request.setAttribute("message", form.payerCredit(request));
		request.getRequestDispatcher("dg-dashboard").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
