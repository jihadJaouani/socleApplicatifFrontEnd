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
import fr.univbrest.dosi.bean.Candidat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {

	@Autowired
	CandidatRepository candidatRepository;
	
	@Before
	public void setup(){
		Candidat candidat1=new Candidat("e21709470", "Brest", "29200" , "jouhaida@gmail.com", "Marocaine", "JAOUANI","Jihad", "F",  "UMP", "Oujda");
		Candidat candidat2=new Candidat("e21705070", "Brest", "29200" , "candidat2@gmail.com", "Marocaine", "NOM2","Prenom2", "M",  "UIZ", "Agadir");
		
		candidatRepository.save(candidat1);
		//candidatRepository.save(candidat2);
		
	}
	
	@Test
	public void doitRechercherParNom() {
		List<Candidat> resultat=candidatRepository.findByNom("JAOUANI");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("JAOUANI");
	}
	
	@Test
	public void doitRechercherParUniversiteOrigine() {
		List<Candidat> resultat=candidatRepository.findByUniversiteOrigine("UMP");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("UMP");
		assertThat(resultat.get(0).getVille()).isEqualTo("Oujda");
	}
	
}
