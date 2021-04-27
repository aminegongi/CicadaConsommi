package tn.esprit.spring.repository;

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
	public int rechercheUser(String tag , Long u);
	
	
	@Modifying
	@Transactional
	@Query("Update SujetRecherche sr set sr.nombre = sr.nombre+1 where sr.id = ?1 ") 
	public void addOne(int id);
}  