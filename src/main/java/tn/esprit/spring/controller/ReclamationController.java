package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.ReclamationService;



@RestController  
@RequestMapping("/reclamation")
public class ReclamationController {
	
	@Autowired  
	ReclamationService ReclamationService ;
	
	@GetMapping("/getAll")  
	@ResponseBody
	private List<Reclamation> getAllReclamations()   
	{  
		return ReclamationService.retrieveAllReclamations();  
	}  
	 
	@PostMapping("/add")  
	@ResponseBody
	private Reclamation saveReclamation(@RequestBody Reclamation Reclamations)   
	{  
		ReclamationService.addReclamation(Reclamations);  
		return Reclamations ;  
			}  
	
	@GetMapping("/get/{Reclamationid}")
	@ResponseBody
	private Reclamation getReclamation(@PathVariable("Reclamationid") String Reclamationid) {
		return ReclamationService.retrieveReclamation(Reclamationid);
	}

	@DeleteMapping("/{Reclamationid}")
	@ResponseBody
	private void deleteReclamation(@PathVariable("Reclamationid") String Reclamationid) {
		ReclamationService.deleteReclamation(Reclamationid);
	}

	@PutMapping("/")
	@ResponseBody
	private Reclamation updateReclamation(@RequestBody Reclamation Reclamations) {
		ReclamationService.updateReclamation(Reclamations);
		return Reclamations;
	}
	
}  