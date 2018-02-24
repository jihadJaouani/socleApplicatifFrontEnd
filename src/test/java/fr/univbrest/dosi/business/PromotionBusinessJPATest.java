package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {
	PromotionBusinessJPA promotionBusiness;
	
	
	@Test
	public void doitCreerPromotion() {
		PromotionRepository repository=new PromotionRepositoryList();
		promotionBusiness=new PromotionBusinessJPA(repository);
		Promotion promotion1=new Promotion(new PromotionPK("2013-2014", "M2I13"), new Date(),"reunion1.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "M2I");
		Promotion resultat = promotionBusiness.creerPromotion(promotion1);
		assertThat(repository.count()).isEqualTo(1);
	}
	
	@Test
	public void doitSupprimerPromotion() {
		Promotion promotion1=new Promotion(new PromotionPK("2013-2014", "M2I13"), new Date(),"reunion1.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "M2I");
		Promotion promotion2=new Promotion(new PromotionPK("2013-2014", "DOSI13"), new Date(),"reunion2.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "DOSI");
		
		PromotionRepository repository=new PromotionRepositoryList(promotion1,promotion2);
		promotionBusiness=new PromotionBusinessJPA(repository);
		assertThat(repository.count()).isEqualTo(2);
		promotionBusiness.supprimerPromotion(promotion2);
		assertThat(repository.count()).isEqualTo(1);
	}
	
	@Test
	public void doitRetournerToutesLesPromotions() {
		Promotion promotion1=new Promotion(new PromotionPK("2013-2014", "M2I13"), new Date(),"reunion1.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "M2I");
		Promotion promotion2=new Promotion(new PromotionPK("2013-2014", "DOSI13"), new Date(),"reunion2.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "DOSI");
		
		PromotionRepository repository=new PromotionRepositoryList(promotion1,promotion2);
		promotionBusiness=new PromotionBusinessJPA(repository);
		assertThat(repository.count()).isEqualTo(2);
		List<Promotion> resultat = promotionBusiness.recupererToutesLesPromotions();
		assertThat(resultat.size()).isEqualTo(2);
	}
	
	@Test
	public void doitRetournerPromotionParId() {
		Promotion promotion1=new Promotion(new PromotionPK("2013-2014", "M2I13"), new Date(),"reunion1.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "M2I");
		Promotion promotion2=new Promotion(new PromotionPK("2013-2014", "DOSI13"), new Date(),"reunion2.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "DOSI");
		
		PromotionRepository repository=new PromotionRepositoryList(promotion1,promotion2);
		promotionBusiness=new PromotionBusinessJPA(repository);
		assertThat(repository.count()).isEqualTo(2);
		Promotion resultat=promotionBusiness.chercherPromotionParId(new PromotionPK("2013-2014", "M2I13"));
		assertThat(resultat.getSiglePromotion()).isEqualTo("M2I");
	}
	
	@Test 
	public void doitRetournerPromotionParSigle() {
		Promotion promotion1=new Promotion(new PromotionPK("2013-2014", "M2I13"), new Date(),"reunion1.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "M2I");
		Promotion promotion2=new Promotion(new PromotionPK("2013-2014", "DOSI13"), new Date(),"reunion2.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "DOSI");
		
		PromotionRepository repository=new PromotionRepositoryList(promotion1,promotion2);
		promotionBusiness=new PromotionBusinessJPA(repository);
		assertThat(repository.count()).isEqualTo(2);
		Promotion resultat = promotionBusiness.chercherPromotionParSiglePromotion("M2I");
		assertThat(resultat.getLieuRentree()).isEqualTo("reunion1.1");
		
	}
	
	@Test 
	public void doitRetournerPromotionParNbMaxEtudiant() {
		Promotion promotion1=new Promotion(new PromotionPK("2013-2014", "M2I13"), new Date(),"reunion1.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "M2I");
		Promotion promotion2=new Promotion(new PromotionPK("2013-2014", "DOSI13"), new Date(),"reunion2.1",BigDecimal.valueOf(24), BigDecimal.valueOf(1), "DOSI");
		
		PromotionRepository repository=new PromotionRepositoryList(promotion1,promotion2);
		promotionBusiness=new PromotionBusinessJPA(repository);
		assertThat(repository.count()).isEqualTo(2);
		List<Promotion> resultat = promotionBusiness.chercherPromotionParNbMaxEtudiant(BigDecimal.valueOf(24));
		assertThat(resultat.size()).isEqualTo(2);
		
	}
	
}
class PromotionRepositoryList implements PromotionRepository{

	private List<Promotion> listPromotion;
	
	
	public PromotionRepositoryList() {
		listPromotion = Lists.newArrayList();
	}
	public PromotionRepositoryList(Promotion...promotions) {
		listPromotion = Lists.newArrayList(promotions);
	}

	@Override
	public <S extends Promotion> S save(S entity) {
		listPromotion.add(entity);
		return entity;
	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK id) {
		for(int i=0;i<listPromotion.size();i++) {
			if(listPromotion.get(i).getId().equals(id))
				return listPromotion.get(i);
		}
		return null;
	}

	@Override
	public boolean exists(PromotionPK id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() {
		// TODO Auto-generated method stub
		return listPromotion;
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return listPromotion.size();
	}

	@Override
	public void delete(PromotionPK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion entity) {
		listPromotion.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Promotion> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Promotion findBySiglePromotion(String SiglePromotion) {
		return listPromotion.stream().filter(enseignant -> enseignant.getSiglePromotion().equals(SiglePromotion)).
				collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Promotion> findByNbMaxEtudiant(BigDecimal nbMaxEtudiant) {
		return listPromotion.stream().filter(enseignant -> enseignant.getNbMaxEtudiant().equals(nbMaxEtudiant)).
				collect(Collectors.toList());
	
	}
	
}
