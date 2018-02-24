package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Service
public class EnseignantBusinessJPA implements EnseignantBusiness {

	private EnseignantRepository enseignantRepository;
	
	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository enseignantRepository) {
		super();
		this.enseignantRepository = enseignantRepository;
	}

	@Override
	public Enseignant creerEnseignant(Enseignant enseignant) {
		return enseignantRepository.save(enseignant);
	}

	@Override
	public void supprimerEnseignant(Enseignant enseignant) {
		enseignantRepository.delete(enseignant);
		
	}

	@Override
	public Enseignant recupererEnseignantParId(long i) {
		return enseignantRepository.findOne(i);
	}

	@Override
	public List<Enseignant> recupererTousLesEnseignant() {
		return (List<Enseignant>) enseignantRepository.findAll();
	}

	@Override
	public List<Enseignant> recupererEnseignantParNom(String nom) {
		return enseignantRepository.findByNom(nom);
	}

	@Override
	public Enseignant recupererEnseignantParEmailUbo(String email) {
		return enseignantRepository.findByEmailUbo(email);
	}


	

}
