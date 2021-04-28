package tn.esprit.spring.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.service.*;
import tn.esprit.spring.entity.Produit;

@Repository("ProduitRepository")
public interface ProduitRepository  extends CrudRepository<Produit, Long>
{
//		List<Produit> findByNom_produit(String nom_produit);
//		List<Produit> findById_produit(long id_produit);
//	@Query("select p from Produit p where p.id_produit = :id_produit")
//	public List<Produit> findProduitById(@Param("id_produit") Long id_produit);
//	
	@Query(value="SELECT * FROM Produit WHERE "
			+"nom_produit like"
			+"(?1)",
			nativeQuery = true)
	public List<Produit> findProduitByNom(@Param("nom_produit") String nom_produit); 
	
	@Query(value="SELECT * FROM Produit WHERE marque_produit like"
			+"(?1)",
			nativeQuery = true)
	public List<Produit> findProduitByMarque(@Param("marque_produit") String marque_produit); 
	
	@Query(value="SELECT * FROM Produit WHERE prix_produit like"
			+"(?1)",
			nativeQuery = true)
	public List<Produit> findProduitByPrice(@Param("prix_produit") String prix_produit); 

	@Query(value="SELECT * FROM Produit WHERE ref_produit like"
			+"(?1)",
			nativeQuery = true)
	public List<Produit> findProduitByRef(@Param("ref_produit") String ref_produit); 
	
	@Query(value="SELECT * FROM Produit WHERE id_produit  like"
			+"(?1)",
			nativeQuery = true)
	public List<Produit> findProduitById(@Param("id_produit") String id_produit); 
	
}
