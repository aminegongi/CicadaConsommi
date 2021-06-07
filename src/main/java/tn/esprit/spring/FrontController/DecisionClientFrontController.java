package tn.esprit.spring.FrontController;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.RDecType;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.RType;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.DecisionService;
import tn.esprit.spring.service.MailService;
import tn.esprit.spring.service.NotifService;
import tn.esprit.spring.service.ReclamationService;
@Scope(value = "session")
@Controller(value = "DecisionClientFrontController")
@ELBeanName(value = "DecisionClientFrontController")
@Join(path = "/client/DecisionClient", to = "/pages/admin/DecisionClient.jsf")

public class DecisionClientFrontController {
	private static final Logger L = LogManager.getLogger(ReclamationFrontController.class);
	@Autowired
	DecisionService deci;
	@Autowired
	ReclamationService rec;
	@Autowired
	MailService mail;
	@Autowired
	NotifService Notif ;
	private long id_Decision;
	
	private String Description ;
	
	
	private String  Montant_Bon_Achat ;

	private String Montant_REPARATION ;

	private  Date  Date_limite_REPARATION;

	private Date date_validité_BA ;
	
	private Date Delai_ECHANGE ;
	private List<Decision> decisions;
	
	private Long idReclamtion ; 
	
    @Enumerated(EnumType.STRING)
	   private  RDecType Type ;
	public RDecType[] getRDecTypes() { return RDecType.values(); }
	public DecisionService getDeci() {
		return deci;
	}
	public void setDeci(DecisionService deci) {
		this.deci = deci;
	}
	public ReclamationService getRec() {
		return rec;
	}
	public void setRec(ReclamationService rec) {
		this.rec = rec;
	}
	public MailService getMail() {
		return mail;
	}
	public void setMail(MailService mail) {
		this.mail = mail;
	}
	public long getId_Decision() {
		return id_Decision;
	}
	public void setId_Decision(long id_Decision) {
		this.id_Decision = id_Decision;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMontant_Bon_Achat() {
		return Montant_Bon_Achat;
	}
	public void setMontant_Bon_Achat(String montant_Bon_Achat) {
		Montant_Bon_Achat = montant_Bon_Achat;
	}
	public String getMontant_REPARATION() {
		return Montant_REPARATION;
	}
	public void setMontant_REPARATION(String montant_REPARATION) {
		Montant_REPARATION = montant_REPARATION;
	}
	public Date getDate_limite_REPARATION() {
		return Date_limite_REPARATION;
	}
	public void setDate_limite_REPARATION(Date date_limite_REPARATION) {
		Date_limite_REPARATION = date_limite_REPARATION;
	}
	public Date getDate_validité_BA() {
		return date_validité_BA;
	}
	public void setDate_validité_BA(Date date_validité_BA) {
		this.date_validité_BA = date_validité_BA;
	}
	public Date getDelai_ECHANGE() {
		return Delai_ECHANGE;
	}
	public void setDelai_ECHANGE(Date delai_ECHANGE) {
		Delai_ECHANGE = delai_ECHANGE;
	}
	public RDecType getType() {
		return Type;
	}
	public void setType(RDecType type) {
		Type = type;
	}
	public static Logger getL() {
		return L;
	}
	public List<Decision> getDecisions() {
		decisions =deci.retrieveAllVDecisions() ;
		return decisions;
	}
	public void setDecisions(List<Decision> decisions) {
		this.decisions = decisions;
	}
	

	
	
	public Long getIdReclamtion() {
		return idReclamtion;
	}
	public void setIdReclamtion(Long idReclamtion) {
		this.idReclamtion = idReclamtion;
	}
	public String movetobyid (Long id) {
		this.setIdReclamtion(id);
		System.err.println("west el fonction --- "+ this.getIdReclamtion());
		return "/pages/client/DecisionClient.jsf?faces-redirect=true" ;
		
		
	 } 
	
	public List<Decision> getdec(String id){
		List<Decision> d = new ArrayList<>() ;
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParams = context.getExternalContext().getRequestParameterMap();
		String idn = (String) requestParams.get("idn");
		
	     System.err.println(idn);
	     Notif.updateadminEtat(NState.Seen, idn);
		d.add( deci.retrieveDecision(id) );
		return d ;
	}
	
	 
	
	public List <Decision> showDecision () {
		System.err.println("west show DEci ");
		return	 deci.retrieveAllDecisionsByIdReclamation(String.valueOf(this.getIdReclamtion())); 
			 
			 
		 }
	

	
	}
	
	
	 

