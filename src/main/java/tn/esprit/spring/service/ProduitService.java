package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Produit;;

public interface ProduitService {
	List<Produit> retrieveAllProducts();
	Produit addProducts(Produit p);
	void addProduit(Produit p);
	void deleteProducts(String id);
	Produit updateProducts(Produit p);
	Produit retrieveProducts(String id);
	boolean verification619(String id_product);
	String Etat_produit(String id_product);
	String Rating(String id_product);
	List<Produit> search(String keyword);
}
