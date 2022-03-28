package com.BC.services;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

import com.BC.beans.MatierePremiere;
import com.BC.dao.MatierePremiereDao;

public class FormMatierePremiere {
	private final static String CHAMP_NOM="nom";
	private final static String CHAMP_PRIX="prix";
	private final static String CHAMP_QUANTITE="quantite";
	
	private MatierePremiereDao matierePremiereDao =new MatierePremiereDao();
	   
	private LocalDate currentDate=LocalDate.now();
	Integer mois = currentDate.getMonthValue();
    Integer annee=currentDate.getYear();
	
    FormTransaction form=new FormTransaction();
    
    public MatierePremiereDao insererAuStock(HttpServletRequest request) {
		String nom=request.getParameter(CHAMP_NOM) ;
		Double prix = Double.parseDouble(request.getParameter(CHAMP_PRIX) );
		Double quantite = Double.parseDouble(request.getParameter(CHAMP_QUANTITE)) ;
		
		
		
		MatierePremiere mp=new MatierePremiere();
		mp.setNom(nom);
		mp.setPrix(prix);
		mp.setQuantiteStockee(quantite);		
		form.ajouterTransaction(mois,annee, -prix, "MatierePr");
		
		matierePremiereDao.add(mp);
		return matierePremiereDao;
	}

	public MatierePremiereDao updateStock(HttpServletRequest request) {
		String id = request.getParameter(CHAMP_NOM);
		Double prix = Double.parseDouble(request.getParameter(CHAMP_PRIX) );
		Double quantite = Double.parseDouble(request.getParameter(CHAMP_QUANTITE)) ;
		
		MatierePremiere mp=new MatierePremiere();
		mp=matierePremiereDao.findByColumn("id",Long.parseLong(id));
		mp.setQuantiteStockee(quantite + mp.getQuantiteStockee());
		mp.setPrix(prix + mp.getPrix());
		
		form.ajouterTransaction(mois,annee, -prix, "MatierePr");
		matierePremiereDao.update(mp);
		return matierePremiereDao;
	}
	

}
