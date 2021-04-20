package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivreurRepository;



@Service
public class LivreurService implements LivreurServiceImpl{

	
	@Autowired
    LivreurRepository livreurrepositoryimpl ;
	

	
	//for each found element , 
	//calling the add method and pass it on livreurs
	@Override
	public List<Livreur> retrieveAllLivreurs() {
		// TODO Auto-generated method stub
		//return null;
		List<Livreur> livreurs = new ArrayList<>();
		livreurrepositoryimpl.findAll()
		.forEach(livreurs::add);  
		return livreurs ;
	}

	@Override
	public Livreur addLivreur(Livreur l) {
		// TODO Auto-generated method stub
		//return null;
		System.out.println(l);		
		livreurrepositoryimpl.save(l)	; //save to database
		return l ; 
	}

	@Override
	public void deleteLivreur(int id) {
		// TODO Auto-generated method stub
		livreurrepositoryimpl.deleteById(id);
	}

	@Override
	public Livreur updateLivreur(Livreur l) {
		// TODO Auto-generated method stub
		//return null;
		livreurrepositoryimpl.save(l);
		return l ;
	}

	@Override
	public Livreur retrieveLivreur(int id) {
		// TODO Auto-generated method stub
		//return null;	
		return livreurrepositoryimpl.findById(id).get() ; 
		
				
		
		
	}

	


}






