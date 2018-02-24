package fr.univbrest.dosi.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusinessJPA;

@RestController
@EnableAutoConfiguration
@RequestMapping("/promotions")
public class PromotionController {
	
	private PromotionBusinessJPA business;

	@Autowired
	public PromotionController(PromotionBusinessJPA business) {
		super();
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> reccupererToutesLespromotions(){
		return business.recupererToutesLesPromotions();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/{anneeUniv}/{codeFormation}")
	public Promotion reccuperePromotionParId(@PathVariable String anneeUniv,@PathVariable String codeFormation) {
		return business.chercherPromotionParId(new PromotionPK(anneeUniv, codeFormation));
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/sigle/{sigle}")
	public Promotion reccuperPromotionParSigle(@PathVariable String sigle) {
		return business.chercherPromotionParSiglePromotion(sigle);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/nbMaxEtudiant/{nbMaxEtudiant}")
	public List<Promotion> reccuperPromotionParNbMAxEtudiant(@PathVariable BigDecimal nbMaxEtudiant) {
		return business.chercherPromotionParNbMaxEtudiant(nbMaxEtudiant);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion promotionACreer) {
		return business.creerPromotion(promotionACreer);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/id/{anneeUniv}/{codeFormation}")
	public String supprimerPromotionParId(@PathVariable String anneeUniv,
											@PathVariable String codeFormation) {
		Promotion promotionASupprimer=business.chercherPromotionParId(new PromotionPK(anneeUniv, codeFormation));
		business.supprimerPromotion(promotionASupprimer);
		return "Promotion à été supprimer";
	}
	

}
