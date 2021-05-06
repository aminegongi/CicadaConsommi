package tn.esprit.spring.FrontController;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.ocpsoft.prettytime.PrettyTime;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.CommentaireService;
import tn.esprit.spring.service.RatingService;
import tn.esprit.spring.service.SujetService;

@Scope(value = "session")
@Controller(value = "fsujetController")
@ELBeanName(value = "fsujetController")
@Join(path = "/client/sujet", to = "/pages/client/sujet.jsf")
public class SujetFrontController {
	
	@Autowired
	SujetService sujetService;
	
	@Autowired
	RatingService ratingService;
	
	@Autowired
	CommentaireService commService;
	
	User Con = new User();
	
	private String sujet_titre;
	private Integer sujet_id_up;
	private String sujet_description;
	private String sujet_idUser;
	
	private String sujet_AMOut;
	private String sujet_ComOut;
	
	private List<Sujet> listSujets;
	
	private List<Sujet> listMesSujets;
	
	
	//-----Recherche
	private String recherche;
	private List<Sujet> listSujetRechTri;
	
	//---------Sort
	private List<String> sortsby;
	private String sortby;
	
	//--------- SujetDetails
	private Sujet leSujet;
	private String sujetId;
	
	private String leSujetRating;
	private String commentairesujet;
	
	
	
	
	
	
	//------Getters & Setters 
	
	public List<String> getSortsby() {
		sortsby.add("hello");
		sortsby.add("bonjour");
		sortsby.add("Lalalal");
		return sortsby;
	}

	public void setSortsby(List<String> sortsby) {
		this.sortsby = sortsby;
	}

	public String getSortby() {
		return sortby;
	}

	public void setSortby(String sortby) {
		this.sortby = sortby;
	}

	public String getSujet_ComOut() {
		return sujet_ComOut;
	}

	public void setSujet_ComOut(String sujet_ComOut) {
		this.sujet_ComOut = sujet_ComOut;
	}

	public List<Sujet> getListSujetRechTri() {
		return listSujetRechTri;
	}

