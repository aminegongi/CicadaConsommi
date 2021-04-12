package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="React")
public class React {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_react")
	private int id;
	
	@Column(name = "type")
	private int type; //0: dislike 1:like 2:j'adore  3:soutenir
	
	@ManyToOne
	Commentaire reactComm;
	
	@ManyToOne
	User reactUser;

	public React() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	public Commentaire getReactComm() {
		return reactComm;
	}

	public void setReactComm(Commentaire reactComm) {
		this.reactComm = reactComm;
	}

	public User getReactUser() {
		return reactUser;
	}

	public void setReactUser(User reactUser) {
		this.reactUser = reactUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "React [id=" + id + ", type=" + type + ", reactComm=" + reactComm + ", reactUser=" + reactUser + "]";
	}
	
	
	

}
