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

import tn.esprit.spring.entity.Livraison;

import tn.esprit.spring.service.LivraisonService;
@RestController
public class LivraisonController {
	@Autowired
	LivraisonService livraisonservice ; 


@GetMapping("/retrieve-all-Livraisons")
@ResponseBody
public List<Livraison> getLivraisons(){
	List <Livraison> Livraison = livraisonservice.retrieveAllLivraisons();
	return Livraison;
}

@GetMapping("/retrieve-Livraison/{id}")
@ResponseBody
public Livraison getLivraisonById(@PathVariable("id") int id_Livraison){
	System.out.println(id_Livraison);
	return livraisonservice.retrieveLivraison(id_Livraison);
}
@PostMapping("/add-Livraison")
@ResponseBody
public String addLivraison(@RequestBody Livraison l){
	livraisonservice.addLivraison(l);
	return "this is Livraison:"+ l + "and his id" + l.getId_livraison() ;
}

@DeleteMapping("/delete-Livraison/{id}")
@ResponseBody
public void deleteLivraison(@PathVariable("id") int id_Livraison){
	livraisonservice.deleteLivraison(id_Livraison);
}

@PutMapping("/update-Livraison")
@ResponseBody
public Livraison UpdateLivraison(@RequestBody Livraison Livraison){
	return livraisonservice.updateLivraison(Livraison);
}
}



