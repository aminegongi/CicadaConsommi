package tn.esprit.spring.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.service.SujetService;

@RestController
@RequestMapping("/sujet")
public class SujetController {

	@Autowired
	SujetService sujetservice;

	@GetMapping("/getAll")
	@ResponseBody
	private List<Sujet> getAllSujets() {
		return sujetservice.getAll();
	}

	@PostMapping("/add")
	@ResponseBody
	private String saveSujets(@RequestBody Sujet sujets) {
		
		return sujetservice.save(sujets); 
	}


	@GetMapping("/get/{sujetid}")
	@ResponseBody
	private Sujet getSujet(@PathVariable("sujetid") int sujetid) {
		return sujetservice.getById(sujetid);
	}

	@DeleteMapping("/{sujetid}")
	@ResponseBody
	private void deleteSujet(@PathVariable("sujetid") int sujetid) {
		sujetservice.delete(sujetid);
	}

	@PutMapping("/")
	@ResponseBody
	private Sujet updateSujet(@RequestBody Sujet sujet) {
		sujetservice.update(sujet);
		return sujet;
	}
	
	@DeleteMapping("/noInter")
	@ResponseBody
	private void deleteSujetNoInteraction() {
		sujetservice.deleteSujetNoInteraction();
	}
	
	@GetMapping("/getSujet/Comm")
	@ResponseBody
	private List<Map< Sujet , BigInteger >> getNbComSujets() {
		return sujetservice.getNbComSujets();
	}
	
	@GetMapping("/getSujet/Rating")
	@ResponseBody
	private List<Map< Sujet , BigInteger >> getSumRatSujets() {
		return sujetservice.getSumRatSujets();
	}

}