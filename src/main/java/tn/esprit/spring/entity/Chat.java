package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Chat")
public class Chat {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_chat")
	private int id;
	
	@Column(name = "dateEnvoi", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateEnvoi;
		
	@ManyToOne
	User senderUser;
	
	@ManyToOne
	User receiverUser;
	
	@Column(name = "description" , columnDefinition = "TEXT")
	private String description;

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chat(User senderUser, User receiverUser, String description) {
		super();
		this.senderUser = senderUser;
		this.receiverUser = receiverUser;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public User getSenderUser() {
		return senderUser;
	}

	public void setSenderUser(User senderUser) {
		this.senderUser = senderUser;
	}

	public User getReceiverUser() {
		return receiverUser;
	}

	public void setReceiverUser(User receiverUser) {
		this.receiverUser = receiverUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", dateEnvoi=" + dateEnvoi + ", senderUser=" + senderUser + ", receiverUser="
				+ receiverUser + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	
}
