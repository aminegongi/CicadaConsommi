package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Produit_Commandes;;

public interface Produit_CommandesService {
	List<Produit_Commandes> retrieveAllProducts_commands();
	Produit_Commandes addProduits_cmds(Produit_Commandes pc);
	void addProduit_cmd(Produit_Commandes pc);
	void deleteProduct_cmd(String id_Produit_Cmd);
	Produit_Commandes updateProducts(Produit_Commandes pc);
	Produit_Commandes retrieveProducts_cmds(String id_Produit_Cmd);
	List<Produit_Commandes> search(String keyword);
	float getPoidcmd(long qte,long produit_id_produit );
}
