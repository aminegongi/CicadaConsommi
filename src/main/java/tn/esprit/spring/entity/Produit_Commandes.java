package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Produit_Commandes")
public class Produit_Commandes implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private long id_Produit_Cmd ;
	@ManyToOne 
		private Produit produit;
	@ManyToOne 
		private Commande commande;
	private long Qte ;
	public Produit_Commandes(long id_Produit_Cmd, Produit produit, Commande commande, long qte) {
		super();
		this.id_Produit_Cmd = id_Produit_Cmd;
		this.produit = produit;
		this.commande = commande;
		Qte = qte;
	}
	public Produit_Commandes() {
		super();
	}
	public long getId_Produit_Cmd() {
		return id_Produit_Cmd;
	}
	public void setId_Produit_Cmd(long id_Produit_Cmd) {
		this.id_Produit_Cmd = id_Produit_Cmd;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public long getQte() {
		return Qte;
	}
	public void setQte(long qte) {
		Qte = qte;
	}
	
	
	
}
