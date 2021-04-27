package tn.esprit.spring.controller;

import java.math.BigInteger;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.service.CommentaireService;

@RestController  
@RequestMapping("/client/commentaire")
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
	private String saveCommentaire(@RequestBody Commentaire commentaires)   
	{  
		return commService.save(commentaires);  
		//return commentaires.getId();  
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
	private String updateCommentaire(@RequestBody Commentaire commentaires) {
		return commService.update(commentaires);
	}
	
	@GetMapping("/getComm/React")  
	@ResponseBody
	private List<Map< Commentaire , BigInteger >> getComByPert()   
	{  
		return commService.getComByPert();
	} 
	
}  