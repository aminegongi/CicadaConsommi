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

import tn.esprit.spring.entity.React;
import tn.esprit.spring.service.ReactService;

@RestController  
@RequestMapping("/react")
public class ReactController {
	
	@Autowired  
	ReactService reactService ;
	
	@GetMapping("/getAll")  
	@ResponseBody
	private List<React> getAllReacts()   
	{  
		return reactService.getAll();  
	}  
	 
	@PostMapping("/add")  
	@ResponseBody
	private int saveReact(@RequestBody React Reacts)   
	{  
		reactService.save(Reacts);  
		return Reacts.getId();  
	}  
	
	@GetMapping("/get/{reactid}")
	@ResponseBody
	private React getReact(@PathVariable("reactid") int commid) {
		return reactService.getById(commid);
	}

	@DeleteMapping("/{reactid}")
	@ResponseBody
	private void deleteReact(@PathVariable("reactid") int commid) {
		reactService.delete(commid);
	}

	@PutMapping("/")
	@ResponseBody
	private React updateReact(@RequestBody React Reacts) {
		reactService.update(Reacts);
		return Reacts;
	}
	
}  