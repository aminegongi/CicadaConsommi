package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Livraison;


@Repository("Commanderepo")
public interface CommandeRepository extends CrudRepository< Commande, Integer>  {

}
