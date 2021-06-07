package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="category")
public class Category implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id ;

private String name ;

@ManyToOne
protected Rayon rayon;

/*@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
private List<Product> product;*/


public Category() {
	super();
	
}


public Category(int id, String name , Rayon rayon) {
	super();
	this.id = id;
	this.name = name;
	this.rayon= rayon;
}

	
public Category(String name, Rayon rayon) {
	super();
	this.name = name;
	this.rayon = rayon;
}



@Override
public String toString() {
	return "Category [id=" + id + ", Name=" + name +", rayon=" + rayon + "]";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



/*public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}*/



public Rayon getRayon() {
	return rayon;
}

public void setRayon(Rayon rayon) {
	this.rayon = rayon;
}




}
