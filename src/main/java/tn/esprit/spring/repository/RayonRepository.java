package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Category;
/*import tn.esprit.spring.entities.Product;*/
import tn.esprit.spring.entity.Rayon;



@Repository
public interface RayonRepository extends CrudRepository <Rayon, Integer> {
	@Query(value="SELECT * FROM rayon  WHERE type = ? ",nativeQuery=true)
	List<Rayon> findByType(String type);
	
	@Query(value="SELECT * FROM rayon ",nativeQuery=true)
	Rayon[] AllRayonsV();
	
	@Query(value="SELECT type FROM rayon ",nativeQuery=true)
	List<String> findTypes();
	
	@Query(value="SELECT * FROM category  WHERE rayon_id = ? ",nativeQuery=true)
	List<Category> ShowCategories(int id);
	
	@Query(value="SELECT * FROM rayon  WHERE category_id = ? ",nativeQuery=true)
	Rayon findByCategory(int id);
	
	@Query(value="SELECT r.id , r.type FROM rayon r  WHERE r.id = ? ",nativeQuery=true)
	int findByrayon(int p);
	
	@Query(value="SELECT p.id FROM product p ,category c,rayon r  WHERE r.id= ? and r.category_id = c.id  and c.id = p.id_category   ",nativeQuery=true)
	List<Long> findAllProductByrayon(int idr);

}