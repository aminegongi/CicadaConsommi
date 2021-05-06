package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rating")
	private int id;
	
	@Column(name = "nombre")
	private float nombre;
	
	@ManyToOne
	Sujet ratingSujet;
	
	@ManyToOne
	User ratingUser;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getNombre() {
		return nombre;
	}

	public void setNombre(float nombre) {
		this.nombre = nombre;
	}

	public void setRatingSujet(Sujet ratingSujet) {
		this.ratingSujet = ratingSujet;
	}

	public User getRatingUser() {
		return ratingUser;
	}

	public void setRatingUser(User ratingUser) {
		this.ratingUser = ratingUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", nombre=" + nombre + ", ratingUser=" + ratingUser
				+ "]";
	}

	public Rating(float nombre, Sujet ratingSujet, User ratingUser) {
		super();
		this.nombre = nombre;
		this.ratingSujet = ratingSujet;
		this.ratingUser = ratingUser;
	}

	public Rating(int id, float nombre, Sujet ratingSujet, User ratingUser) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ratingSujet = ratingSujet;
		this.ratingUser = ratingUser;
	}
	
	
	
	

}
