package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

public class EnseignantBusinessJPATest {
	
	EnseignantBusinessJPA enseignantBusiness;
	
	@Test
	public void doitCreerUnEnseignant() {
		EnseignantRepository enseignantRepository= new EnseignantRepositoryList();
		enseignantBusiness=new EnseignantBusinessJPA(enseignantRepository);
		
		Enseignant enseignant1=new Enseignant(1, "enseignant1@gmail.com", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		
		Enseignant resultat = enseignantBusiness.creerEnseignant(enseignant1);
		assertThat(enseignantRepository.count()).isEqualTo(1);
	}
	
	@Test
	public void doitSupprimerEnseignant() {
		Enseignant enseignant1=new Enseignant(1, "enseignant1@gmail.com", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		Enseignant enseignant2=new Enseignant(2, "enseignant2@gmail.com", "Nom2", "Prenom2", "H","0 6 66 66 66 66", "Ville2");
		
		EnseignantRepository enseignantRepository= new EnseignantRepositoryList(enseignant1,enseignant2);
		enseignantBusiness=new EnseignantBusinessJPA(enseignantRepository);
		enseignantBusiness.supprimerEnseignant(enseignant1);
		assertThat(enseignantRepository.count()).isEqualTo(1);
	}
	
	@Test
	public void doitRecupererTousLesEnseignant() {
		Enseignant enseignant1=new Enseignant(1, "enseignant1@gmail.com", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		Enseignant enseignant2=new Enseignant(2, "enseignant2@gmail.com", "Nom2", "Prenom2", "H","0 6 66 66 66 66", "Ville2");
		
		EnseignantRepository enseignantRepository= new EnseignantRepositoryList(enseignant1,enseignant2);
		enseignantBusiness=new EnseignantBusinessJPA(enseignantRepository);
		List<Enseignant> resultat = enseignantBusiness.recupererTousLesEnseignant();
		assertThat(resultat.size()).isEqualTo(2);
	}
	
	@Test
	public void doitRecupererEnseignantParId() {
		Enseignant enseignant1=new Enseignant(1, "enseignant1@gmail.com", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		Enseignant enseignant2=new Enseignant(2, "enseignant2@gmail.com", "Nom2", "Prenom2", "H","0 6 66 66 66 66", "Ville2");
		
		EnseignantRepository enseignantRepository= new EnseignantRepositoryList(enseignant1,enseignant2);
		enseignantBusiness=new EnseignantBusinessJPA(enseignantRepository);
		Enseignant resultat = enseignantBusiness.recupererEnseignantParId(2);
		assertThat(resultat.getNom()).isEqualTo("Nom2");
		
	}
	
	@Test
	public void doitRecupererEnseignantParNom() {
		Enseignant enseignant1=new Enseignant(1, "enseignant1@gmail.com", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		Enseignant enseignant2=new Enseignant(2, "enseignant2@gmail.com", "Nom2", "Prenom2", "H","0 6 66 66 66 66", "Ville2");
		
		EnseignantRepository enseignantRepository= new EnseignantRepositoryList(enseignant1,enseignant2);
		enseignantBusiness=new EnseignantBusinessJPA(enseignantRepository);
		List<Enseignant> resultat=enseignantBusiness.recupererEnseignantParNom("Nom2");
		assertThat(resultat).contains(enseignant2);
		
	}
	
	@Test
	public void doitRecupererEnseignantParEmailUbo() {
		Enseignant enseignant1=new Enseignant(1, "enseignant1@ubo.fr", "Nom1", "Prenom1", "F","0 6 66 66 66 66", "Ville1");
		Enseignant enseignant2=new Enseignant(2, "enseignant2@ubo.fr", "Nom2", "Prenom2", "H","0 6 66 66 66 66", "Ville2");
		
		EnseignantRepository enseignantRepository= new EnseignantRepositoryList(enseignant1,enseignant2);
		enseignantBusiness=new EnseignantBusinessJPA(enseignantRepository);
		Enseignant resultat=enseignantBusiness.recupererEnseignantParEmailUbo("enseignant1@ubo.fr");
		assertThat(resultat.getNom()).isEqualTo("Nom1");
	}
	
	
	
}
class EnseignantRepositoryList implements EnseignantRepository{

	private List<Enseignant> listEnseignant;
	
	
	public EnseignantRepositoryList() {
		listEnseignant=Lists.newArrayList();
	}
	public EnseignantRepositoryList(Enseignant...enseignants) {
		listEnseignant=Lists.newArrayList(enseignants);
	}

	@Override
	public long count() {
		return listEnseignant.size();
	}



	@Override
	public void delete(Enseignant entity) {
		 listEnseignant.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Enseignant> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Iterable<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return listEnseignant;
	}



	@Override
	public <S extends Enseignant> S save(S entity) {
		listEnseignant.add(entity);
		return entity;
	}

	@Override
	public <S extends Enseignant> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> findByNom(String nom) {
		return listEnseignant.stream().filter(enseignant -> enseignant.getNom().equals(nom))
				.collect(Collectors.toList());
	}
	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterable<Enseignant> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Enseignant findOne(Long id) {
		
		for(int i=0;i<listEnseignant.size();i++) {
			if(listEnseignant.get(i).getNoEnseignant()==id)
				return listEnseignant.get(i);
		}
		return null;
	}
	@Override
	public Enseignant findByEmailUbo(String email) {
		return listEnseignant.stream().filter(enseignant ->enseignant.getEmailUbo().equalsIgnoreCase(email))
				.collect(Collectors.toList()).get(0);
	}
	
	
}
