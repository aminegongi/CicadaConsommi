package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Produit_Commandes;;

public interface Produit_CommandesService {
	List<Produit_Commandes> retrieveAllProducts_commands();
	Produit_Commandes addProducts(Produit_Commandes pc);
	void addProduit(Produit_Commandes pc);
	void deleteProducts(String id);
	Produit_Commandes updateProducts(Produit_Commandes pc);
	Produit_Commandes retrieveProducts(String id);
	List<Produit_Commandes> search(String keyword);
}
