package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Sujet;  

//repository that extends CrudRepository  
public interface SujetRepository extends CrudRepository<Sujet, Integer>  
{  
}  