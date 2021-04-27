package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SujetRecherche")
public class SujetRecherche {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "nombre",columnDefinition = "integer default 0")
	private int nombre;
	
	@ManyToOne
	User rechercheSujetUser;

	public SujetRecherche() {
		super();
	}

	public SujetRecherche(int id, String tag, int nombre, User rechercheSujetUser) {
		super();
		this.id = id;
		this.tag = tag;
		this.nombre = nombre;
		this.rechercheSujetUser = rechercheSujetUser;
	}
	
	
	public SujetRecherche(String tag, User rechercheSujetUser) {
		super();
		this.tag = tag;
		this.rechercheSujetUser = rechercheSujetUser;
	}

	public User getRechercheSujetUser() {
		return rechercheSujetUser;
	}

	public void setRechercheSujetUser(User rechercheSujetUser) {
		this.rechercheSujetUser = rechercheSujetUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "SujetRecherche [id=" + id + ", tag=" + tag + ", nombre=" + nombre + "]";
	}
		
}
