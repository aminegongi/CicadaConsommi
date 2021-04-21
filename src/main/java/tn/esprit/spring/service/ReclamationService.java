package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;

public interface ReclamationService {
	List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation(Reclamation u);
	void deleteReclamation(String id);
	Reclamation updateReclamation(Reclamation u);
	Reclamation retrieveReclamation(String id);
	
	List<Reclamation> search(String keyword);    
}
