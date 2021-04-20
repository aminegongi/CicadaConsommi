package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
