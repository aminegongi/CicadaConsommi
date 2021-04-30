package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.SujetRecherche;
import tn.esprit.spring.entity.User;

//repository that extends CrudRepository  
public interface SujetRechercheRepository extends CrudRepository<SujetRecherche, Integer>  
{  
	@Query("Select sr.id from SujetRecherche sr where upper(sr.tag) = ?1 AND sr.rechercheSujetUser.id = ?2  ")
	public Integer rechercheUser(String tag , Long u);
	
	
	@Modifying
	@Transactional
	@Query("Update SujetRecherche sr set sr.nombre = sr.nombre+1 where sr.id = ?1 ") 
	public void addOne(int id);
	
	@Query(value="SELECT sujet_recherche.tag FROM `sujet_recherche` where sujet_recherche.recherche_sujet_user_id=?1 Order by sujet_recherche.nombre DESC",nativeQuery= true)
	public List<String> listSrparUser(int id);
	
	
}  