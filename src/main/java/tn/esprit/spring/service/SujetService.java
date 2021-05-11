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
import tn.esprit.spring.entity.SujetRecherche;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SujetRepository;

@EnableScheduling
@Service
public class SujetService {
	@Autowired
	SujetRepository sujetRepository;
	@Autowired
	SujetRechercheService srs;

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
			if (jw.similarity(sujets.getTitre().toUpperCase(), sujetE.getTitre().toUpperCase()) > 0.98) {
				return "Sujet Non Unique Merci de changer le Titre";
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

	@Scheduled(cron = "0 0 0 * * *", zone = "Africa/Tunis") // every day
	public void deleteSujetNoInteraction() {
		sujetRepository.deleteSujetWithNoInteraction();
	}

	public List<Map<Sujet, BigInteger>> getNbComSujets() {
		return sujetRepository.getNbComSujets();
	}

	public List<Map<Sujet, BigInteger>> getSumRatSujets() {
		return sujetRepository.getSumRatSujets();
	}

	public List<Sujet> rechercheSujet(String rech , User u) {
		List<Sujet> listRech = sujetRepository.rechercheSujet(rech);
		if (!listRech.isEmpty())
			srs.save(new SujetRecherche(rech, u));
		return listRech;
	}

	public List<Sujet> sujetParUser(Long id) {
		User u = new User();
		u.setId(id);
		return sujetRepository.SujetParUser(u);
	}

	public List<Sujet> rechPertinenceUser(int uid){
		List<String> rsu = srs.listSrparUser(uid);
		List<Sujet> sg = getAll() ;
		List<Sujet> sgp = new ArrayList<>();
		
		/*for (String rs : rsu){
			for (Sujet sujet : sg) {
				if( sujet.getTitre().toUpperCase().contains(rs.toUpperCase()) ){
					sgp.add(sujet);
				}
			}
		}*/
		
		for (int i = 0; i < rsu.size(); i++) {
			for (int j = 0; j < sg.size(); j++) {
				if( sg.get(j).getTitre().toUpperCase().contains(rsu.get(i).toUpperCase()) ){
					sgp.add(sg.get(j));
					sg.remove(j);
				}
			}
		}
		
		return sgp;
	}
	
	public List<Sujet> getSujetParCom() {
		return sujetRepository.getSujetsParCom();
	}
	
	public List<Sujet> getSujetParRating() {
		return sujetRepository.getSujetsParRates();
	}
}