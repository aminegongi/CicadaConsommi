package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	@Autowired
	ReclamationRepository ReclamationRepository ;
	
   

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation> Reclamations = new ArrayList<Reclamation>();  
		ReclamationRepository.findAll().forEach(ReclamationAjout  -> Reclamations .add(ReclamationAjout));  
		return Reclamations ;	
	}

	@Override
	public Reclamation addReclamation(Reclamation u) {
		// TODO Auto-generated method stub
		ReclamationRepository.save(u) ;
		return u;
	}

		
	
	@Override
	public Reclamation updateReclamation(Reclamation u) {
		// TODO Auto-generated method stub
		
		ReclamationRepository.save(u) ;
		return u;
	}

	@Override
	public Reclamation retrieveReclamation(String id) {
		// TODO Auto-generated method stub
		
		return ReclamationRepository.findById(Long.parseLong(id)).get() ;
	}

	@Override
	public void deleteReclamation(String id) {
		// TODO Auto-generated method stub
		ReclamationRepository.deleteById(Long.parseLong(id));
		
	}

}
