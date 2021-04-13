package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.SujetRepository;


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

	public void save(Sujet sujets) {
		sujetRepository.save(sujets);
	}

	public void update(Sujet sujets) {
		sujetRepository.save(sujets);
	}

	public void delete(int id) {
		sujetRepository.deleteById(id);
	}
}