package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.Reclamation;

@Repository("DecisionRepository")
public interface DecisionRepository extends CrudRepository<Decision , Long> {
	
	@Query(value="select * from decision  where  decision_id_reclamation = ?1"  ,nativeQuery = true )         
    public List<Decision> findDecisionByReclamationId(@Param("id") Long id); 
	 
}
