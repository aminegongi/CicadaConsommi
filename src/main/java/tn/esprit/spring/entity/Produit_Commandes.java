package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Produit")
public class Produit_Commandes implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private long id_Produit_Cmd ;
		
}
