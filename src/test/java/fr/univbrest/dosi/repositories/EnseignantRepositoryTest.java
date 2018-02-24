package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Enseignant;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class EnseignantRepositoryTest {

	@Autowired
	EnseignantRepository enseignantRepository;
	
	@Before
	public void setup() {
		Enseignant enseignant1=new Enseignant(1, "enseignant1@gmail.com", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		Enseignant enseignant2=new Enseignant(2, "enseignant2@gmail.com", "Nom2", "Prenom2", "F","0 6 66 66 66 66", "Ville2");
		enseignantRepository.save(enseignant1);
		enseignantRepository.save(enseignant2);
	}
	@Test
	public void doitRechercheParNom() {
		List<Enseignant> resultat=enseignantRepository.findByNom("Nom1");
		assertThat(enseignantRepository.count()).isEqualTo(2);
		assertThat(resultat.size()).isEqualTo(1);
	}
	
}
