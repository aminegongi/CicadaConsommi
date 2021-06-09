package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Produit;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer>{
	
	@Query(value="SELECT * FROM category  WHERE name = ? ",nativeQuery=true)
	List<Category> findByName(String name);
	
	@Query(value="SELECT * FROM category  WHERE rayon_id = ? ",nativeQuery=true)
	List<Category> groupedByRayon(int idRayon);
	
	@Query(value="SELECT * FROM produit",nativeQuery=true)
	List<Produit> getAllProducts();

}
