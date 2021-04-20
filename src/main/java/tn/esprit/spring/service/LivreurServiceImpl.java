package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Livreur;

public interface LivreurServiceImpl {

	List<Livreur> retrieveAllLivreurs();
    Livreur addLivreur(Livreur l);
	void deleteLivreur(int id);
	Livreur updateLivreur(Livreur u);
	Livreur retrieveLivreur(int id);
	
}
