package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Rating;

//repository that extends CrudRepository  
public interface RatingRepository extends CrudRepository<Rating, Integer>  
{ 
	@Query(value="select SUM(rating.nombre) FROM rating where rating.rating_sujet_id_sujet=:ratingSujet",nativeQuery=true)
	public float sumrating(@Param("ratingSujet")int ratingSujet);
	
	
	@Query(value="select COUNT(*) FROM rating where rating.rating_sujet_id_sujet=:ratingSujet",nativeQuery=true)
	public float countrating(@Param("ratingSujet")int ratingSujet);
}  