package tn.esprit.spring.service;

import java.util.List;

/*import tn.esprit.spring.entities.Product;*/
import tn.esprit.spring.entity.Stock;



public interface IStockService {
	
	public int addStock(Stock s);
	public void deleteStock(int i);
	public Stock updateStock(Stock s);
	public List<Stock> getAllStocks();
	
	public Stock findStock(int id);
	
	public List<Stock> triByAmount();
	public List<Stock> triByQtee();
	public List<Stock> triByQtes();
	
	public void increaseStock(int qte , int id);
	public String decreaseStock(int qte , int id);
	
	/*
	public List<Long> missingProduct();
	public void orderProduct(long pid,int amount);*/
	
	

}