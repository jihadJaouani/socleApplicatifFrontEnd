package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fr.univbrest.dosi.bean.Candidat;

public interface CandidatRepository extends CrudRepository<Candidat, String> {
	List<Candidat> findByNom(String Nom);
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);
	
	
}
