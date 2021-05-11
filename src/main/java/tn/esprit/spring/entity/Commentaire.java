package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Commentaire")
public class Commentaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comm")
	private int id;
	
	@Column(name = "description" , columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "dateCommentaire", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateCommentaire;
		
	@ManyToOne
	Sujet commSujet;
	
	@ManyToOne
	User commUser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="reactComm")
	private Set<React> commReact;
	
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateCommentaire() {
		return dateCommentaire;
	}


	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public void setCommSujet(Sujet commSujet) {
		this.commSujet = commSujet;
	}


	public User getCommUser() {
		return commUser;
	}


	public void setCommUser(User commUser) {
		this.commUser = commUser;
	}
	
	


	public Set<React> getCommReact() {
		return commReact;
	}


	public void setCommReact(Set<React> commReact) {
		this.commReact = commReact;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	


	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", description=" + description + ", dateCommentaire=" + dateCommentaire
				+ ", commUser=" + commUser + ", commReact=" + commReact + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commSujet == null) ? 0 : commSujet.hashCode());
		result = prime * result + ((commUser == null) ? 0 : commUser.hashCode());
		result = prime * result + ((dateCommentaire == null) ? 0 : dateCommentaire.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commentaire other = (Commentaire) obj;
		if (commSujet == null) {
			if (other.commSujet != null)
				return false;
		} else if (!commSujet.equals(other.commSujet))
			return false;
		if (commUser == null) {
			if (other.commUser != null)
				return false;
		} else if (!commUser.equals(other.commUser))
			return false;
		if (dateCommentaire == null) {
			if (other.dateCommentaire != null)
				return false;
		} else if (!dateCommentaire.equals(other.dateCommentaire))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}


	public Commentaire(String description, Sujet commSujet, User commUser) {
		this.description = description;
		this.commSujet = commSujet;
		this.commUser = commUser;
	}
	
	
	
	
	
	
	
	
	
}
