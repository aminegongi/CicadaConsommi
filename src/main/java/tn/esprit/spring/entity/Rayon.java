package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Table(name="rayon")

public class Rayon implements Serializable {
	
	
	/*public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id ;
	
private String Type;

@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
private Set<Category> category;


public Rayon() {
	super();
}

public Rayon(int id)
{
	super();
    this.id =id;
}



public Rayon(int id, Set<Category> category) {
	super();
	this.id = id;
	this.category = category;
}

public Rayon(String type, Set<Category> category) {
	super();
	Type = type;
	this.category = category;
}


public Rayon(int id, String type, Set<Category> category) {
	super();
	this.id = id;
	Type = type;
	this.category = category;
}



public Rayon(int id ,String type/*,Category category*/) {
	super();
	this.Type = type;
	/*this.category=category;*/
}
public int getId() {
	return id;
}
public String getType() {
	return Type;
}

public void setId(int id) {
	this.id = id;
}

public void setType(String type) {
	this.Type = type;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}







}