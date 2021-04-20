package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Commande;

import tn.esprit.spring.repository.CommandeRepository;




@Service
public class CommandeService implements CommandeServiceImpl{

	
	@Autowired
    CommandeRepository commanderepositoryimpl ;
	

	
	//for each found element , 
	//calling the add method and pass it on commande
	@Override
	public List<Commande> retrieveAllCommandes() {
		// TODO Auto-generated method stub
		//return null;
		List<Commande> commande = new ArrayList<>();
		commanderepositoryimpl.findAll()
		.forEach(commande::add);  
		return commande ;
	}

	@Override
	public Commande addCommande(Commande l) {
		// TODO Auto-generated method stub
		//return null;
		System.out.println(l);		
		commanderepositoryimpl.save(l)	; //save to database
		return l ; 
	}

	@Override
	public void deleteCommande(int id) {
		// TODO Auto-generated method stub
		commanderepositoryimpl.deleteById(id);
	}

	@Override
	public Commande updateCommande(Commande l) {
		// TODO Auto-generated method stub
		//return null;
		commanderepositoryimpl.save(l);
		return l ;
	}

	@Override
	public Commande retrieveCommande(int id) {
		// TODO Auto-generated method stub
		//return null;	
		return commanderepositoryimpl.findById(id).get() ; 
		
				
		
		
	}

	


}






