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

import tn.esprit.spring.entity.Livreur;

import tn.esprit.spring.service.LivreurService;
@RestController
public class LivreurController {
	@Autowired
	LivreurService livreurservice ; 


@GetMapping("/retrieve-all-Livreurs")
@ResponseBody
public List<Livreur> getLivreurs(){
	List <Livreur> Livreur = livreurservice.retrieveAllLivreurs();
	return Livreur;
}

@GetMapping("/retrieve-Livreur/{id}")
@ResponseBody
public Livreur getLivreurById(@PathVariable("id") int id_Livreur){
	System.out.println(id_Livreur);
	return livreurservice.retrieveLivreur(id_Livreur);
}
@PostMapping("/add-Livreur")
@ResponseBody
public String addLivreur(@RequestBody Livreur l){
	livreurservice.addLivreur(l);
	return "this is Livreur:"+ l + "and his id" + l.getId() ;
}

@DeleteMapping("/delete-Livreur/{id}")
@ResponseBody
public void deleteLivreur(@PathVariable("id") int id_Livreur){
	livreurservice.deleteLivreur(id_Livreur);
}

@PutMapping("/update-Livreur")
@ResponseBody
public Livreur UpdateLivreur(@RequestBody Livreur Livreur){
	return livreurservice.updateLivreur(Livreur);
}
}



