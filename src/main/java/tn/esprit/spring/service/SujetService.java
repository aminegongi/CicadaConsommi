package tn.esprit.spring.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import info.debatty.java.stringsimilarity.JaroWinkler;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.SujetRepository;

@EnableScheduling
@Service
public class SujetService {
	@Autowired
	SujetRepository sujetRepository;

	public List<Sujet> getAll() {
		List<Sujet> sujets = new ArrayList<Sujet>();
		sujetRepository.findAll().forEach(sujet1 -> sujets.add(sujet1));
		return sujets;
	}

	public Sujet getById(int id) {
		return sujetRepository.findById(id).get();
	}

	public String save(Sujet sujets) {
		JaroWinkler jw = new JaroWinkler();

		for (Sujet sujetE : getAll()) {
			if  ( jw.similarity(sujets.getTitre().toUpperCase(), sujetE.getTitre().toUpperCase()) > 0.9 ){
				return "Sujet Non Unique Merci de changer le Titre" ;
			}
		}
		sujetRepository.save(sujets);
		return "Sujet a été ajouté avec succès id :" + sujets.getId();
	}

	public void update(Sujet sujets) {
		sujetRepository.save(sujets);
	}

	public void delete(int id) {
		sujetRepository.deleteById(id);
	}
	
	@Scheduled(cron = "0 0 0 * * *" , zone="Africa/Tunis") //every day
	public void deleteSujetNoInteraction() {
		sujetRepository.deleteSujetWithNoInteraction();
	}
	
	public List<Map< Sujet , BigInteger >> getNbComSujets() {
		return sujetRepository.getNbComSujets();
	}
	
	public List<Map< Sujet , BigInteger >> getSumRatSujets() {
		return sujetRepository.getSumRatSujets();
	}
}