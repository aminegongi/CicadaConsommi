package tn.esprit.spring.BackController;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.CategoryServiceImpl;
import tn.esprit.spring.service.ICategoryService;
import tn.esprit.spring.service.IRayonService;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;





@Scope(value = "session")
@Controller(value = "categoryController") // Name of the bean in Spring IoC
@ELBeanName(value = "categoryController") // Name of the bean used by JSF
@Join(path = "/admin/category", to = "/template/Back/gereCategory.jsf")
public class CategoryBackController {

	

@Autowired
CategoryServiceImpl categoryService ;

@Autowired
IRayonService rayonService;

private List<Category> categories = null;
private Category ct = new Category();
private List<Rayon> rayons = null;
private String result="";

private int rayonId;



/*@PostMapping("/addCategory")
@ResponseBody*/

public String addCategory() 
{
	System.err.println("-------------------");
	System.err.println(ct);
	try {
		Rayon r = new Rayon();
		r.setId(rayonId);
		ct.setRayon(r);
		categoryService.addCategory(ct);
		 categories =categoryService.retrieveAllCategories();
		 return result=" Category has been added successfully";
		}
	catch(Exception e) {
		return result =" Rayon Does not exist !!!!";
		}
	
	
		
 
}

public void displayCategory(Category c)
	{
   	ct.setId(c.getId());
   	ct.setName(c.getName());
   	this.setRayonId(c.getRayon().getId());
   	
	}

/*@GetMapping(value ="/allCategories")
@ResponseBody*/
public List<Category> getCategories() {
if(categories == null)
return categories =categoryService.retrieveAllCategories();
else
	return categories;
} 

public List<Category> getAllCategories() {

return categories =categoryService.retrieveAllCategories();
} 

public List<Rayon> getRayons() {

return rayons =rayonService.getAllRayons();

} 

public List<Produit> getAllProducts() {

return categoryService.getAllProducts();

} 

//http://localhost:8081/ConsomiTounsi/remove-category/{id}


public void removeCategory( int id) {
categoryService.deleteCategory(id);
categories =categoryService.retrieveAllCategories();
 }




/*@GetMapping("/findCategory/{id}")
public Category findCategory(@PathVariable("id")int id)
{
	return categoryService.findCategory(id);
}*/

/*@GetMapping("/findByName/{name}")*/
public List<Category> findCategory(/*@PathVariable("name")*/String name)
{
	return categories = categoryService.findByName(name);
}

/*@GetMapping("/groupedByRayon/{rayonId}")*/
public List<Category> groupedByRayon(/*@PathVariable("rayonId")*/int rayonId)
{
	return categories = categoryService.GroupedByRayon(rayonId);
}

/*@PostMapping("/affectRtoC/{idR}/{idC}") 
@ResponseBody */
public void affectProduitToCategory(/*@PathVariable("idR")*/int idR,/*@PathVariable("idC")*/ int idC) {
	categoryService.affectRayonToCategory(idR, idC);
	categories =categoryService.retrieveAllCategories();
}



public Category getCt() {
	return ct;
}


public void setCt(Category ct) {
	this.ct = ct;
}

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}

public int getRayonId() {
	return rayonId;
}

public void setRayonId(int rayonId) {
	this.rayonId = rayonId;
}


	
}

