package tn.esprit.spring.BackController;


import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.service.IStockService;
import tn.esprit.spring.entity.Produit;
/*import tn.esprit.spring.entities.Product;*/
import tn.esprit.spring.entity.Stock;

@Scope(value = "session")
@Controller(value = "stockController") // Name of the bean in Spring IoC
@ELBeanName(value = "stockController") // Name of the bean used by JSF
@Join(path = "/admin/stock", to = "/template/Back/gereStock.jsf")
public class StockBackController {
	
	@Autowired
	IStockService stockService;
	
	private Stock st = new Stock();
    private List<Stock> stocks;
    private String result="";
    private String result2="";
    
    private Long id_produit;
	
	
    /*@PostMapping("/addStock")	*/
	public String addStock(/*@RequestBody*/) {
		if(st.getQtee()==(st.getQtes()+st.getAmount()))
				{
			Produit p = new Produit();
			p.setId_produit(id_produit);
			st.setP(p);
			stockService.addStock(st);
			stocks = stockService.getAllStocks();
			result2 ="Stock has be added Succesfuly !!";
			clear();
		return result2;
				}
		else
		{
			result2 ="(Amount + Stock Out) must be equal to (Stock out)";
			return result2;
		}
		   
	}
	

	 public void clear()
		{
	    	st.setId(0);
	    	st.setAmount(0);
	    	st.setQtee(0);
	    	st.setQtes(0);
	    	this.setId_produit(null);
		}
	
	
	
	
	 public void displayStock(Stock s)
		{
	    	st.setId(s.getId());
	    	st.setAmount(s.getAmount());
	    	st.setQtee(s.getQtee());
	    	st.setQtes(s.getQtes());
	    	this.setId_produit(s.getP().getId_produit());

		}
	 
	 
	 
	
	/*@DeleteMapping(value = "/deleteStock/{id}")*/
	public void deleteStock(/*@PathVariable("id")*/int id) {
		stockService.deleteStock(id);
		stocks = stockService.getAllStocks();
	}
	
	/*@PutMapping(value = "/updateStock") 
	public Stock updateBill(@RequestBody Stock s)  {
		return stockService.updateStock(s);
	}*/

	/*@GetMapping("/getAllStocks")*/
	public List<Stock> getAllStocks() {
		
		stocks = stockService.getAllStocks();
		return stocks;
	}
	
	/*@GetMapping("/triByAmount")*/
	public List<Stock> triByAmount() {

		return stocks =stockService.triByAmount();
	}
	
	/*@GetMapping("/triByQtee")*/
	public List<Stock> triByQtee() {

		return stocks =stockService.triByQtee();
	}
	
	/*@GetMapping("/triByQtes")*/
	public List<Stock> triByQtes() {

		return stocks = stockService.triByQtes();
	}
	
	
	/*@GetMapping("/findStock/{id}")*/
	public Stock findStock(/*@PathVariable("id")*/int id) {
		
		return st = stockService.findStock(id);
		
		
	}
	
	
	public String decreaseStock(int qte,int id) {
		
				result = stockService.decreaseStock(qte,id);
				stocks = stockService.getAllStocks();
				return result;
	}
	
	
	
	public void increaseStock(int qte,int id) {
		 stockService.increaseStock(qte,id);
		 stocks = stockService.getAllStocks();
		
	}


	public Stock getSt() {
		return st;
	}


	public void setSt(Stock st) {
		this.st = st;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getResult2() {
		return result2;
	}


	public void setResult2(String result2) {
		this.result2 = result2;
	}


	public List<Stock> getStocks() {
		if(stocks == null)
		return stockService.getAllStocks();
		else
			return stocks;
	}


	public Long getId_produit() {
		return id_produit;
	}


	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}
	
	
	
	
	/*
	@PutMapping(value = "/orderProduct/{pid}/{amount}")
	public void orderProduct(@PathVariable("pid")int pid,@PathVariable("amount")int amount) {
		 stockService.orderProduct(pid, amount);
		
	}*/
	
	
	
		

}
