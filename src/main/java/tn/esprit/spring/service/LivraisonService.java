package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Livraison;

import tn.esprit.spring.repository.LivraisonRepository;




@Service
public class LivraisonService implements LivraisonServiceImpl{

	
	@Autowired
    LivraisonRepository livraisonrepositoryimpl ;
	

	
	//for each found element , 
	//calling the add method and pass it on livraison
	@Override
	public List<Livraison> retrieveAllLivraisons() {
		// TODO Auto-generated method stub
		//return null;
		List<Livraison> livraison = new ArrayList<>();
		livraisonrepositoryimpl.findAll()
		.forEach(livraison::add);  
		return livraison ;
	}

	@Override
	public Livraison addLivraison(Livraison l) {
		// TODO Auto-generated method stub
		//return null;
		System.out.println(l);		
		livraisonrepositoryimpl.save(l)	; //save to database
		return l ; 
	}

	@Override
	public void deleteLivraison(int id) {
		// TODO Auto-generated method stub
		livraisonrepositoryimpl.deleteById(id);
	}

	@Override
	public Livraison updateLivraison(Livraison l) {
		// TODO Auto-generated method stub
		//return null;
		livraisonrepositoryimpl.save(l);
		return l ;
	}

	@Override
	public Livraison retrieveLivraison(int id) {
		// TODO Auto-generated method stub
		//return null;	
		return livraisonrepositoryimpl.findById(id).get() ; 
		
				
		
		
	}

	


}






