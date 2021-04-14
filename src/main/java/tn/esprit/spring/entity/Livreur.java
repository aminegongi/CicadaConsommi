package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="livreur")
public class Livreur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
		
	private int id;
		
	private String firstName;
	
	private String lastName;
	
	private String mail;
	
	private long tel;
	
	private float prime;
	
	@Column(name="livreur_dispo")	
	private int dispo;

	@Column(name="poids_max_livreur")
	private int poids_max;
	
	@Column(name="position_livreur_longitude")
	//private Position position;
	private int pos_longitude;
	
	@Column(name="position_livreur_lalitude")
	private int pos_laltitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public int getDispo() {
		return dispo;
	}

	public void setDispo(int dispo) {
		this.dispo = dispo;
	}

	public int getPoids_max() {
		return poids_max;
	}

	public void setPoids_max(int poids_max) {
		this.poids_max = poids_max;
	}

	public int getPos_longitude() {
		return pos_longitude;
	}

	public void setPos_longitude(int pos_longitude) {
		this.pos_longitude = pos_longitude;
	}

	public int getPos_laltitude() {
		return pos_laltitude;
	}

	public void setPos_laltitude(int pos_laltitude) {
		this.pos_laltitude = pos_laltitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Livreur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "Livreur [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + ", tel="
				+ tel + ", prime=" + prime + ", dispo=" + dispo + ", poids_max=" + poids_max + ", pos_longitude="
				+ pos_longitude + ", pos_laltitude=" + pos_laltitude + "]";
	}
	
	
	
	
}