	public void setListSujetRechTri(List<Sujet> listSujetRechTri) {
		this.listSujetRechTri = listSujetRechTri;
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	
	public User getCon() {
		return Con;
	}

	public void setCon(User con) {
		Con = con;
	}
	
	public String getSujet_titre() {
		return sujet_titre;
	}

	public void setSujet_titre(String sujet_titre) {
		this.sujet_titre = sujet_titre;
	}

	public Integer getSujet_id_up() {
		return sujet_id_up;
	}

	public void setSujet_id_up(Integer sujet_id_up) {
		this.sujet_id_up = sujet_id_up;
	}

	public String getSujet_description() {
		return sujet_description;
	}

	public void setSujet_description(String sujet_description) {
		this.sujet_description = sujet_description;
	}

	public String getSujet_idUser() {
		return sujet_idUser;
	}

	public void setSujet_idUser(String sujet_idUser) {
		this.sujet_idUser = sujet_idUser;
	}
	
	public String getSujet_AMOut() {
		return sujet_AMOut;
	}

	public void setSujet_AMOut(String sujet_AMOut) {
		this.sujet_AMOut = sujet_AMOut;
	}
	
	// Affichage Sujets
	public List<Sujet> getListSujets() {
		Con.setId(Long.valueOf(1));
		listSujets = sujetService.getAll();
		return listSujets;
	}

	public void setListSujets(List<Sujet> listSujets) {
		this.listSujets = listSujets;
	}

	
	//Afichage Mes Sujets
	public List<Sujet> getListMesSujets() {
		Con.setId(Long.valueOf(1));
		listMesSujets = sujetService.sujetParUser(Con.getId());
		return listMesSujets;
	}

	public void setListMesSujets(List<Sujet> listMesSujets) {
		this.listMesSujets = listMesSujets;
	}
	
	//ajout d'un Sujet 
	public void addSujet(){
		System.err.println("HHHEE");
		String out = sujetService.save(new Sujet(sujet_titre, sujet_description, Con));
		this.setSujet_AMOut(out);
		this.setSujet_titre(null);
		this.setSujet_description(null);
		this.setSujet_id_up(null);
	}
	
	//delete
	public void deleteSujet(int id){
		System.err.println("SUPP");
		sujetService.delete(id);
	}
	
	//Remplir Champs Pour Modification
	public void remplirChamps(Sujet s){
		this.setSujet_titre(s.getTitre());
		this.setSujet_description(s.getDescription());
		this.setSujet_id_up(s.getId());
		
	}
	
	//modification
	public void update(){
		System.err.println("Mod");
		sujetService.update(new Sujet(sujet_id_up, sujet_titre, sujet_description,Con));
		this.setSujet_titre(null);
		this.setSujet_description(null);
		this.setSujet_id_up(null);
		this.setSujet_AMOut(null);
	}
	
	//MoveToPageSujet
	public String showsujet(){
		FacesContext context = FacesContext.getCurrentInstance();
	    Map requestParams = context.getExternalContext().getRequestParameterMap();
	    sujetId = (String) requestParams.get("id");
		System.err.println(sujetId);
		///this.setLeSujet(s);
		return "/pages/client/sujetDetails.xhtml?faces-redirect=true";
	}
	
	// get sujetId Plaus de detail
	public String getSujetId() {
		return sujetId;
	}

	public void setSujetId(String sujetId) {
		this.sujetId = sujetId;
	}

	// Le Sujet Info
	
	public Sujet getLeSujet() {
		leSujet = sujetService.getById(Integer.valueOf(sujetId));
		return leSujet;
	}

	public void setLeSujet(Sujet leSujet) {
		this.leSujet = leSujet;
	}
	
	public String getLeSujetRating() {
		return leSujetRating;
	}

	public void setLeSujetRating(String leSujetRating) {
		this.leSujetRating = leSujetRating;
	}
	
	public void ratingamRate(){
		int rateIdUp = -1;
		for (Rating rr : ratingService.getAll()) {
			if(rr.getRatingUser().getId() == Con.getId()){
				rateIdUp = rr.getId();
				break;
			}
		}
		if(rateIdUp == -1)
			ratingService.save(new Rating(Float.valueOf(this.getLeSujetRating()), this.getLeSujet(), Con));
		else
			ratingService.save(new Rating(rateIdUp, Float.valueOf(this.getLeSujetRating()), this.getLeSujet(), Con));
	}
	public void ratingamCancel(){
		int rateIdUp = -1;
		for (Rating rr : ratingService.getAll()) {
			if(rr.getRatingUser().getId() == Con.getId()){
				rateIdUp = rr.getId();
				break;
			}
		}
		if(rateIdUp == -1)
			ratingService.save(new Rating(Float.valueOf(0), this.getLeSujet(), Con));
		else
			ratingService.save(new Rating(rateIdUp, Float.valueOf(0), this.getLeSujet(), Con));
	}

	public String calculateAVg(Sujet s){
		float sum = 0;
		if(s.getSujetRating().isEmpty())
			return String.valueOf(0);
		for (Rating r : s.getSujetRating()) {
			sum += r.getNombre();
		}
		sum = sum / s.getSujetRating().size();
		return String.valueOf(sum);
	}

	
	//-------Commentaire
	
	
	public String getCommentairesujet() {
		return commentairesujet;
	}

	public void setCommentairesujet(String commentairesujet) {
		this.commentairesujet = commentairesujet;
	}
	
	public void addCommentaire(){
		System.err.println("west el add Commentaire");
		Commentaire c = new Commentaire(commentairesujet, this.getLeSujet(), Con);		
		this.setSujet_ComOut(commService.save(c));
		this.setCommentairesujet(null);	
	}

	public String timeAgo(Date d){
		PrettyTime pt = new PrettyTime(Locale.ENGLISH);
		String ago = pt.format(d);
		return ago;
	}
	
	
	//----------------------- Recherche
	public String search(){
		System.err.println("----------- Recherche ------------");
		listSujetRechTri = sujetService.rechercheSujet(recherche) ;
		return "/pages/client/sujets.xhtml?faces-redirect=true";
	}
	
	
	
	
}