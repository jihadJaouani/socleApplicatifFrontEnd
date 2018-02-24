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

import com.google.common.net.MediaType;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusinessJPA;

@RestController
@EnableAutoConfiguration
@RequestMapping("/enseignants")
public class EnseignantController {

	private EnseignantBusinessJPA business;

	@Autowired
	public EnseignantController(EnseignantBusinessJPA business) {
		super();
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return business.creerEnseignant(enseignantACreer);
	}
	
	@RequestMapping(method = RequestMethod.GET)

	public List<Enseignant> reccupererTousLesEnseignants(){
		return business.recupererTousLesEnseignant();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/email/{email:.+}")
	public Enseignant reccupererEnseignantParEmailEbo(@PathVariable String email) {
		return business.recupererEnseignantParEmailUbo(email);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> reccupererEnseignantParNom(@PathVariable String nom) {
		return business.recupererEnseignantParNom(nom);
	}
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Enseignant reccupererEnseignantParId(@PathVariable long id) {
		return business.recupererEnseignantParId(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void supprimerCandidatParId(@PathVariable long id) {
		Enseignant enseignantASupprimer=business.recupererEnseignantParId(id);
		business.supprimerEnseignant(enseignantASupprimer);
	}
}
