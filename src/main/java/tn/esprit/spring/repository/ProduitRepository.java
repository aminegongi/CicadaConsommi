package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.service.*;
import tn.esprit.spring.entity.Produit;

@Repository("ProduitRepository")
public interface ProduitRepository  extends CrudRepository<Produit, Long>
{
//		List<Produit> findByNom_produit(String nom_produit);
//		List<Produit> findById_produit(long id_produit);
	

}
