package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;





@Entity
public class Stock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	
	private int amount;
	private int qtee;
	private int qtes;
	@OneToOne
	private Produit p;
	
	
	/*@JsonIgnore
	@OneToMany( mappedBy="stock",cascade = CascadeType.ALL)
	private List<Product> product;*/

	

	
	

	public Stock() {
		super();
	}
	
	
	
	
	public Stock(int amount, int qtee, int qtes) {
		super();
		this.amount = amount;
		this.qtee = qtee;
		this.qtes = qtes;
	}




	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

	/*public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}*/
	
	

	public int getId() {
		return id;
	}

	public int getQtee() {
		return qtee;
	}

	public void setQtee(int qtee) {
		this.qtee = qtee;
	}

	public int getQtes() {
		return qtes;
	}

	public void setQtes(int qtes) {
		this.qtes = qtes;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Stock [amount=" + amount + ", entry_date=" + qtee + ", exit_date=" + qtes + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Produit getP() {
		return p;
	}




	public void setP(Produit p) {
		this.p = p;
	}
	
	
	

}

