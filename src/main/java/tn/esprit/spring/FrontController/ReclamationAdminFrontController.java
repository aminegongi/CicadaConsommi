package tn.esprit.spring.FrontController;


import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.RType;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.NotifService;
import tn.esprit.spring.service.ReclamationService;
import tn.esprit.spring.service.UserService;
@Scope(value = "session")
@Controller(value = "ReclamationAdminFrontController")
@ELBeanName(value = "ReclamationAdminFrontController")
@Join(path = "/client/ReclamationAdmin", to = "/pages/admin/ReclamationAdmin.jsf")

public class ReclamationAdminFrontController {
	private static final Logger L = LogManager.getLogger(ReclamationFrontController.class);
	@Autowired
	ReclamationService ReclamationService ;
	@Autowired
	NotifService Notif ;
	@Autowired
	UserService user ;
	
	
	private String Titre;
	private String Image;
	private String Description;
	private Date DatePublication;
	private List<Reclamation> searchReclamations;
	

	 public Date getDatePublication() {
		return DatePublication;
	}





	public void setDatePublication(Date datePublication) {
		DatePublication = datePublication;
	}

	@Enumerated(EnumType.STRING)
	 private RState State;
	 @Enumerated(EnumType.STRING)
	 private  RType Type ;
	public String getTitre() {
		return Titre;
	}
	
	
	private Long ReclamationIdToBeUpdated;
	
	
	
	
	
	public Long getReclamationIdToBeUpdated() {
		return ReclamationIdToBeUpdated;
	}





	public void setReclamationIdToBeUpdated(Long reclamationIdToBeUpdated) {
		ReclamationIdToBeUpdated = reclamationIdToBeUpdated;
	}





	//les getters et les setters 
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public RState getState() {
		return State;
	}
	public void setState(RState state) {
		State = state;
	}
	public RType getType() {
		return Type;
	}
	public void setType(RType type) {
		Type = type;
	}
	public static Logger getL() {
		return L;
	}
	// enumeration 
	public RState[] getRStates() { return RState.values(); }
	public RType[] getRTypes() { return RType.values(); }
	// list Affichage 
	
	private List<Reclamation> reclamations;
	
	//getters et setters de reclamation 
	public List<Reclamation> getReclamations() {
		
		reclamations = ReclamationService.retrieveAllReclamations();
		return reclamations ;
	}


    
	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	
	public void updateState(String id)
	{ 
		ReclamationService.updateadminEtat(RState.Etat_encours_de_Traitement, id ); 

	}
	

	
	}
	
	
	 

