package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {
	
	Enseignant creerEnseignant(Enseignant enseignant);
	void supprimerEnseignant(Enseignant enseignant);
	Enseignant recupererEnseignantParId(long id);
	List<Enseignant> recupererTousLesEnseignant();
	List<Enseignant> recupererEnseignantParNom(String nom);
	Enseignant recupererEnseignantParEmailUbo(String email);
	
}
