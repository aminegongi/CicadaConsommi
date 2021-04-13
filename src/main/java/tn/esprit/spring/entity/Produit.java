package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name= "Produit")
public class Produit  implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private long id_produit;
	private long ref_produit;
	private String nom_produit;
	private String img_produit;
	private float prix_produit;
	private String marque_produit;
	private String codeBarre_produit;
	private Date dateExpiration_produit;
	private Date dateFabrication_produit;
	private Date dateAjout_produit;
	private String Description_produit;
	private String Tab_produit;
	public Produit(long id_produit, long ref_produit, String nom_produit, String img_produit, float prix_produit,
			String marque_produit, String codeBarre_produit, Date dateExpiration_produit, Date dateFabrication_produit,
			Date dateAjout_produit, String description_produit, String tab_produit) {
		super();
		this.id_produit = id_produit;
		this.ref_produit = ref_produit;
		this.nom_produit = nom_produit;
		this.img_produit = img_produit;
		this.prix_produit = prix_produit;
		this.marque_produit = marque_produit;
		this.codeBarre_produit = codeBarre_produit;
		this.dateExpiration_produit = dateExpiration_produit;
		this.dateFabrication_produit = dateFabrication_produit;
		this.dateAjout_produit = dateAjout_produit;
		Description_produit = description_produit;
		Tab_produit = tab_produit;
	}
	public Produit(long ref_produit, String nom_produit, String img_produit, float prix_produit, String marque_produit,
			String codeBarre_produit, Date dateExpiration_produit, Date dateFabrication_produit, Date dateAjout_produit,
			String description_produit, String tab_produit) {
		super();
		this.ref_produit = ref_produit;
		this.nom_produit = nom_produit;
		this.img_produit = img_produit;
		this.prix_produit = prix_produit;
		this.marque_produit = marque_produit;
		this.codeBarre_produit = codeBarre_produit;
		this.dateExpiration_produit = dateExpiration_produit;
		this.dateFabrication_produit = dateFabrication_produit;
		this.dateAjout_produit = dateAjout_produit;
		Description_produit = description_produit;
		Tab_produit = tab_produit;
	}
	public Produit() {
		super();
	}
	public long getId_produit() {
		return id_produit;
	}
	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}
	public long getRef_produit() {
		return ref_produit;
	}
	public void setRef_produit(long ref_produit) {
		this.ref_produit = ref_produit;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public String getImg_produit() {
		return img_produit;
	}
	public void setImg_produit(String img_produit) {
		this.img_produit = img_produit;
	}
	public float getPrix_produit() {
		return prix_produit;
	}
	public void setPrix_produit(float prix_produit) {
		this.prix_produit = prix_produit;
	}
	public String getMarque_produit() {
		return marque_produit;
	}
	public void setMarque_produit(String marque_produit) {
		this.marque_produit = marque_produit;
	}
	public String getCodeBarre_produit() {
		return codeBarre_produit;
	}
	public void setCodeBarre_produit(String codeBarre_produit) {
		this.codeBarre_produit = codeBarre_produit;
	}
	public Date getDateExpiration_produit() {
		return dateExpiration_produit;
	}
	public void setDateExpiration_produit(Date dateExpiration_produit) {
		this.dateExpiration_produit = dateExpiration_produit;
	}
	public Date getDateFabrication_produit() {
		return dateFabrication_produit;
	}
	public void setDateFabrication_produit(Date dateFabrication_produit) {
		this.dateFabrication_produit = dateFabrication_produit;
	}
	public Date getDateAjout_produit() {
		return dateAjout_produit;
	}
	public void setDateAjout_produit(Date dateAjout_produit) {
		this.dateAjout_produit = dateAjout_produit;
	}
	public String getDescription_produit() {
		return Description_produit;
	}
	public void setDescription_produit(String description_produit) {
		Description_produit = description_produit;
	}
	public String getTab_produit() {
		return Tab_produit;
	}
	public void setTab_produit(String tab_produit) {
		Tab_produit = tab_produit;
	}
	
	
	
}
