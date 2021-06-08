package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.Reclamation;

public interface ReclamationService {
	List<Reclamation> retrieveAllReclamations();
	List<Reclamation> retrieveAllReclamationsByIdUser(String id ) ;
	Reclamation addReclamation(Reclamation u);
	void deleteReclamation(String id);
	Reclamation updateReclamation(Reclamation u);
	Reclamation retrieveReclamation(String id);
	List<Reclamation> search(String keyword);
	String updateadminEtat (RState u ,String id );
	//String updateadminDecision (String string ,String id );
	Long addOrUpdateReclamation(Reclamation Reclamation);
	
}
