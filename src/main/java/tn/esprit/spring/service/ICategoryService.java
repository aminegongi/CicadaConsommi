package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Produit;

public interface ICategoryService {
	
	public Category addCategory(Category c);
	public void deleteCategory(int i);
	public List<Category> retrieveAllCategories();
	public Category updateCategory(Category c);
	
	public Category findCategory(int id);
	public List<Category> findByName(String name);
	public List<Category> GroupedByRayon(int idRayon);
	
	public String affectRayonToCategory(int rayId, int catId);
	
	public List<Produit> getAllProducts();
	
}
