package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Stock;
/*import tn.spring.esprit.entities.Product;*/


@Repository
public interface StockRepository extends CrudRepository <Stock, Integer> {
	@Query(value="SELECT p.id FROM product p,stock s  WHERE   s.amount<10 ",nativeQuery=true)
	List<Long> missingProduct();
	
	@Query(value="SELECT * FROM stock s  ORDER BY s.amount DESC ",nativeQuery=true)
	List<Stock> TriByAmount();
	
	@Query(value="SELECT * FROM stock s ORDER BY s.qtee DESC ",nativeQuery=true)
	List<Stock> TriByQtee();
	
	@Query(value="SELECT * FROM stock s  ORDER BY s.qtes DESC ",nativeQuery=true)
	List<Stock> TriByQtes();
	
	
	/*@Query(value="SELECT * FROM stock s  WHERE s.id = ? ",nativeQuery=true)
	Stock findStock(int id);*/
	

}
