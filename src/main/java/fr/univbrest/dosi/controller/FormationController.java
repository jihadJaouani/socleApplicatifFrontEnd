package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController
@EnableAutoConfiguration
@RequestMapping("/formations")
public class FormationController {
	
	private FormationBusiness business;

	@Autowired
	public FormationController(FormationBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Formation creerFormation(@RequestBody Formation formationACreer) {
		return business.creerFormation(formationACreer);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> recupererToutesLesFormations() {
		return business.recupererToutesLesFormations();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Formation> recupererLaFormationAvecLeNom(@PathVariable String nom) {
		return business.rechercherFormationParNom(nom);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Formation recupererLaFormationAvecLId(@PathVariable String id) {
		return business.rechercherFormationParId(id);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void supprimerPromotionParId(@PathVariable String id) {
		Formation formationASupprimer=business.rechercherFormationParId(id);
		business.supprimerPromotion(formationASupprimer);
	}
	

}
