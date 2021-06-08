package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table ;

@Entity
@Table(name="Notification ")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Notif")
	private long id_Notification;
	@Column(name = "date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date Date;
	@Column(name = "Icone")
	private String Icone;
	@Column(name = "description")
	private String Description;
	@Column(name = "lien")
	private String lien ;
	 public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}


	@Enumerated(EnumType.STRING)
	 @Column(name = " State ", nullable = false )
	   private NState State;
	public NState getState() {
		return State;
	}
	public void setState(NState state) {
		State = state;
	}
	
	
	public long getId_Notification() {
		return id_Notification;
	}
	public void setId_Notification(long id_Notification) {
		this.id_Notification = id_Notification;
	}


	@ManyToOne 
	User NotifUser;
	
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getIcone() {
		return Icone;
	}
	public void setIcone(String icone) {
		Icone = icone;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public User getNotifUser() {
		return NotifUser;
	}
	public void setNotifUser(User notifUser) {
		NotifUser = notifUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(String icone, String description, User notifUser) {
		super();
		Icone = icone;
		Description = description;
		NotifUser = notifUser;
		State = NState.Not_Seen;
	}
	
	public Notification(User u, String description, String icone, NState state) {
		// TODO Auto-generated constructor stub
		super();
		this.NotifUser=u ;
		this.Description= description;
		this.Icone =icone ;
		this.State=State ; 
	}
	public Notification(Long notificationIdToBeUpdated, User u, String description, String icone, NState state) {
		// TODO Auto-generated constructor stub
		super();
		this.NotifUser=u ;
		this.Description= description;
		this.Icone =icone ;
		this.State=State ;
		this.NotifUser =u ;
	}
	public Notification(User u, User UC, String description, String icone, NState state) {
		// TODO Auto-generated constructor stub
		super();
		this.NotifUser=u ;
		this.Description= description;
		this.Icone =icone ;
		this.State=State ; 
		this.NotifUser= UC;
		
	}
	public Notification(String icone, String description, String lien, NState state, User notifUser) {
		super();
		Icone = icone;
		Description = description;
		this.lien = lien;
		State = state;
		NotifUser = notifUser;
	}

	
	

	
	
	
	
	
}