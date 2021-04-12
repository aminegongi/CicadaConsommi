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

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.service.CommentaireService;

@RestController  
@RequestMapping("/commentaire")
public class CommentaireController {
	
	@Autowired  
	CommentaireService commService ;
	
	@GetMapping("/getAll")  
	@ResponseBody
	private List<Commentaire> getAllCommentaires()   
	{  
		return commService.getAll();  
	}  
	 
	@PostMapping("/add")  
	@ResponseBody
	private int saveCommentaire(@RequestBody Commentaire commentaires)   
	{  
		commService.save(commentaires);  
		return commentaires.getId();  
	}  
	
	@GetMapping("/get/{commid}")
	@ResponseBody
	private Commentaire getCommentaire(@PathVariable("commid") int commid) {
		return commService.getById(commid);
	}

	@DeleteMapping("/{commid}")
	@ResponseBody
	private void deleteCommentaire(@PathVariable("commid") int commid) {
		commService.delete(commid);
	}

	@PutMapping("/")
	@ResponseBody
	private Commentaire updateCommentaire(@RequestBody Commentaire commentaires) {
		commService.update(commentaires);
		return commentaires;
	}
	
}  