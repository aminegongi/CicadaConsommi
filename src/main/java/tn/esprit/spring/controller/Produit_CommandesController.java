package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Produit_Commandes;
import tn.esprit.spring.service.Produit_CommandesService;
@Controller
@RequestMapping("/Produit_Commandes")
public class Produit_CommandesController {
	@Autowired 
	Produit_CommandesService produit_cmd;
	@GetMapping("/retrieve-all-products-commands")
	@ResponseBody
	public List<Produit_Commandes> getProducts(){
		List<Produit_Commandes> produit_Cmd = produit_cmd.retrieveAllProducts_commands();
		return produit_Cmd;
		
	
	}
	@GetMapping("/retrieve-product-command/{id_Produit_Cmd}")
	@ResponseBody
	public Produit_Commandes getProductById(@PathVariable("id_product") String id_Produit_Cmd) {
		return  produit_cmd.retrieveProducts_cmds(id_Produit_Cmd);
	}
	
	@GetMapping("/poid_cmd/{id_product}/{qte}")
	@ResponseBody
	public float Etat_product(@PathVariable("id_product") String id_product,long Qte) {
		Produit_Commandes pc=produit_cmd.retrieveProducts_cmds(id_product);
		float poid=pc.getProduit().getPoid_produit();
		return poid*Qte;
	}

}