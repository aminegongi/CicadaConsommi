package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Commande;


public interface CommandeServiceImpl {

	List<Commande> retrieveAllCommandes();
    Commande addCommande(Commande l);
	void deleteCommande(int id);
	Commande updateCommande(Commande u);
	Commande retrieveCommande(int id);
	
}
