package tn.esprit.spring.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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
	    @Query(value="Delete from sujet "
	    		+"where DATEDIFF(CURRENT_TIMESTAMP,sujet.date_publication)>=7 "
	    		+"and sujet.id_sujet not in (select distinct commentaire.comm_sujet_id_sujet from commentaire) "
	    		+"and sujet.id_sujet not in (select distinct rating.rating_sujet_id_sujet from rating)",nativeQuery=true)
	    public void deleteSujetWithNoInteraction();
		
		
		/* pour la pertinance
		select sujet.id_sujet , sujet.titre , count(commentaire.comm_sujet_id_sujet) as cc from sujet 
		LEFT JOIN commentaire on sujet.id_sujet = commentaire.comm_sujet_id_sujet 
		group by sujet.id_sujet
		ORDER by cc DESC 
		*/
		
	    @Query(value=" select sujet.id_sujet , sujet.titre , sujet.date_publication , sujet.description , sujet.sujet_user_id_user , count(commentaire.comm_sujet_id_sujet) as cc from sujet LEFT JOIN commentaire on sujet.id_sujet = commentaire.comm_sujet_id_sujet group by sujet.id_sujet ORDER by cc DESC ",nativeQuery=true )
	    public List<Map< Sujet , BigInteger >> getNbComSujets();  // pertinence le nombre de commentaire sur le sujet
	    
	    @Query(value=" select sujet.id_sujet , sujet.titre , sujet.date_publication , sujet.description , sujet.sujet_user_id_user , COALESCE(sum(rating.nombre),0) as sun from sujet LEFT JOIN rating on sujet.id_sujet = rating.rating_sujet_id_sujet group by sujet.id_sujet ORDER by sun DESC ",nativeQuery=true )
	    public List<Map< Sujet , BigInteger >> getSumRatSujets();  // pertinence max rating sur le sujet 
}  