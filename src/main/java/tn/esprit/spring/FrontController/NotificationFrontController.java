package tn.esprit.spring.FrontController;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.UserConnected;
import tn.esprit.spring.service.NotifService;
import tn.esprit.spring.service.ReclamationService;
;
@Scope(value = "session")
@Controller(value = "NotificationFrontController")
@ELBeanName(value = "NotificationFrontController")
@Join(path = "/client/NotificationClient", to = "/pages/admin/Notification.jsf")

public class NotificationFrontController {
	private static final Logger L = LogManager.getLogger(NotificationFrontController.class);
	@Autowired
	NotifService NotificationService ;
	@Autowired
	ReclamationService ReclamationService ;
	
	private String Id_Notif;
	private String Icone;
	private String Description;
	private Date Date;
	private List<Notification> notifications;
	
	private String countNotif;

	

	

	@Enumerated(EnumType.STRING)
	 private NState State ;
	
	
	
	
	private Long NotificationIdToBeUpdated;
	
	
	
	
	
	





	public void setReclamationIdToBeUpdated(Long reclamationIdToBeUpdated) {
		NotificationIdToBeUpdated = NotificationIdToBeUpdated;
	}





	//les getters et les setters 

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	
	public static Logger getL() {
		return L;
	}
	// enumeration 
	public NState[] getNStates() { return NState.values(); }
	
	
	// list Affichage 
	
	public NState getState() {
		return State;
	}





	public void setState(NState state) {
		State = state;
	}





	public String getId_Notif() {
		return Id_Notif;
	}





	public void setId_Notif(String id) {
		Id_Notif = id;
	}





	public String getIcone() {
		return Icone;
	}





	public void setIcone(String icone) {
		Icone = icone;
	}





	public Date getDate() {
		return Date;
	}





	public void setDate(Date date) {
		Date = date;
	}





	public Long getNotificationIdToBeUpdated() {
		return NotificationIdToBeUpdated;
	}





	public void setNotificationIdToBeUpdated(Long notificationIdToBeUpdated) {
		NotificationIdToBeUpdated = notificationIdToBeUpdated;
	}


	
	
	//getters et setters de reclamation 
	
	 public List<Notification> getNotifications() {
		 User u = UserConnected.userconnected;
		 if (u == null)
			 return null;
		  notifications = NotificationService.retrieveAllNotificationByIdUser(String.valueOf(u.getId()));
			return notifications;
		}





		public void setNotifications(List<Notification> notifications) {
			this.notifications = notifications;
		}




	//Add Reclamation 
    public void addNotification() {
    	User u = UserConnected.userconnected;
    	NotificationService.addOrUpdateNotification (new Notification (u,Description,Icone,State)) ;
    	}
	
    
 





	//delete
  	public void removeNotification(String NotificationId)
  	{
  		NotificationService.deleteNotification( NotificationId);
  	}
  	
  	public void displayNotification( Notification  Notification)
	{
	this.setDescription( Notification.getDescription());
	this.setIcone( Notification.getIcone());
	this.setDate( Notification.getDate());
	
	this.setState( Notification.getState());
	this.setNotificationIdToBeUpdated( Notification.getId_Notification());
	
	}
	
	public void updateState(String id)
	{ 
		NotificationService.updateadminEtat(NState.Seen, id ); 
	}
	
	
	
	
	public String movetobyidnotif (String  id) {
		this.setId_Notif(id);
		System.err.println("west el fonction --- "+ this.getId_Notif());
		NotificationService.updateadminEtat(NState.Seen, id ); 
		return "/pages/client/NotifClient.jsf?faces-redirect=true" ;
		
		
	 } 
	
	
	
	
	//getnotifbyid
	public Notification showNotification() {
		System.err.println("west show Notif " + this.getId_Notif());
		return	 NotificationService.retrieveNotif(String.valueOf(this.getId_Notif())  )  ;
		     
			 
		
		 }
	
	
	
	
	
	
	





	public String getCountNotif() {
		User u = UserConnected.userconnected;
		if (u == null)
			return "0";
		countNotif = String.valueOf(NotificationService.CountNotificationNot_Seen(u.getId().intValue()));
		return countNotif;
	}

	public void setCountNotif(String countNotif) {
		this.countNotif = countNotif;
	}

    // 
	public void notifToSeen(){
		NotificationService.allNotifSeen();
	}
	 public void rappelNotifNotSeen (){
		 NotificationService.RappelNotification() ;
	 }
	
	
	 public String getlink(Notification n ){
		 NotificationService.updateadminEtat(NState.Seen, String.valueOf(n.getId_Notification()));
		 System.err.println(n.getLien());
		 return n.getLien();
		 
	 }
	

}
