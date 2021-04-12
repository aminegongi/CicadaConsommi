package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.repository.CommentaireRepository;

//defining the business logic  
@Service
public class CommentaireService {
	@Autowired
	CommentaireRepository commentaireRepository;

	public List<Commentaire> getAll() {
		List<Commentaire> commentaires = new ArrayList<Commentaire>();
		commentaireRepository.findAll().forEach(commentaire1 -> commentaires.add(commentaire1));
		return commentaires;
	}

	public void save(Commentaire commentaires) {
		commentaireRepository.save(commentaires);
	}

	public Commentaire getById(int id) {
		return commentaireRepository.findById(id).get();
	}


	public void update(Commentaire commentaires) {
		commentaireRepository.save(commentaires);
	}

	public void delete(int id) {
		commentaireRepository.deleteById(id);
	}
}