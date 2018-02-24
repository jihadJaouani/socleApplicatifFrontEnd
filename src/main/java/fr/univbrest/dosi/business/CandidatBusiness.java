package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatBusiness {

	Candidat creerCandidat(Candidat candidat);
	void supprimerCandidat(Candidat candidat);
	List<Candidat> chercherCandidatParNom(String nom);
	List<Candidat> chercherCandidatParUniversite(String universite);
	List<Candidat> recupererToutLesCandidats();
	Candidat recupererCandidatParId(String id);
	List<Candidat> recupererCandidatsParNom(String nom);
	
}
