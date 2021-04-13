package tn.esprit.spring.service;

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
	
	@Override
	public List<Produit> retrieveAllProducts() {
		List<Produit> produits=(List<Produit>) produiRepository.findAll();
		for(Produit produit: produits){
			l.info("user list : "+ produit);
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

}
