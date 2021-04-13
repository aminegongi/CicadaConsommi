package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.React;

//repository that extends CrudRepository  
public interface ReactRepository extends CrudRepository<React, Integer>  
{  
}  