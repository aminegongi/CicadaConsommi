package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Rating;

//repository that extends CrudRepository  
public interface RatingRepository extends CrudRepository<Rating, Integer>  
{  
}  