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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Decision")
public class Decision implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Decision")
	private long id_Decision;
	@Column(name = "description")
	private String Description ;
	 @Enumerated(EnumType.STRING)
	 @Column(name = " Type " , nullable = false )
	   private  RDecType Type ;
	@Column(name = " Montant_Bon_Achat")
	private String  Montant_Bon_Achat ;
	@Column(name = "Montant_REPARATION ")
	private String Montant_REPARATION ;
	@Column(name = "Date_limite_REPARATION")
	private  Date  Date_limite_REPARATION;
	@Column(name = "date_validité_BA ")
	private Date date_validité_BA ;
	@Column(name = "Delai_ECHANGE ")
	private Date Delai_ECHANGE ;
	
	
	@JsonIgnore
	@OneToOne
	private Reclamation decision;
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDecision(Reclamation decision) {
		this.decision = decision;
	}

	public Decision() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Decision(String description, RDecType type, String montant_Bon_Achat, String montant_REPARATION,
			Date date_limite_REPARATION, Date date_validité_BA, Date delai_ECHANGE) {
		this.Date_limite_REPARATION=date_limite_REPARATION;
		this.Description=description ;
		this.Type=type;
		this.date_validité_BA= date_validité_BA;
		this.Delai_ECHANGE=delai_ECHANGE;
		this.Montant_Bon_Achat=montant_Bon_Achat;
		this.Montant_REPARATION= montant_REPARATION; 
		// TODO Auto-generated constructor stub
	

		// TODO Auto-generated constructor stub
	}

	public Decision(Reclamation r, RDecType type, String description ,String montant_Bon_Achat, String montant_REPARATION,
			Date date_limite_REPARATION, Date date_validité_BA, Date delai_ECHANGE) {
		this.Date_limite_REPARATION=date_limite_REPARATION;
		this.Description=description ;
		this.Type=type;
		this.date_validité_BA= date_validité_BA;
		this.Delai_ECHANGE=delai_ECHANGE;
		this.Montant_Bon_Achat=montant_Bon_Achat;
		this.Montant_REPARATION= montant_REPARATION;
		// TODO Auto-generated constructor stub
	}

	


	public Decision(RDecType type) {
		this.Type=type;
		// TODO Auto-generated constructor stub
	}

	public Decision(String description, String montant_Bon_Achat, String montant_REPARATION,
			Date date_limite_REPARATION, Date date_validité_BA, Date delai_ECHANGE) {
		this.Date_limite_REPARATION=date_limite_REPARATION;
		this.Description=description ;
	
		this.date_validité_BA= date_validité_BA;
		this.Delai_ECHANGE=delai_ECHANGE;
		this.Montant_Bon_Achat=montant_Bon_Achat;
		this.Montant_REPARATION= montant_REPARATION;
		// TODO Auto-generated constructor stub
	}

	public long getId_Decision() {
		return id_Decision;
	}
	public void setId_Decision(long id_Decision) {
		this.id_Decision = id_Decision;
	}

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMontant_Bon_Achat() {
		return Montant_Bon_Achat;
	}
	public void setMontant_Bon_Achat(String montant_Bon_Achat) {
		Montant_Bon_Achat = montant_Bon_Achat;
	}
	public String getMontant_REPARATION() {
		return Montant_REPARATION;
	}
	public void setMontant_REPARATION(String montant_REPARATION) {
		Montant_REPARATION = montant_REPARATION;
	}
	public Date getDate_limite_REPARATION() {
		return Date_limite_REPARATION;
	}
	public void setDate_limite_REPARATION(Date date_limite_REPARATION) {
		Date_limite_REPARATION = date_limite_REPARATION;
	}
	public Date getDate_validité_BA() {
		return date_validité_BA;
	}
	public void setDate_validité_BA(Date date_validité_BA) {
		this.date_validité_BA = date_validité_BA;
	}
	public Date getDelai_ECHANGE() {
		return Delai_ECHANGE;
	}
	public void setDelai_ECHANGE(Date delai_ECHANGE) {
		Delai_ECHANGE = delai_ECHANGE;
	}

	/*public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}*/

	public Reclamation getDecision() {
		return decision;
	}

	public RDecType getType() {
		return Type;
	}

	public void setType(RDecType type) {
		Type = type;
	}

	

	public User getNotifUser1() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getNotifUser() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
