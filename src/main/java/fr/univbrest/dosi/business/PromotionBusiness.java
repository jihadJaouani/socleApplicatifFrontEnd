package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

public interface PromotionBusiness {
	
	 Promotion creerPromotion(Promotion promotionACreer);
	 void supprimerPromotion(Promotion promotionASupprimer);
	 List<Promotion> recupererToutesLesPromotions();
	 Promotion chercherPromotionParId(PromotionPK id);
	 Promotion chercherPromotionParSiglePromotion(String siglePromotion);
	 List<Promotion> chercherPromotionParNbMaxEtudiant(BigDecimal nbrMax);
	 
}
