package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private Long id_reclamation;
	@Column(name = "titre")
	private String Titre;
	@Column(name = "Image")
	private String Image;
	@Column(name = "description")
	private String Description;
	@Column(name = "datePublication", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date DatePublication;
	/*@Column(name = " Decision ")
	private String Decision ;*/
	 @Enumerated(EnumType.STRING)
	 @Column(name = " State ", nullable = false )
	   private RState State;
	 @Enumerated(EnumType.STRING)
	 @Column(name = " Type " , nullable = false )
	   private  RType Type ;
	
	@ManyToOne 
	User reclamationUser;
	
	
	@OneToOne (mappedBy="decision")
	private Decision Reclamationdecision  ;

	



	public Decision getReclamationdecision() {
		return Reclamationdecision;
	}

	public void setReclamationdecision(Decision reclamationdecision) {
		Reclamationdecision = reclamationdecision;
	}

	public RState getState() {
		return State;
	}

	public void setState(RState state) {
		State = state;
	}

	public RType getType() {
		return Type;
	}

	public void setType(RType type) {
		Type = type;
	}

	public Long  getId_reclamation() {
		return id_reclamation;
	}

	public void setId_reclamation(long id_reclamation) {
		this.id_reclamation = id_reclamation;
	}

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reclamation(String titre2, String image2, String description2, RState state2,
			RType type2) {
		// TODO Auto-generated constructor stub
	}

	
	public Reclamation (Long  id , User u, String Titre, String Description, String image, RState state, RType type) {
			super();
			this.id_reclamation = id;
			this.Titre = Titre;
			this.Description = Description;
			this.Image = image;
			this.State = state;
			this.Type = type;
			this.reclamationUser = u ;
			
			}
	public Reclamation ( User u, String Titre, String Description, String image, RState state, RType type) {
			super();
			
			this.Titre = Titre;
			this.Description = Description ;
			this.Image = image;
			this.State = state;
			this.Type = type;
			this.reclamationUser = u ;
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


	/*public String getDecision() {
		return Decision;
	}

	public void setDecision(String decision) {
		Decision = decision;
	}*/

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
