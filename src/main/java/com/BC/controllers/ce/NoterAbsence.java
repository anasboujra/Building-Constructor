package com.BC.controllers.ce;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BC.dao.AbsenceDao;
import com.BC.services.FormEquipe;

//done

@WebServlet("/ce-noter-absence")
public class NoterAbsence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoterAbsence() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
		String Today = formatter.format(date);
		
		AbsenceDao absenceDao=new AbsenceDao(); 
		request.setAttribute("absences", absenceDao.findAllByColumn("date", Today));
		
		FormEquipe form=new FormEquipe();
		request.setAttribute("equipe", form.getMyTeam(request) );
		
		request.setAttribute("dateActuelle",Today);
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CE/absence.jsp").forward(request, response) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormEquipe form=new FormEquipe();
		form.noterAbsence(request);
		request.setAttribute("message", "Enregistrement avec succès");
		doGet(request, response);
	}

}
