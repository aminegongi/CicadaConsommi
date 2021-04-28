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
	private long id_reclamation;
	@Column(name = "titre")
	private String Titre;
	@Column(name = "Image")
	private String Image;
	@Column(name = "description")
	private String Description;
	@Column(name = "datePublication", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date DatePublication;
	@Column(name = " Decision ")
	private String Decision ;
	 @Enumerated(EnumType.STRING)
	 @Column(name = " State ", nullable = false )
	   private RState State;
	 @Enumerated(EnumType.STRING)
	 @Column(name = " Type " , nullable = false )
	   private  RType Type ;
	
	@ManyToOne 
	User reclamationUser;

	


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

	public long getId_reclamation() {
		return id_reclamation;
	}

	public void setId_reclamation(long id_reclamation) {
		this.id_reclamation = id_reclamation;
	}

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
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
