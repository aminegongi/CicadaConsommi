package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="livraison")

public class Livraison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
		
	private int id_livraison;
		
    private Date dateLivraison;
		
    private float fraisLivraison;
    
    private String adresse;
    
    private String etat_livraison; 
    
    @ManyToOne
    Livreur livreur;
    
    @OneToOne(mappedBy="livraison")
    Commande commande;

	public int getId_livraison() {
		return id_livraison;
	}

	public void setId_livraison(int id_livraison) {
		this.id_livraison = id_livraison;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public float getFraisLivraison() {
		return fraisLivraison;
	}

	public void setFraisLivraison(float fraisLivraison) {
		this.fraisLivraison = fraisLivraison;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getEtat_livraison() {
		return etat_livraison;
	}

	public void setEtat_livraison(String etat_livraison) {
		this.etat_livraison = etat_livraison;
	}





	@Override
	public String toString() {
		return "Livraison [id_livraison=" + id_livraison + ", dateLivraison=" + dateLivraison + ", fraisLivraison="
				+ fraisLivraison + ", adresse=" + adresse + ", etat_livraison=" + etat_livraison + ", livreur="
				+ livreur + "]";
	}

	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
	
	
	
}
	
	