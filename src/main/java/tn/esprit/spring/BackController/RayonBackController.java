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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.ICategoryService;
import tn.esprit.spring.service.IRayonService;
import tn.esprit.spring.entity.Category;
/*import tn.spring.esprit.entities.Product;*/
import tn.esprit.spring.entity.Rayon;




@Scope(value = "session")
@Controller(value = "rayonController") // Name of the bean in Spring IoC
@ELBeanName(value = "rayonController") // Name of the bean used by JSF
@Join(path = "/admin/rayon", to = "/template/Back/gereRayon.jsf")
public class RayonBackController {
	

	@Autowired
	IRayonService rayonService;
	
	@Autowired
	ICategoryService categoryService;
	
	private Rayon ry = new Rayon();
    private List<Rayon> rayons;
    private List<Category> categories = null;
    private String type="";
    private List<String> types;
    
    
    public void displayRayon(Rayon r)
	{
    	ry.setId(r.getId());
    	ry.setType(r.getType());
		
	}
	
	
	public void addRayon() {
		rayonService.addRayon(ry);
		rayons = rayonService.getAllRayons();
	}
	
	/*@DeleteMapping(value = "/deleteRayon/{id}")*/
	public void deleteRayon(/*@PathVariable("id")*/int id) {
		rayonService.deleteRayon(id);
		rayons = rayonService.getAllRayons();
		
	}
	
	public List<Rayon> getRayons() {
		if (rayons == null)
		{
			return rayons = rayonService.getAllRayons();
		}
		else
		{
	return rayons;
		}
	}
	
	public List<Category> showCategories(int id) {
		
		categories = categoryService.GroupedByRayon(id);
		return categories;
		
	}
	
	
/*	@PutMapping(value = "/updateRayon") 
	public Rayon updateRayon(@RequestBody Rayon r)  {
		return rayonService.updateRayon(r);
	}*/
	
	
	/*@GetMapping("/getAllRayons")*/
	public List<Rayon> getAllRayons() {
		 rayons= rayonService.getAllRayons();
		return rayons;
	}
	
	public List<Rayon> getRayonBytype(String typee) {
         if(typee == "" )
        	 rayons= rayonService.getAllRayons();
         else
		rayons= rayonService.getRayonBytype(typee);
         
		return rayons;
	}
	
	
	@GetMapping("/findByrayon/{id}")
	public Rayon findByrayon(@PathVariable("id")int id)
	{
		return rayonService.findByrayon(id);
	}
	
	

	
    public List<String> getTypes()
    {
    	types = rayonService.findTypes();
    	return types;
    }
    
	public Rayon getRy() {
		return ry;
	}

	public void setRy(Rayon ry) {
		this.ry = ry;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Category> getCategories() {
		return categories;
	}
	
	
	
	/*@GetMapping("/findByCategory/{id}")
	public Rayon findByCategory(@PathVariable("id")int id) {

		return rayonService.findByCategory(id);
	}*/
	
	
	
	/*@GetMapping("/findAllProductByrayon/{idr}")
	public List<Product> findAllProductByrayon(@PathVariable("idr")int idr)
	{
		return rayonService.findAllProductByrayon(idr);
	}*/
	
	
	
	
	
}
