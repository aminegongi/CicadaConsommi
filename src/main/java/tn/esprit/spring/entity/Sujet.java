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
@Table(name = "Sujet")
public class Sujet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sujet")
	private int id;

	@Column(name = "titre")
	private String Titre;

	@Column(name = "description" , columnDefinition = "TEXT")
	private String description;

	@Column(name = "datePublication", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date datePublication;

	@ManyToOne
	User sujetUser;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commSujet")
	private Set<Commentaire> sujetComms;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ratingSujet")
	private Set<Rating> sujetRating;

	
	
	
	public Sujet(String titre, String description, User sujetUser) {
		super();
		Titre = titre;
		this.description = description;
		this.sujetUser = sujetUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Commentaire> getSujetComms() {
		return sujetComms;
	}

	public void setSujetComms(Set<Commentaire> sujetComms) {
		this.sujetComms = sujetComms;
	}

	public Set<Rating> getSujetRating() {
		return sujetRating;
	}

	public void setSujetRating(Set<Rating> sujetRating) {
		this.sujetRating = sujetRating;
	}

	@Override
	public String toString() {
		return "Sujet [id=" + id + ", Titre=" + Titre + ", description=" + description + ", datePublication="
				+ datePublication + ", sujetUser=" + sujetUser + ", sujetComms=" + sujetComms + ", sujetRating="
				+ sujetRating + "]";
	}

	public User getSujetUser() {
		return sujetUser;
	}

	public void setSujetUser(User sujetUser) {
		this.sujetUser = sujetUser;
	}

	public Sujet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Titre == null) ? 0 : Titre.hashCode());
		result = prime * result + ((datePublication == null) ? 0 : datePublication.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((sujetUser == null) ? 0 : sujetUser.hashCode());
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
		Sujet other = (Sujet) obj;
		if (Titre == null) {
			if (other.Titre != null)
				return false;
		} else if (!Titre.equals(other.Titre))
			return false;
		if (datePublication == null) {
			if (other.datePublication != null)
				return false;
		} else if (!datePublication.equals(other.datePublication))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (sujetUser == null) {
			if (other.sujetUser != null)
				return false;
		} else if (!sujetUser.equals(other.sujetUser))
			return false;
		return true;
	}

	public Sujet(int id, String titre, String description, User sujetUser) {
		super();
		this.id = id;
		Titre = titre;
		this.description = description;
		this.sujetUser = sujetUser;
	}

	

}
