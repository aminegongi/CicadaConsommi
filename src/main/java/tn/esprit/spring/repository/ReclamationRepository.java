package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;

@Repository("ReclamationRepository")
public interface ReclamationRepository extends CrudRepository<Reclamation , Long> {
	@Query(value="select * from reclamation where état = :Etat "
            ,
            nativeQuery = true)
    public List<Reclamation> findReclamationByEtat(@Param("Etat") String Etat);



	

	
	

}
