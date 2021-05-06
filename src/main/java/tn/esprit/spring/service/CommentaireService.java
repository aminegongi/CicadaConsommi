package tn.esprit.spring.service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public String save(Commentaire commentaires) {
		List<String> list = new ArrayList<>();
		try {
			list = Files.readAllLines(new File("src\\main\\resources\\motinterdit.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list.isEmpty() ){
			commentaireRepository.save(commentaires);
			return "Commentaire ajouté ";
		}
		else{
			for (String mot : list) {
				if (commentaires.getDescription().toUpperCase().contains(mot.toUpperCase())) {
					return "Votre Commentaire contient des mots interdits";
				}
			}
			commentaireRepository.save(commentaires);
			return "Commentaire ajouté ";
		}
	}

	public Commentaire getById(int id) {
		return commentaireRepository.findById(id).get();
	}


	public String update(Commentaire commentaires) {
		List<String> list = new ArrayList<>();
		try {
			list = Files.readAllLines(new File("src\\main\\resources\\motinterdit.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list.isEmpty() ){
			commentaireRepository.save(commentaires);
			return "Commentaire modifié // liste vide ";
		}
		else{
			for (String mot : list) {
				if (commentaires.getDescription().contains(mot)) {
					return "Votre Commentaire contient des mots interdits ";
				}
			}
			commentaireRepository.save(commentaires);
			return "Commentaire modifié list feha";
		}
	}

	public void delete(int id) {
		commentaireRepository.deleteById(id);
	}
	
	public List<Map< Commentaire , BigInteger >> getComByPert() {
		return commentaireRepository.getComByPert();
	}
}