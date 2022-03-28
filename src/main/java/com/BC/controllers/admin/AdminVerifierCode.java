package com.BC.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BC.services.FormAdmin;

//done
@WebServlet("/verifier-code-admin")
public class AdminVerifierCode extends HttpServlet {
private static final long serialVersionUID = 1L;

	private static final String ATT_FORM = "form";
	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_CODE = "code";
	private static final String ATT_EMAIL = "email";
	private static final String ATT_EMAIL_CODE = "emailCode";
	
	private static final String VUE_VERIFIER_CODE = "/WEB-INF/view/admin/verifier-code.jsp";
	private static final String VUE_ACCUEIL = "accueil";
	private static final String VUE_NEW_PASSWORD = "new-password-admin";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		if(session.getAttribute(ATT_SESSION_USER) == null && session.getAttribute(ATT_CODE)!=null) {
			this.getServletContext().getRequestDispatcher(VUE_VERIFIER_CODE).forward(request, response);
		}else {
			response.sendRedirect(VUE_ACCUEIL);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormAdmin form = new FormAdmin();
		String codeEcrit = form.verifierCode(request);
		
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute(ATT_CODE);
		
		if(form.getErreurs().isEmpty() && code.equals(codeEcrit)) {
			
			String email = (String) session.getAttribute(ATT_EMAIL);
			session.setAttribute(ATT_EMAIL_CODE, email);
			session.setAttribute(ATT_CODE, null);
			session.setAttribute(ATT_EMAIL, null);
			
			response.sendRedirect(VUE_NEW_PASSWORD);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			session.setAttribute(ATT_SESSION_USER, null);
			this.getServletContext().getRequestDispatcher(VUE_VERIFIER_CODE).forward(request, response);
		}

	}
}
