package tn.esprit.spring.service;

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
		logger.info("ezffz" + sr.getRechercheSujetUser().getId());
		int idru = srr.rechercheUser(sr.getTag(),sr.getRechercheSujetUser().getId());
		logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		if (idru == -1) {
			srr.addOne(idru);
			return "Update Recherche Sujet User";
		}
		srr.save(sr);
		return "New Recherche Sujet User";
	}

}