package tn.esprit.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService; 

@Controller
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

@DeleteMapping("/delete-product/{id_product}")
@ResponseBody
public ResponseEntity deleteProduct(@PathVariable("id_product") String id_product){
	produitservice.deleteProducts(id_product);
	return new ResponseEntity(HttpStatus.OK);
}

@PutMapping("/update-product")
@ResponseBody
public Produit UpdateProduct(@RequestBody Produit produits){
	return produitservice.updateProducts(produits);
}

@GetMapping("/Etat-produit/{id_product}")
@ResponseBody
public String Etat_product(@PathVariable("id_product") String id_product){
//	boolean v = 
	String etat = produitservice.Etat_produit(id_product);
	if (etat.contains("Expire"))
		return "Expired";
	else if (etat.contains("equal"))
		return "both dates are equal";
	else
		return "Not expired";
}

@GetMapping("/verify/{id_product}")
@ResponseBody
public String verify619(@PathVariable("id_product") String id_product){
//	boolean v = 
	if (produitservice.verification619(id_product) == true) 
		return "Tounsi";
	else 
		return "mch Tounsi";
}


@GetMapping("/Rate/{id_product}")
@ResponseBody
public String Rating(@PathVariable("id_product") String id_product){
	String nom_produit = produitservice.Rating(id_product);
		return "Rating the recived product : "+ nom_produit ;
}

//-----------------------------
@RequestMapping("/greeting")
public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	return "products/product";
}

@GetMapping("/all")
public String showAll(Model model) {
    model.addAttribute("produits", produitservice.retrieveAllProducts());
    return "products/ProductsList";
}


@DeleteMapping("/delete/{id_product}")
public String DeleteProductPage(@PathVariable("id_product") String id_product,Model model){
	produitservice.deleteProducts(id_product);
	 model.addAttribute("produit",produitservice.retrieveProducts(id_product));
	return "products/DeleteProduct";
}

@GetMapping("/show_product/{id_product}")
public String ShowById(@PathVariable("id_product") String id_product , Model model)
{
	Produit p =produitservice.retrieveProducts(id_product);
	model.addAttribute("pageTitle","Result for "+ p.getNom_produit());
	 model.addAttribute("produit",produitservice.retrieveProducts(id_product));
	 return "products/ProductList";
}


//@RequestMapping(value = "/create")
//@GetMapping("/create")
//public String submit(Model model) {
//	
//    	produitservice.addProducts(new Produit());
////    	produitservice.addProducts(new Produit());
//    
//    model.addAttribute("form", produitservice);
//    return "products/CreateProduct";
//}


@RequestMapping(value = "/create", method = RequestMethod.GET)
public ModelAndView showForm() {
    return new ModelAndView("products/CreateProduct", "produit", new Produit());
}

@RequestMapping(value = "/created-product", method = RequestMethod.POST)
public String submitproduct(@Valid @ModelAttribute("produit")Produit produit, 
  BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
        return "error";
    }
model.addAttribute("productID", produit.getId_produit());
model.addAttribute("productName", produit.getNom_produit());
model.addAttribute("productPrice", produit.getPrix_produit());
model.addAttribute("productDescription", produit.getDescription_produit());
model.addAttribute("productBrand", produit.getMarque_produit());
model.addAttribute("productBarCode", produit.getCodeBarre_produit());
    return "products/ProductList";
}

@GetMapping("/search")
public String search(@Param("keyword") String keyword, Model model) {
	List<Produit> searchResult = produitservice.search(keyword);
	model.addAttribute("keyword",keyword);
	model.addAttribute("pageTitle"," Search Results for '"+keyword+"'");
	model.addAttribute("SearchResult",searchResult);

	return "products/search_result";
}
 
}
