package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.DecisionRepository;
import tn.esprit.spring.repository.ReclamationRepository;




@Service
public  class DecisionServiceImpl  implements DecisionService  {  
	
	
	@Autowired
    DecisionRepository  decisionRepository ;
	Reclamation R ;
	@Autowired
	ReclamationRepository reclamationrepository ;
	@Autowired
	NotifService notif ;
	@Override
	public List<Decision> retrieveAllVDecisions() {
		List<Decision> dec = new ArrayList<Decision>();  
		decisionRepository.findAll().forEach(decA  -> dec .add(decA));  
		return dec;
	}
	@Override
	public List<Decision> retrieveAllDecisionsByIdReclamation(String id) {
		// TODO Auto-generated method stub
		return decisionRepository.findDecisionByReclamationId(Long.parseLong(id));
	}
	@Override
	public Decision addDecision(Decision u) {
	 decisionRepository.save(u);
		
		Decision d = retrieveDecision (Long.toString(u.getId_Decision())) ;
		
		return u ; 
	}
	@Override
	public void deleteDecision(String id) {
		// TODO Auto-generated method stub
		decisionRepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public Decision updateDecision(Decision u) {
		// TODO Auto-generated method stub
		 decisionRepository.save(u);
		 return u ; 
	}
	@Override
	public Decision retrieveDecision(String id) {
		// TODO Auto-generated method stub
		return decisionRepository.findById(Long.parseLong(id)).get() ;
	}


	
	
	

}
