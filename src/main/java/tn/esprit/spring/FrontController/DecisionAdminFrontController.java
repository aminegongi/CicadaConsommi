package tn.esprit.spring.FrontController;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import tn.esprit.spring.service.UserService;

@Scope(value = "session")
@Controller(value = "DecisionAdminFrontController")
@ELBeanName(value = "DecisionAdminFrontController")
@Join(path = "/client/DecisionAdmin", to = "/pages/admin/DecisionAdmin.jsf")

public class DecisionAdminFrontController {
	private static final Logger L = LogManager.getLogger(ReclamationFrontController.class);
	@Autowired
	DecisionService deci;
	@Autowired
	ReclamationService rec;
	@Autowired
	MailService mail;
	@Autowired
	NotifService Notif ;
	@Autowired
	UserService user ;
	
	private long id_Decision;

	private String Description;

	private String Montant_Bon_Achat;

	private String Montant_REPARATION;

	private Date Date_limite_REPARATION;

	private Date date_validité_BA;

	private Date Delai_ECHANGE;
	private List<Decision> decisions;

	@Enumerated(EnumType.STRING)
	private RDecType Type;
	
	private Long idReclamtion ; 
	
	

	public Long getIdReclamtion() {
		return idReclamtion;
	}

	public void setIdReclamtion(Long idReclamtion) {
		this.idReclamtion = idReclamtion;
	}

	public RDecType[] getRDecTypes() {
		return RDecType.values();
	}

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
// 1$ --> 2,7 Dt 
// 1000dt --> 370 $
	public List<Decision> getDecisions() {
		decisions = deci.retrieveAllVDecisions();
		return decisions;
	}

	public void setDecisions(List<Decision> decisions) {
		this.decisions = decisions;
	}

	public void addDecision() {
		System.err.println("west el fonction add ou hetha id reclamation --- " + this.getIdReclamtion()) ;
		Decision de = new Decision(Description ,Type ,Montant_Bon_Achat, Montant_REPARATION, Date_limite_REPARATION,
				date_validité_BA, Delai_ECHANGE);
		de.setDecision(rec.retrieveReclamation(String.valueOf(this.getIdReclamtion())));
		de.setType(RDecType.Repayment);
		Decision d = deci.addDecision(de);
		rec.updateadminEtat(RState.Etat_Traité, Long.toString(d.getDecision().getId_reclamation()));
		Notification n = new Notification("decision.jpg", "Decision "+d.getType(),"/pages/client/DecisionClientnotif.jsf?id="+d.getId_Decision(),NState.Not_Seen,d.getDecision().getReclamationUser());
		System.err.println(" nn " + n.getId_Notification() + n.getLien() + "__");
		Notif.addNotification(n);
		mail.sendEmail("zeinebbl327@gmail.com", d.getDecision().getReclamationUser().getEmail(),
				"Traitement de votre réclamation", "Votre Reclamation : " + d.getDecision().getTitre() 
						+ " a été traité , "
						+ " decision de type : " + d.getType() 
						+ " description : " + d.getDescription() 
						+ " voir plus de details de  decision dans le site Consommi tounsi s'il vous plait :* ");

	}
	public void addDecisionEchange() {
		System.err.println("west el fonction add ou hetha id reclamation --- " + this.getIdReclamtion()) ;
		Decision de = new Decision(Description ,Type ,Montant_Bon_Achat, Montant_REPARATION, Date_limite_REPARATION,
				date_validité_BA, Delai_ECHANGE);
		de.setDecision(rec.retrieveReclamation(String.valueOf(this.getIdReclamtion())));
		de.setType(RDecType.Exchange);
		Decision d = deci.addDecision(de);
		rec.updateadminEtat(RState.Etat_Traité, Long.toString(d.getDecision().getId_reclamation()));
		Notification n = new Notification("decision.jpg", "Decision "+d.getType(),"/pages/client/DecisionClientnotif.jsf?id="+d.getId_Decision(),NState.Not_Seen,d.getDecision().getReclamationUser());
		System.err.println(" nn " + n.getId_Notification() + n.getLien() + "__");
		Notif.addNotification(n);
		mail.sendEmail("zeinebbl327@gmail.com", d.getDecision().getReclamationUser().getEmail(),
				"Traitement de votre réclamation", "Votre Reclamation : " + d.getDecision().getTitre() 
						+ " a été traité , "
						+ " decision de type : " + d.getType() 
						+ " description : " + d.getDescription() 
						+ " voir plus de details de  decision dans le site Consommi tounsi s'il vous plait :* ");
	}
	public void addDecisionReparation() {
		System.err.println("west el fonction add ou hetha id reclamation --- " + this.getIdReclamtion()) ;
		Decision de = new Decision(Description ,Type ,Montant_Bon_Achat, Montant_REPARATION, Date_limite_REPARATION,
				date_validité_BA, Delai_ECHANGE);
		de.setDecision(rec.retrieveReclamation(String.valueOf(this.getIdReclamtion())));
		de.setType(RDecType.Repair);
		Decision d = deci.addDecision(de);
		rec.updateadminEtat(RState.Etat_Traité, Long.toString(d.getDecision().getId_reclamation()));
		Notification n = new Notification("decision.jpg", "Decision "+d.getType(),"/pages/client/DecisionClientnotif.jsf?id="+d.getId_Decision(),NState.Not_Seen,d.getDecision().getReclamationUser());
		System.err.println(" nn " + n.getId_Notification() + n.getLien() + "__");
		Notif.addNotification(n);
		mail.sendEmail("zeinebbl327@gmail.com", d.getDecision().getReclamationUser().getEmail(),
				"Traitement de votre réclamation", "Votre Reclamation : " + d.getDecision().getTitre() 
						+ " a été traité , "
						+ " decision de type : " + d.getType() 
						+ " description : " + d.getDescription() 
						+ " voir plus de details de  decision dans le site Consommi tounsi s'il vous plait :* ");
	}

	public String movetobyid(Long id) {
		this.setIdReclamtion(id);

		
		System.err.println("west el fonction --- " + this.getIdReclamtion()  );
		return "/template/Back/DecisionAdmin.xhtml?faces-redirect=true";

	}
	
	public String movetobyidEchange(Long id) {
		this.setIdReclamtion(id);

		
		System.err.println("west el fonction --- " + this.getIdReclamtion()  );
		return "/template/Back/DecisionAdminEchange.xhtml?faces-redirect=true";

	}
	public String movetobyidRepair(Long id) {
		this.setIdReclamtion(id);

		
		System.err.println("west el fonction --- " + this.getIdReclamtion()  );
		return "/template/Back/DecisionAdminRepair.xhtml?faces-redirect=true";

	}
	public void removeDecison(String DecisionId)
  	{
		Decision d = deci.retrieveDecision(DecisionId);
	rec.updateadminEtat(RState.Etat_NoN_Traité, String.valueOf(d.getDecision().getId_reclamation())); 
  	deci.deleteDecision(DecisionId);
  	}

}
