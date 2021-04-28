package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	@Autowired
	ReclamationRepository ReclamationRepository ;
	@Autowired
	MailService mail;
	NotifService notif ; 
	
	
   

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
		//Reclamation r = retrieveReclamation( Long.toString(u.getId_reclamation())) ;
		
	
		// mail.sendEmail("zeinebbl327@gmail.com ","zeinebbl327@gmail.com","New claim a9ra hedhi "+ u.getId_reclamation()  , "New claim By "+ r.getReclamationUser().getUsername() +"Mail :" +r.getReclamationUser().getEmail());
		return u ; 
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
// search reclamation by etat //
	@Override
	public List<Reclamation> search(String keyword) {
		// TODO Auto-generated method stub
		return ReclamationRepository.findReclamationByEtat(keyword);
	}
// update admin by etat // 

	@Override
	public String updateadminEtat(RState u, String id) {
		// !!!!!!!!! if User.role =admin !!!!!!!!!!!!! //
	
		ReclamationRepository.updateStateById(u,Long.parseLong(id) ) ;
		return "update ok" ;
	}
	// update decision by admin + update Etat + sent Mail //

	@Override
	public String updateadminDecision(String u, String id) {
		// !!!!!!!!!! if User.role =admin !!!!!!!!!! //
		updateadminEtat(RState.Etat_Traité, id);
		ReclamationRepository.updateDecisionById(u, Long.parseLong(id));
		Reclamation r = retrieveReclamation(id) ; 
		mail.sendEmail("zeinebbl327@gmail.com",r.getReclamationUser().getEmail(),"Traitement de reclamation","Votre Reclamation :" + r.getTitre() + "a été traité , voir la decision dans le site Consommi tounsi s'il vous plait :* ");


		//ki howa yekteb decision tebadel etat Traité et yetab3eth mail lil client 
		
		
		return " Decision prise  + Etat traité + mail envoyé " ;
	 }

	@Override
	public List<Reclamation> retrieveAllReclamationsByIdUser(String id) {
		// TODO Auto-generated method stub
		return ReclamationRepository.findReclamationByUserId(Long.parseLong(id));
	}	

}
