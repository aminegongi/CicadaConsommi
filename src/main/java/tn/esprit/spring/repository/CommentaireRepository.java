package tn.esprit.spring.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Commentaire;


//repository that extends CrudRepository  
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer>  
{ 
	@Query(value=" select commentaire.id_comm , commentaire.description , commentaire.date_commentaire , commentaire.comm_sujet_id_sujet , commentaire.comm_user_id , count(react.react_comm_id_comm) as nbr from commentaire LEFT JOIN react on commentaire.id_comm = react.react_comm_id_comm GROUP by commentaire.id_comm Order by nbr DESC ",nativeQuery=true )
    public List<Map< Commentaire , BigInteger >> getComByPert(); // pertinence le nombre de react sur le commentaire 
}  