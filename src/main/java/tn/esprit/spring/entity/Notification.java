package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private long Id;
	@Column(name = "date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date Date;
	@Column(name = "Icone")
	private String Icone;
	@Column(name = "description")
	private String Description;
	public long getId() {
		return Id;
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
	public void setId(long id) {
		Id = id;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}