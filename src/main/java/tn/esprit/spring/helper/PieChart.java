package tn.esprit.spring.helper;

import javax.annotation.PostConstruct;  
import java.io.Serializable;  
import javax.faces.bean.ManagedBean;  
import org.primefaces.model.chart.PieChartModel;  
@ManagedBean  
public class PieChart implements Serializable {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public PieChartModel pieModel;  
@PostConstruct  
public void init() {  
createPieModels();  
}  

public PieChartModel getPieModel() {  
return pieModel;  
}  

public void createPieModels() {  
createPieModel();  
}  

public void createPieModel() {  
pieModel = new PieChartModel();  
pieModel.set("Mercedess", 700);  
pieModel.set("BMW", 300);  
pieModel.set("Volvo", 400);  
pieModel.setTitle("Car Brands");  
pieModel.setLegendPosition("c");  
}  
}  
