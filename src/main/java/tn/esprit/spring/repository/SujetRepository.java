package tn.esprit.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Sujet;  

//repository that extends CrudRepository  
public interface SujetRepository extends CrudRepository<Sujet, Integer>  
{  
	
	// Si sujet age > 7j et 0 rating et 0 commentaire delete
		@Modifying
		@Transactional
	    @Query(value="Delete from sujet where DATEDIFF(CURRENT_TIMESTAMP,sujet.date_publication)>=7 and sujet.id_sujet not in (select distinct commentaire.comm_sujet_id_sujet from commentaire) and sujet.id_sujet not in (select distinct rating.rating_sujet_id_sujet from rating)",nativeQuery=true)
	    public void deleteSujetWithNoInteraction();
		
		
}  