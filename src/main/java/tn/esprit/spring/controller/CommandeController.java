package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Commande;

import tn.esprit.spring.service.CommandeService;
@RestController
public class CommandeController {
	@Autowired
	CommandeService commandeservice ; 


@GetMapping("/retrieve-all-Commandes")
@ResponseBody
public List<Commande> getCommandes(){
	List <Commande> Commande = commandeservice.retrieveAllCommandes();
	return Commande;
}

@GetMapping("/retrieve-Commande/{id}")
@ResponseBody
public Commande getCommandeById(@PathVariable("id") int id_Commande){
	System.out.println(id_Commande);
	return commandeservice.retrieveCommande(id_Commande);
}
@PostMapping("/add-Commande")
@ResponseBody
public String addCommande(@RequestBody Commande l){
	commandeservice.addCommande(l);
	return "this is Commande:"+ l + "and his id" + l.getId_commande() ;
}

@DeleteMapping("/delete-Commande/{id}")
@ResponseBody
public void deleteCommande(@PathVariable("id") int id_Commande){
	commandeservice.deleteCommande(id_Commande);
}

@PutMapping("/update-Commande")
@ResponseBody
public Commande UpdateCommande(@RequestBody Commande Commande){
	return commandeservice.updateCommande(Commande);
}
}



