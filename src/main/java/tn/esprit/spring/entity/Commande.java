package tn.esprit.spring.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import tn.esprit.spring.entity.Produit;


@Entity
@Table(name="commande")

public class Commande implements Serializable {

	public Set<Produit_Commandes> getP_cmd() {
		return P_cmd;
	}

	public void setP_cmd(Set<Produit_Commandes> p_cmd) {
		P_cmd = p_cmd;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
		
	private int id_commande;
	
	@Column(name = "dateCommande", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCommande;
		
    private String modePaiement;
    
    private String etat_commande;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="commande")
	private Set<Produit_Commandes> P_cmd;
	
    @OneToOne
    Livraison livraison;
    
    @ManyToOne
    User user;

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getEtat_commande() {
		return etat_commande;
	}

	public void setEtat_commande(String etat_commande) {
		this.etat_commande = etat_commande;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", dateCommande=" + dateCommande + ", modePaiement="
				+ modePaiement + ", etat_commande=" + etat_commande + ", livraison=" + livraison + "]";
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
    
    
    
    
    

    
   
	
	
	
	
	