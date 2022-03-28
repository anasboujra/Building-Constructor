package com.BC.controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter("/*")
public class FilterUtilisateur implements Filter {


	private static final String ATT_SESSION_USER = "sessionUser";
	private static final String ATT_USER_TYPE = "userType";
	
	private static final String VUE_ACCUEIL = "accueil";

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session =  request.getSession();
		String url = request.getRequestURI();
		
		if(!isClient(session) && url.startsWith("/BC/client")){
			
			request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
			
		} else if(!isDG(session) && (url.startsWith("/BC/dg"))) {
			
			request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
			
		} else if(!isRF(session) && (url.startsWith("/BC/rf"))) {
			
			request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
		
		} else if(!isRH(session) && (url.startsWith("/BC/rh"))) {
			
			request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
		
		} else if(!isCE(session) && (url.startsWith("/BC/ce"))) {
			
			request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
		
		} else if(!isAdmin(session) && (url.startsWith("/BC/admin"))) {
			
			request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
		
			
		} else {
			chain.doFilter(request, response);
		}
	}
	
	
	public boolean isClient(HttpSession session) {
		boolean is = (session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("client"));
		return is;
	}

	public boolean isDG(HttpSession session) {
		boolean is = (session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("dg"));
		return is;
	}

	public boolean isRF(HttpSession session) {
		boolean is = (session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("rf"));
		return is;
	}

	public boolean isRH(HttpSession session) {
		boolean is = (session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("rh"));
		return is;
	}

	public boolean isCE(HttpSession session) {
		boolean is = (session.getAttribute(ATT_SESSION_USER) != null && session.getAttribute(ATT_USER_TYPE).equals("ce"));
		return is;
	}

	public boolean isAdmin(HttpSession session) {
		boolean is = (isDG(session) || isRF(session) || isRH(session) || isCE(session));
		return is;
	}
}
