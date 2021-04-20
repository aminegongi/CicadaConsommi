package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Produit_Commandes;

@Repository("ProduitCommandRepository")
public interface Produit_CommandeRepository  extends CrudRepository<Produit_Commandes, Long>{

}
