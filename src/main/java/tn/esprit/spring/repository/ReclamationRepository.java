package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.Reclamation;

@Repository("ReclamationRepository")
public interface ReclamationRepository extends CrudRepository<Reclamation , Long> {
	@Query(value="select * from reclamation where State= :Etat  "
            ,
            nativeQuery = true)
    public List<Reclamation> findReclamationByEtat(@Param("Etat") String Etat);
	
	@Modifying
	@Transactional
	@Query("update Reclamation r set r.State = :Etat where r.id_reclamation = :id")
	void updateStateById(@Param("Etat") RState Etat, @Param("id") Long id) ;
	
	
	


	@Query(value="select * from reclamation  where  reclamation_user_id = ?1"  ,nativeQuery = true )         
     public List<Reclamation> findReclamationByUserId(@Param("id") Long id);
	 

}
