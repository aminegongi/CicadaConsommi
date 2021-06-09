package tn.esprit.spring.service;


import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import tn.esprit.spring.Repository.ProductRepository;*/
import tn.esprit.spring.repository.StockRepository;
/*import tn.esprit.spring.entities.Command;*/
/*import tn.esprit.spring.entities.Product;*/
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.helper.ExcelHelper;



@Service
public class StockServiceImpl implements IStockService {
	@Autowired
	private StockRepository stockRepository;
	/*@Autowired
	private ProductRepository productRepository;
	@Autowired
    private JavaMailSender javaMailSender;*/

	@Override
	public int addStock(Stock s) {
		stockRepository.save(s);
		return s.getId();
	}

	@Override
	public void deleteStock(int i) {
		stockRepository.deleteById(i);
		
	}

	@Override
	public Stock updateStock(Stock s) {
		stockRepository.save(s);
		return s ;
	}

	@Override
	public List<Stock> getAllStocks() {
		/*sendEmail();*/
		
		List<Stock> Stocks = (List<Stock>) stockRepository.findAll();	
		return Stocks;
	}
	
	@Override
	public List<Stock> triByAmount() {
		/*sendEmail();*/
		
		List<Stock> Stocks = (List<Stock>) stockRepository.TriByAmount();	
		return Stocks;
	}
	
	@Override
	public List<Stock> triByQtee() {
		/*sendEmail();*/
		
		List<Stock> Stocks = (List<Stock>) stockRepository.TriByQtee();	
		return Stocks;
	}
	
	@Override
	public List<Stock> triByQtes() {
		/*sendEmail();*/
		
		List<Stock> Stocks = (List<Stock>) stockRepository.TriByQtes();	
		return Stocks;
	}
	
	@Override
	public Stock findStock(int id) {
		Stock s=stockRepository.findById(id).get();
		return s;
	}

	@Override
	public void increaseStock(int qte,int id) {
		Stock s =stockRepository.findById(id).get();
		s.setAmount(s.getAmount()+qte);
		s.setQtee(s.getQtee()+qte);
		stockRepository.save(s);		
	}
	
	@Override
	public String decreaseStock(int qte,int id) {
		Stock s =stockRepository.findById(id).get();
		if(s.getAmount()>= qte)
		{
		s.setAmount(s.getAmount()-qte);
		s.setQtes(s.getQtes()+qte);
		stockRepository.save(s);
		return "An amout Has taken from the Stock";
		}
		else
		return "There s no insufficient Amount in the Stock";
		
	}
	
	/*public ByteArrayInputStream load() {
	    List<Stock> stocks = (List<Stock>) stockRepository.findAll();

	    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(stocks);
	    return in;
	  }*/
	
	/*@Override
	public List<Long> missingProduct() {
		
		List<Long> products = (List<Long>) stockRepository.missingProduct();	
		
		return products;
	}*/
	
	
	/*public void orderProduct(long pid,int amount) {
		Product p = productRepository.findById(pid).get();
		
		p.getStock().setAmount(amount+p.getStock().getAmount());
		productRepository.save(p);
	}
	*/
	/*
void sendEmail() {
try
{
	String ch="";
	List<Product> prods=new ArrayList<Product>();
	List<Long> products =  (List<Long>) stockRepository.missingProduct();
	//Product p = productRepository.findById(products).get();
	System.out.println(products.size());
	 for (int i = 0; i < products.size(); i++) {
	      System.out.println(products.get(i));
	     long p= products.get(i);
	      Product product =productRepository.findById(p).get();
	      
	      prods.add(product);
	      
	    }
	
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chadisassi@gmail.com", "chadi.sassi1@esprit.tn");

        msg.setSubject("Missing Product");
    //    msg.setText(" Reference :  "+p.getReference()+" \n Name :  "+ p.getName() + "\n amount : " +p.getStock().getAmount() );

        for(int i=0; i<prods.size(); i++)
        {  ch =ch + " Reference :  "+prods.get(i).getReference()+" \n Name :  "+prods.get(i).getName()+ "\n amount : "+prods.get(i).getStock().getAmount()+ " \n / \n  " ;
        System.out.println(prods.get(i));
        }
         msg.setText(ch);
         System.out.println(ch);

        javaMailSender.send(msg);
        
}
catch(Exception e) {
	
  System.out.println("erreur"+e);
}

    }
	
*/
}

