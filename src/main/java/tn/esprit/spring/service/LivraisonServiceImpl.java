package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Livraison;


public interface LivraisonServiceImpl {

	List<Livraison> retrieveAllLivraisons();
    Livraison addLivraison(Livraison l);
	void deleteLivraison(int id);
	Livraison updateLivraison(Livraison u);
	Livraison retrieveLivraison(int id);
	
}
