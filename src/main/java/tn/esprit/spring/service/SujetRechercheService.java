package tn.esprit.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.SujetRecherche;
import tn.esprit.spring.repository.SujetRechercheRepository;

@EnableScheduling
@Service
public class SujetRechercheService {
	
	@Autowired
	SujetRechercheRepository srr;
	
	Logger logger = LoggerFactory.getLogger(SujetRechercheService.class);
	
	public String save(SujetRecherche sr) {
		//logger.info("--------ezffz " + sr.getRechercheSujetUser().getId());
		Integer idru = srr.rechercheUser(sr.getTag().toUpperCase(),sr.getRechercheSujetUser().getId());
		if (idru != null ) {
			srr.addOne(idru);
			return "Update Recherche Sujet User";
		}
		srr.save(sr);
		return "New Recherche Sujet User";
	}
	
	public List<String> listSrparUser(int id){
		return srr.listSrparUser(id);
	}
}