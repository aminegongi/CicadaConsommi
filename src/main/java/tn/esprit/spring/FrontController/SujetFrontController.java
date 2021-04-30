package tn.esprit.spring.FrontController;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.service.SujetService;

@Controller
@RequestMapping("/client/sujet")
public class SujetFrontController {

	@Autowired
	SujetService sujetservice;

	@RequestMapping("/front/getAll")
	public String front_affichageSujet(Model model) {
		model.addAttribute("sujets", sujetservice.getAll());
		return "sujet/SujetsList";
	}

	@RequestMapping("/front/rech")
	public String front_rechercheSujet(@Param("keyword") String keyword, Model model) {
		List<Sujet> searchResult = sujetservice.rechercheSujet(keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("SearchResult", searchResult);
		return "sujet/search_result";
	}

	@RequestMapping("/front/delete/{id}")
	public String front_deleteSujet(@PathVariable("id") int id, Model model) {
		sujetservice.delete(id);
	    return "redirect:/sujet/front/getAll";       
	}
	
	
	
}