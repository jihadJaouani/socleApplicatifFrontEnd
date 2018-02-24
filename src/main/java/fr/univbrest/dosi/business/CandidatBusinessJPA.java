package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

@Service
public class CandidatBusinessJPA implements CandidatBusiness{

	private CandidatRepository candidatRepository;
	
	
	@Autowired
	public CandidatBusinessJPA(CandidatRepository candidatRepository) {
		super();
		this.candidatRepository = candidatRepository;
	}



	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		return candidatRepository.save(candidatACreer);
	}



	@Override
	public void supprimerCandidat(Candidat candidatASupprimer) {
		 candidatRepository.delete(candidatASupprimer);
	}



	@Override
	public List<Candidat> chercherCandidatParNom(String nom) {
		
		return candidatRepository.findByNom(nom);
	}



	@Override
	public List<Candidat> chercherCandidatParUniversite(String universiteOrigine) {
	
		return candidatRepository.findByUniversiteOrigine(universiteOrigine);
	}



	@Override
	public  List<Candidat> recupererToutLesCandidats() {
		// TODO Auto-generated method stub
		candidatRepository.findAll();
		return (List<Candidat>) candidatRepository.findAll();
	}



	@Override
	public Candidat recupererCandidatParId(String id) {
		return candidatRepository.findOne(id);
	}



	@Override
	public List<Candidat> recupererCandidatsParNom(String nom) {
		return candidatRepository.findByNom(nom);
	}
	
	

}
