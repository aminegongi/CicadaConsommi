package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Livreur;

@Repository("livreurrepo")
public interface LivreurRepository extends CrudRepository< Livreur, Integer>  {

}
