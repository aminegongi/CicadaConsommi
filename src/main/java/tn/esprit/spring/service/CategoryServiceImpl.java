package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.entity.Category;
/*import tn.esprit.spring.entities.Rating;*/
import tn.esprit.spring.entity.Rayon;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private RayonRepository rayonRepository;
	@Override
	public Category addCategory(Category c) {
		CategoryRepository.save(c);
		return c;
		
	}

	@Override
	public void deleteCategory(int i) {
		CategoryRepository.deleteById(i);
		
	}

	@Override
	public List<Category> retrieveAllCategories() {
		List<Category> categories = (List<Category>) CategoryRepository.findAll();	
		return categories;
	}

	@Override
	public Category updateCategory(Category c) {
		CategoryRepository.save(c);
		return c;
	}
	
	@Override
	public Category findCategory(int id) {
		/*int products=rayonRepository.findByrayon(id);*/
		Category p=CategoryRepository.findById(id).get();
		return p;
	}
	
	@Override
	public List<Category> findByName(String name) {
		List<Category> c = CategoryRepository.findByName(name);
		return c;
		
	}
	
	@Override
	public List<Category> GroupedByRayon(int idRayon) {
		List<Category> c = CategoryRepository.groupedByRayon(idRayon);
		return c;
		
	}
	
	@Override
	public String affectRayonToCategory(int rayId, int catId)
	{
		Category categoryEntity = CategoryRepository.findById(catId).get();
		Rayon rayonEntity = rayonRepository.findById(rayId).get();
		categoryEntity.setRayon(rayonEntity);
		CategoryRepository.save(categoryEntity);
		return"Rayon affected to category";

	}

}
