package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

public class CandidatBusinessJPATest {

	@Autowired
	CandidatBusinessJPA candidatBusinessJPA;
	
	
	@Test
	public void doitCreerCandidat() {
		CandidatRepository candidatRepository=new CandidatRepositoryList();
		candidatBusinessJPA=new CandidatBusinessJPA(candidatRepository);
		Candidat candidat2=new Candidat("e21709460", "brest", "29200", "candidat2@gmail.com", "PAYS2", "Nom2", "Prenom2", "H", "UNIV2", "Ville2");
		
		Candidat resultat = candidatBusinessJPA.creerCandidat(candidat2);
		assertThat(candidatRepository.count()).isEqualTo(1);
	}
	
	
	@Test
	public void doitSupprimerCandidat() {
		Candidat candidat=new Candidat("e21709470", "brest", "29200", "jouhaida@gmail.com", "Marocaine", "Jaouani", "Jihad", "F", "UMP", "Oujda");
		List<Candidat> ListCandidat=Lists.newArrayList();
		ListCandidat.add(candidat);
		CandidatRepository candidatRepository=new CandidatRepositoryList(ListCandidat);
		candidatBusinessJPA=new CandidatBusinessJPA(candidatRepository);
		candidatBusinessJPA.supprimerCandidat(candidat);
		assertThat(candidatRepository.count()).isEqualTo(0);
		
	}
	
	@Test
	public void doitRechercheCandidatParNom() {
		List<Candidat> ListCandidat=Lists.newArrayList();
	
		Candidat candidat=new Candidat("e21709470", "brest", "29200", "jouhaida@gmail.com", "Marocaine", "Jaouani", "Jihad", "F", "UMP", "Oujda");
		ListCandidat.add(candidat);
		Candidat candidat2=new Candidat("e21709460", "brest", "29200", "candidat2@gmail.com", "PAYS2", "Nom2", "Prenom2", "H", "UNIV2", "Ville2");
		ListCandidat.add(candidat2);
		CandidatRepository candidatRepository=new CandidatRepositoryList(ListCandidat);
		candidatBusinessJPA=new CandidatBusinessJPA(candidatRepository);
		List<Candidat> resultat = candidatBusinessJPA.chercherCandidatParNom("Jaouani");
		
		assertThat(resultat.get(0).getNom()).isEqualTo("Jaouani");
		assertThat(resultat).hasSize(1);
		assertThat(resultat).containsExactly(candidat);	
	}
	
	@Test
	public void doitRechercheCandidatParUniversiteOrigine() {
		List<Candidat> ListCandidat=Lists.newArrayList();
	
		Candidat candidat=new Candidat("e21709470", "brest", "29200", "jouhaida@gmail.com", "Marocaine", "Jaouani", "Jihad", "F", "UMP", "Oujda");
		ListCandidat.add(candidat);
		Candidat candidat2=new Candidat("e21709460", "brest", "29200", "candidat2@gmail.com", "PAYS2", "Nom2", "Prenom2", "H", "UNIV2", "Ville2");
		ListCandidat.add(candidat2);
		CandidatRepository candidatRepository=new CandidatRepositoryList(ListCandidat);
		candidatBusinessJPA=new CandidatBusinessJPA(candidatRepository);
		List<Candidat> resultat = candidatBusinessJPA.chercherCandidatParUniversite("UMP");
		assertThat(resultat).hasSize(1);
		assertThat(resultat).containsExactly(candidat);	
	}
	
}
class CandidatRepositoryList implements  CandidatRepository{
	private List<Candidat>ListCandidat;
	
	
	public CandidatRepositoryList() {
		super();
		ListCandidat =Lists.newArrayList();
	}
	public CandidatRepositoryList(List<Candidat>ListCandidatDonnee) {
		super();
		ListCandidat=ListCandidatDonnee;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return ListCandidat.size();
	}

	@Override
	public void delete(String arg0) {
		
		
		
	}

	@Override
	public void delete(Candidat entity) {
		 ListCandidat.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Candidat> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Candidat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Candidat> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidat findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Candidat> S save(S entity) {
		// TODO Auto-generated method stub
		ListCandidat.add(entity);
		return entity;
		
	}

	@Override
	public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidat> findByNom(String Nom) {
		List<Candidat> list=Lists.newArrayList();
		
		for(int i=0;i<ListCandidat.size();i++) {
			if(ListCandidat.get(i).getNom().equals(Nom)) {
				list.add(ListCandidat.get(i));
			}
		}
		return list;
	}

	@Override
	public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {

		return ListCandidat.stream().filter(candidat -> candidat.getUniversiteOrigine().equals(universiteOrigine)).collect(Collectors.toList());
	}}
