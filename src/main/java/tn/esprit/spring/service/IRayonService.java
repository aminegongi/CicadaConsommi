package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Category;
/*import tn.esprit.spring.entities.Product;*/
import tn.esprit.spring.entity.Rayon;



public interface IRayonService {
	
	public int addRayon(Rayon r);
	public void deleteRayon(int i);	
	public Rayon updateRayon(Rayon r);
	public List<Rayon> getAllRayons();
	
	public Rayon findByrayon(int id);
	
	public List<Rayon> getRayonBytype(String type);
	public List<String> findTypes();
	
	public List <Category> showCategories(int id);
	public Rayon[] getAllRayonsV();
	
	/*public Rayon findByCategory(int id);*/
	/*public List<Product> findAllProductByrayon(int idr);*/
	
	

}

