package tn.esprit.spring.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;

public interface SujetRepository extends CrudRepository<Sujet, Integer> {

	// Si sujet age > 7j et 0 rating et 0 commentaire delete
	@Modifying
	@Transactional
	@Query(value = "Delete from sujet " + "where DATEDIFF(CURRENT_TIMESTAMP,sujet.date_publication)>=7 "
			+ "and sujet.id_sujet not in (select distinct commentaire.comm_sujet_id_sujet from commentaire) "
			+ "and sujet.id_sujet not in (select distinct rating.rating_sujet_id_sujet from rating)", nativeQuery = true)
	public void deleteSujetWithNoInteraction();

	/*
	 * pour la pertinance select sujet.id_sujet , sujet.titre ,
	 * count(commentaire.comm_sujet_id_sujet) as cc from sujet LEFT JOIN
	 * commentaire on sujet.id_sujet = commentaire.comm_sujet_id_sujet group by
	 * sujet.id_sujet ORDER by cc DESC
	 */

	// pertinence le nombre de commentaire sur le sujet
	@Query(value = " select sujet.id_sujet , sujet.titre , sujet.date_publication , sujet.description , "
			+ "sujet.sujet_user_id , count(commentaire.comm_sujet_id_sujet) as cc "
			+ "from sujet LEFT JOIN commentaire on sujet.id_sujet = commentaire.comm_sujet_id_sujet "
			+ "group by sujet.id_sujet " + "ORDER by cc DESC ", nativeQuery = true)
	public List<Map<Sujet, BigInteger>> getNbComSujets();

	// pertinence max rating sur le sujet
	@Query(value = " select sujet.id_sujet , sujet.titre , sujet.date_publication , sujet.description , sujet.sujet_user_id,"
			+ " COALESCE(sum(rating.nombre),0) as sun "
			+ "from sujet LEFT JOIN rating on sujet.id_sujet = rating.rating_sujet_id_sujet "
			+ "group by sujet.id_sujet " + "ORDER by sun DESC ", nativeQuery = true)
	public List<Map<Sujet, BigInteger>> getSumRatSujets();

	// recherche avec les champs titre et description
	@Query("Select s from Sujet s where upper(titre) Like upper(concat('%', ?1,'%')) or upper(description) Like upper(concat('%', ?1,'%')) ")
	public List<Sujet> rechercheSujet(String ez);

	// get sujet par user
	@Query("Select s from Sujet s where s.sujetUser = ?1 ")
	public List<Sujet> SujetParUser(User u);

	// get sujet order par commentaire
	@Query(value = " select sujet.id_sujet , sujet.titre , sujet.date_publication , sujet.description , "
			+ "sujet.sujet_user_id "
			+ "from sujet LEFT JOIN commentaire on sujet.id_sujet = commentaire.comm_sujet_id_sujet "
			+ "group by sujet.id_sujet " + "ORDER by count(commentaire.comm_sujet_id_sujet) DESC ", nativeQuery = true)
	public List<Sujet> getSujetsParCom();
	
	
	@Query(value = " select sujet.id_sujet , sujet.titre , sujet.date_publication , sujet.description , sujet.sujet_user_id "
			+ "from sujet LEFT JOIN rating on sujet.id_sujet = rating.rating_sujet_id_sujet "
			+ "group by sujet.id_sujet " + "ORDER by  sum(rating.nombre)  DESC ", nativeQuery = true)
	public List<Sujet> getSujetsParRates();
	

}