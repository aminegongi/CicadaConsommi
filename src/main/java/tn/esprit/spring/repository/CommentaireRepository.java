package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Commentaire;


//repository that extends CrudRepository  
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer>  
{  
}  