package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Produit;;

public interface ProduitService {
	List<Produit> retrieveAllProducts();
	Produit addProducts(Produit p);
	void deleteProducts(String id);
	Produit updateProducts(Produit p);
	Produit retrieveProducts(String id);
}
