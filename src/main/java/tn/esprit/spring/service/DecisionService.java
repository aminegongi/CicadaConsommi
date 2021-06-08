package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Decision;



public interface DecisionService {
	
	List<Decision> retrieveAllVDecisions();
	List<Decision> retrieveAllDecisionsByIdReclamation(String id ) ;
	
	 Decision addDecision( Decision u);
	
	void deleteDecision(String id);
	 Decision updateDecision( Decision u);
	 Decision retrieveDecision(String id);

}
