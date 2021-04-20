package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit_Commandes;
import tn.esprit.spring.repository.Produit_CommandeRepository;

@Service
public class Produit_CommandesServiceImpl implements Produit_CommandesService {
	@Autowired
	Produit_CommandeRepository Produit_cmdRepository ;
	private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);
	private List<Produit_Commandes> Produit_Cmds;
	@Override
	public List<Produit_Commandes> retrieveAllProducts_commands() {
		Produit_Cmds=(List<Produit_Commandes>) Produit_cmdRepository.findAll();
		for(Produit_Commandes Produit_Cmd: Produit_Cmds){
			l.info("Products_Commands list : "+ Produit_Cmd);
		}
		return Produit_Cmds;
	}

	@Override
	public Produit_Commandes addProducts(Produit_Commandes pc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduit(Produit_Commandes pc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProducts(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit_Commandes updateProducts(Produit_Commandes pc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit_Commandes retrieveProducts(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit_Commandes> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
