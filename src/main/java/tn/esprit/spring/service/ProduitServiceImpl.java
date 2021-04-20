package tn.esprit.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;;;

@Service
public class ProduitServiceImpl implements ProduitService{
	@Autowired
	ProduitRepository produiRepository ;
	private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);
	private List<Produit> produits;
	
    public void addProduit(Produit p) {
    	long rand = (long) ((Math.random() * (999 - 1)) + 1);
    	p.setId_produit(rand);
        this.produits.add(p);
    }
    
	@Override
	public List<Produit> retrieveAllProducts() {
		produits=(List<Produit>) produiRepository.findAll();
		for(Produit produit: produits){
			l.info("Products list : "+ produit);
		}
		return produits;
	}

	@Override
	public Produit addProducts(Produit p) {
		
		return produiRepository.save(p);
	}

	@Override
	public void deleteProducts(String id_produit) {
		produiRepository.deleteById(Long.parseLong(id_produit));
		
	}

	@Override
	public Produit updateProducts(Produit p) {
		return produiRepository.save(p);
	}

	@Override
	public Produit retrieveProducts(String id_produit) {
		// TODO Auto-generated method stub
//		return null;
		return produiRepository.findById(Long.parseLong(id_produit)).get() ; 
//		return produiRepository.findById(Long.parseLong(id_produit));
//		return produiRepository.findById(Long.parseLong(id_produit).orElse(null));
	}

	public boolean verification619(String id_product){
//		List<Produit> produits=(List<Produit>) 
//		List<Produit> produits=(List<Produit>) produiRepository.findAll();
				Produit p =produiRepository.findById(Long.parseLong(id_product)).get() ;
				String codebarre=p.getCodeBarre_produit();
				if(codebarre.startsWith("619"))
					return true;
				else 
					return false;
	}
	public String Etat_produit(String id_product){
//		LocalDateTime now = LocalDateTime.now(); 
//		LocalDate now2 = LocalDate.now(); 
		Produit p =produiRepository.findById(Long.parseLong(id_product)).get() ;
		Date currentDate=new Date();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
		Date dateFromLocalDT = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		String reply="";
		 if(p.getDateExpiration_produit().compareTo(dateFromLocalDT) > 0) {
			 reply= "Expired";
	      } else if(p.getDateExpiration_produit().compareTo(dateFromLocalDT)  < 0) {
	    	  reply="Not expired";
	      } else if(p.getDateExpiration_produit().compareTo(dateFromLocalDT)  == 0) {
	    	  reply="equal";
	      }
		return reply;
	}
	public String Rating(String id_product){
		Produit p =produiRepository.findById(Long.parseLong(id_product)).get() ;
		return p.getNom_produit();
	}

	@Override
	public List<Produit> search(String keyword) {
		// TODO Auto-generated method stub
		return produiRepository.findProduitByNom(keyword);
	}

}
