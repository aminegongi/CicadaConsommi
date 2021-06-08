package tn.esprit.spring.FrontController;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.RType;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.UserConnected;
import tn.esprit.spring.service.NotifService;
import tn.esprit.spring.service.ReclamationService;
import tn.esprit.spring.service.UserService;
@Scope(value = "session")
@Controller(value = "ReclamationAddFrontController")
@ELBeanName(value = "ReclamationAddFrontController")
@Join(path = "/client/ReclamationClient/add", to = "/pages/client/Reclamation.jsf")

public class ReclamationFrontController {
	private static final Logger L = LogManager.getLogger(ReclamationFrontController.class);
	@Autowired
	ReclamationService ReclamationService ;
	@Autowired
	NotifService Notif ;
	@Autowired
	UserService user ;
	
	
	private String Titre;
	private String Image;
	private String Description;
	private Date DatePublication;
	

	 public Date getDatePublication() {
		return DatePublication;
	}





	public void setDatePublication(Date datePublication) {
		DatePublication = datePublication;
	}

	@Enumerated(EnumType.STRING)
	 private RState State;
	 @Enumerated(EnumType.STRING)
	 private  RType Type ;
	public String getTitre() {
		return Titre;
	}
	
	
	private Long ReclamationIdToBeUpdated;
	
	
	
	
	
	public Long getReclamationIdToBeUpdated() {
		return ReclamationIdToBeUpdated;
	}





	public void setReclamationIdToBeUpdated(Long reclamationIdToBeUpdated) {
		ReclamationIdToBeUpdated = reclamationIdToBeUpdated;
	}





	//les getters et les setters 
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
	public static Logger getL() {
		return L;
	}
	// enumeration 
	public RState[] getRStates() { return RState.values(); }
	public RType[] getRTypes() { return RType.values(); }
	// list Affichage 
	
	private List<Reclamation> reclamations;
	
	//getters et setters de reclamation 
	public List<Reclamation> getReclamations() {
		User u = UserConnected.userconnected;
		
		reclamations = ReclamationService.retrieveAllReclamationsByIdUser(String.valueOf(u.getId()));
		return reclamations;
	}


    
	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	//Add Reclamation 
    public void addReclamation() {
    	User u = UserConnected.userconnected;
    	String i = upload();

    	Reclamation A = new Reclamation( u, Titre, Description, i,State, Type) ;
    	ReclamationService.addOrUpdateReclamation (A) ;
 
		Notification n = new Notification("cl.png", "New "+A.getTitre(),"/pages/client/ReclamationNotif.jsf?id="+A.getId_reclamation(),NState.Not_Seen,A.getReclamationUser());
		
		Notif.addNotification(n);
		
		
    	}
	//Delete
    



	
	private Part uploadedFile;
	
	private File savedFile;

	String pathImg = "C:\\Users\\MSI\\Documents\\consommiTounsi\\CicadaConsommi\\src\\main\\webapp\\assets\\recImg" ;
	
	
	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	

public String upload() {
	    System.err.println("ag west upgoload");
	    String fileName=  RandomString.make(8) +"_uplgonaded_"+ java.util.Calendar.getInstance().getTime().getDay() + "_" +java.util.Calendar.getInstance().getTime().getMonth() +".png" ;
	    File uploads = new File(pathImg);
	    
	    savedFile = new File(uploads,fileName);
	    System.err.println("path saveFile "+ savedFile.getAbsolutePath());
	    System.err.println("sub uploadfile name "+ uploadedFile.getSubmittedFileName());
	    InputStream input;
		try {
			input = uploadedFile.getInputStream();
			System.err.println(input.toString());
			Files.copy(input, savedFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		uploadedFile =  null;
	    return fileName;    

	}
	 
}
