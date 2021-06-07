package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.DecisionService;
import tn.esprit.spring.service.MailService;
import tn.esprit.spring.service.ReclamationService;

@RestController  
@RequestMapping("/client/decision")
public class DecisionController {

	@Autowired
	DecisionService deci;
	@Autowired
	ReclamationService rec;
	@Autowired
	MailService mail;
	

	@PostMapping("/add/{idr}")
	@ResponseBody
	private Decision addDecision(@RequestBody Decision de , @PathVariable("idr") String idr) {
		de.setDecision(rec.retrieveReclamation(idr));
		Decision d = deci.addDecision(de);
		rec.updateadminEtat(RState.Etat_Traité, Long.toString(d.getDecision().getId_reclamation()));
		mail.sendEmail("zeinebbl327@gmail.com",d.getDecision().getReclamationUser().getEmail(),"Traitement de votre réclamation","Votre Reclamation : " + d.getDecision().getTitre() + " a été traité , voir la decision dans le site Consommi tounsi s'il vous plait :* ");
		return d;
	}
	@GetMapping("/getAll")  
	@ResponseBody
	private List<Decision> getAllDecisions()   
	{  
		return deci.retrieveAllVDecisions();  
	}  
	@GetMapping("/getbyreclamation/{Reclamationid}")  
	@ResponseBody
	private List<Decision> getAllDecisions(@PathVariable("Reclamationid") String ReclamationDecisionid)   
	{  
		return deci.retrieveAllDecisionsByIdReclamation(ReclamationDecisionid);  
	} 
	@DeleteMapping("/delete/{Decisionid}")
	@ResponseBody
	private void deleteDecision(@PathVariable("Decisionid") String Decisionid) {
		deci.deleteDecision(Decisionid);
	}
	@PutMapping("/update")
	@ResponseBody
	private Decision updateDecision(@RequestBody Decision Decisions) {
		deci.updateDecision(Decisions);
		return Decisions;
	}
	@GetMapping("/get/{Decisionid}")
	@ResponseBody
	private Decision getReclamation(@PathVariable("Decisionid") String Decisionid) {
		return deci.retrieveDecision(Decisionid);
	}
}
