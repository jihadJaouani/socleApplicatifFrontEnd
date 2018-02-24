package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;
@Service
public class PromotionBusinessJPA implements PromotionBusiness {

	private PromotionRepository promotionRepository;
	
	
	@Autowired
	public PromotionBusinessJPA(PromotionRepository promotionRepository) {
		super();
		this.promotionRepository = promotionRepository;
	}

	@Override
	public Promotion creerPromotion(Promotion promotionACreer) {
		return promotionRepository.save(promotionACreer);
	}

	@Override
	public void supprimerPromotion(Promotion promotionASupprimer) {
		promotionRepository.delete(promotionASupprimer);

	}

	@Override
	public List<Promotion> recupererToutesLesPromotions() {
		return (List<Promotion>)promotionRepository.findAll();
	}

	@Override
	public Promotion chercherPromotionParId(PromotionPK id) {
		return promotionRepository.findOne(id);
	}

	@Override
	public Promotion chercherPromotionParSiglePromotion(String siglePromotion) {
		// TODO Auto-generated method stub
		return promotionRepository.findBySiglePromotion(siglePromotion);
	}

	@Override
	public List<Promotion> chercherPromotionParNbMaxEtudiant(BigDecimal nbMax) {
		// TODO Auto-generated method stub
		return promotionRepository.findByNbMaxEtudiant(nbMax);
	}

}
