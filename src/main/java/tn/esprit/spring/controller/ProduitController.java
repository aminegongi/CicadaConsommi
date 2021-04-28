package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

@Scope(value = "session")
@Controller(value = "produitcontroller")
@ELBeanName(value = "produitcontroller")
@RequestMapping("/produit")
@Join(path = "/produit", to = "/produit.jsf")
public class ProduitController {
	@Autowired
	ProduitService produitservice;
	String abc = "abc";

	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Produit> getProducts() {
		List<Produit> produits = produitservice.retrieveAllProducts();
		return produits;
	}

	@GetMapping("/retrieve-product/{id_product}")
	@ResponseBody
	public Produit getProductById(@PathVariable("id_product") String id_product) {
		return produitservice.retrieveProducts(id_product);
	}

	@PostMapping("/add-product")
	@ResponseBody
	public Produit addProduct(@RequestBody Produit p) {
		Produit produit = produitservice.addProducts(p);
		return produit;
	}

	@DeleteMapping("/delete-product/{id_product}")
	@ResponseBody
	public ResponseEntity deleteProduct(@PathVariable("id_product") String id_product) {
		produitservice.deleteProducts(id_product);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/update-product")
	@ResponseBody
	public Produit UpdateProduct(@RequestBody Produit produits) {
		return produitservice.updateProducts(produits);
	}

	@GetMapping("/Etat-produit/{id_product}")
	@ResponseBody
	public String Etat_product(@PathVariable("id_product") String id_product) {
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
	public String verify619(@PathVariable("id_product") String id_product) {
		// boolean v =
		if (produitservice.verification619(id_product) == true)
			return "Tounsi";
		else
			return "Mch Tounsi";
	}

	@GetMapping("/Rate/{id_product}")
	@ResponseBody
	public String Rating(@PathVariable("id_product") String id_product) {
		String nom_produit = produitservice.Rating(id_product);
		return "Rating the recived product : " + nom_produit;
	}

	// -----------------------------
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "products/product";
	}

	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("produits", produitservice.retrieveAllProducts());
		return "products/ProductsList";
	}

	@DeleteMapping("/delete/{id_product}")
	public String DeleteProductPage(@PathVariable("id_product") String id_product, Model model) {
		produitservice.deleteProducts(id_product);
		model.addAttribute("produit", produitservice.retrieveProducts(id_product));
		return "products/DeleteProduct";
	}

	@GetMapping("/show_product/{id_product}")
	public String ShowById(@PathVariable("id_product") String id_product, Model model) {
		Produit p = produitservice.retrieveProducts(id_product);
		model.addAttribute("pageTitle", "Result for " + p.getNom_produit());
		model.addAttribute("produit", produitservice.retrieveProducts(id_product));
		return "products/ProductList";
	}
	
	
//	-----------------Partie EDIT --------------------------
	@RequestMapping("/edit/{id_product}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id_product") String id_product) {
		ModelAndView mav = new ModelAndView("products/edit_product");
		Produit product =  produitservice.retrieveProducts(id_product); 
		mav.addObject("product", product); 
		return mav;
	}

	
//	-----------------Partie Create --------------------------
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Produit product = new Produit();
		model.addAttribute("product", product);

		return "products/CreateProduct";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Produit product ) {
		Date date = new Date(System.currentTimeMillis());
//		LocalDate date = LocalDate.now();
		product.setDateAjout_produit(date);
		produitservice.addProducts(product);
		return "products/add";
	}
//	-----------------Partie SEARCH --------------------------
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword,@Param("choix") String choix, Model model) {
		List<Produit> searchResult = null ;
		String c=(String) model.getAttribute(choix);
		if (c == "ByName") {
			searchResult = produitservice.searchNom(keyword);
		}else if (c == "ByBrand"){
			 produitservice.searchBrand(keyword);
		}else if(c == "ByRef"){
			 produitservice.searchRef(keyword);
		}else{
			searchResult = produitservice.searchNom(keyword);
		}
		
		model.addAttribute("choix", choix);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageTitle", " Search Results for '" + keyword + "'" + choix);
		model.addAttribute("SearchResult", searchResult);

		return "products/search_result";
	}

	
	@RequestMapping("/delete/{id_product}")
	public String deleteProduit(@PathVariable("id_product") String id_product, Model model) {
		Produit p =produitservice.retrieveProducts(id_product);
		model.addAttribute("produit",  p);
		produitservice.deleteProducts(id_product);
		return "products/Delete";
	}
	
	
	
}
