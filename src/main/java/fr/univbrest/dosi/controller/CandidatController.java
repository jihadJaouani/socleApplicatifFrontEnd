package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@EnableAutoConfiguration
@RequestMapping("/candidats")
public class CandidatController {

	private CandidatBusiness candidatBusiness;

	@Autowired
	public CandidatController(CandidatBusiness candidatBusiness) {
		super();
		this.candidatBusiness = candidatBusiness;
	}
	@RequestMapping(method = RequestMethod.POST)
	public Candidat creerCandidat(@RequestBody Candidat CandidatACreer) {
		return candidatBusiness.creerCandidat(CandidatACreer);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> rechercherTousLesCandidats(){
		return candidatBusiness.recupererToutLesCandidats();	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Candidat rechercherCandidatParId(@PathVariable String id) {
		return candidatBusiness.recupererCandidatParId(id);	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> rechercherCandidatParNom(@PathVariable String nom){
		return candidatBusiness.recupererCandidatsParNom(nom);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/id/{id}")
	public String supprimerEnseignantParId(@PathVariable String id) {
		Candidat candidatASupprimer=candidatBusiness.recupererCandidatParId(id);
		candidatBusiness.supprimerCandidat(candidatASupprimer);
		return "Candidat d'id '"+id+"' à été supprimer";
	}
	
	
}
