package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author MSI
 *
 */
@Entity
@Table(name="Reclamation")

public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reclamation")
	private long Id;
	@Column(name = "type")
	private String  type; //0: fonctionnement de l'application  1:Produit 2:livraison
	@Column(name = "titre")
	private String Titre;
	@Column(name = "Image")
	private String Image;
	@Column(name = "description")
	private String Description;
	@Column(name = "datePublication", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date DatePublication;
	@Column(name = "état")
	private String Etat; //0:Non traité   1:en cours de traintement  2:Traité 
	@Column(name = " Decision ")
	private String Decision ;
	
	@ManyToOne 
	User reclamationUser;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDatePublication() {
		return DatePublication;
	}

	public void setDatePublication(Date datePublication) {
		DatePublication = datePublication;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public String getDecision() {
		return Decision;
	}

	public void setDecision(String decision) {
		Decision = decision;
	}

	public User getReclamationUser() {
		return reclamationUser;
	}

	public void setReclamationUser(User reclamationUser) {
		this.reclamationUser = reclamationUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	

}
