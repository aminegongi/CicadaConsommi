package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Livraison;


@Repository("livraisonrepo")
public interface LivraisonRepository extends CrudRepository< Livraison, Integer>  {

}
