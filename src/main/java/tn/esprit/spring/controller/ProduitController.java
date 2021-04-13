package tn.esprit.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	@Autowired 
	ProduitService produitservice;

@GetMapping("/retrieve-all-products")
@ResponseBody
public List<Produit> getProducts(){
	List<Produit> produits = produitservice.retrieveAllProducts();
	return produits;
}

@GetMapping("/retrieve-product/{id_product}")
@ResponseBody
public Produit getProductById(@PathVariable("id_product") String id_product){
	return produitservice.retrieveProducts(id_product);
}

@PostMapping("/add-product")
@ResponseBody
public Produit addProduct(@RequestBody Produit p){
	Produit produit= produitservice.addProducts(p);
	return produit;
}

@DeleteMapping("/delete-product")
@ResponseBody
public void deleteUser(@PathVariable("id") String id){
	produitservice.deleteProducts(id);
}

@PutMapping("/update-product")
@ResponseBody
public Produit UpdateUser(@RequestBody Produit produits){
	return produitservice.updateProducts(produits);
}

//-----------------------------
@RequestMapping("/sayhello")
public String welcome(Map<String, Object> model, @RequestParam("myName") String name){
	model.put("receive name", name);
	return "hellopage";
}
//-----------------------------
}
