package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.React;
import tn.esprit.spring.entity.Sujet;

//repository that extends CrudRepository  
public interface ReactRepository extends CrudRepository<React, Integer>  
{  
	@Query(value = "SELECT count(DISTINCT(react.react_user_id)) as react FROM react WHERE react.react_comm_id_comm = ?1 and react.type = ?2 ", nativeQuery = true)
	public String countReactPerComPerType(int idCom , int type);
	
}  