package tn.esprit.spring.controller;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.ProduitServiceImpl;
import tn.esprit.spring.service.SujetService;
import tn.esprit.spring.service.UserServiceImpl;


@Scope(value = "session")
@Controller(value = "graphController")
@ELBeanName(value = "graphController")
@Join(path = "/client/Pie", to = "/pages/user/Piechart.jsf")
public class GraphController {
	
	@Autowired
	SujetService sujetservice;
	@Autowired
	UserServiceImpl userservice;
	@Autowired
	ProduitServiceImpl produitservice;
	@Autowired 
	UserRepository userrepository;
	

		private PieChartModel Piemodel;
		public GraphController() {
		}
		
		public PieChartModel getPiemodel() {
			List<Sujet> gg = sujetservice.getAll();
			//int tot = gg.get().getSujetComms().size()size();
			Piemodel = new PieChartModel();
			for( int i=0 ; i< gg.size() ; i++){
				Piemodel.set(gg.get(i).getTitre(),gg.get(i).getSujetComms().size());
				
				}

			Piemodel.setTitle("PIE CHART COMMENTS PER SUBJECT");
			Piemodel.setLegendPosition("w");
			return Piemodel;
		}
		public void setPiemodel(PieChartModel piemodel) {
			Piemodel = piemodel;
		}
		//------------------ HorizontalBarChartModel-----------------------------------------
		private HorizontalBarChartModel hbmodel;

		public HorizontalBarChartModel getHbmodel() {
			List<User> user = userservice.getAll();
			hbmodel = new HorizontalBarChartModel();
			 ChartSeries role = new ChartSeries();
			 
			 role.setLabel("Role");
			 List<Map<String, BigInteger>> roleuser = userrepository.getRoleUser();
			 for (Map<String, BigInteger> map : roleuser) {				   
				       role.set(String.valueOf(map.get("name")),map.get("nb"));		    
				    }

			 hbmodel.addSeries(role);

			 hbmodel.setTitle("Stats about our Users ");
			 hbmodel.setLegendPosition("e");
			 hbmodel.setStacked(true);

			 Axis xAxis = hbmodel.getAxis(AxisType.X);
			 xAxis.setLabel("Number of Users/Role");
			 xAxis.setMin(0);
			 xAxis.setMax(10);

			 Axis yAxis = hbmodel.getAxis(AxisType.Y);
			 yAxis.setLabel("Roles");
			return hbmodel;
		}

		public void setHbmodel(HorizontalBarChartModel hbmodel) {
			this.hbmodel = hbmodel;
		}
		//-----------------------------------------------------------------------------------------
		private BubbleChartModel bcmodel;

		public BubbleChartModel getBcmodel() {
			List<Produit> produit =produitservice.retrieveAllProducts();
			bcmodel = new BubbleChartModel();
			for( int i=0 ; i< produit.size() ; i++){

				bcmodel.add(new BubbleChartSeries(produit.get(i).getMarque_produit(),produit.get(i).getRating(),50,15));
				
				}
			 bcmodel.setTitle("Bubble Chart");
			 bcmodel.getAxis(AxisType.X).setLabel("Price");
			 Axis yAxis = bcmodel.getAxis(AxisType.Y);
			 yAxis.setMin(0);
			 yAxis.setMax(250);
			 yAxis.setLabel("Marque Produit");
			return bcmodel;
		}

		public void setBcmodel(BubbleChartModel bcmodel) {
			this.bcmodel = bcmodel;
		}
		//----------------------------------Bar-Chart-Marque-produit ------------------------------------------------
		
		 
		private BarChartModel barmodel;
	
		public BarChartModel getBarmodel() {
		
			 barmodel = new BarChartModel();	
			 BarChartSeries avg = new BarChartSeries();
			 List<Map<String, BigInteger>> produit = userrepository.getAvgRating();
			 for (Map<String, BigInteger> map : produit) {				   
				       avg.set(String.valueOf(map.get("marque_produit")),map.get("avgp"));
		    
				    }
			 avg.setLabel("marque produit");	
			 barmodel.addSeries(avg);
			 barmodel.setTitle("Bar ");
			 barmodel.setLegendPosition("ne");
			 barmodel.setMouseoverHighlight(false);
			 barmodel.setShowDatatip(false);
			 barmodel.setShowPointLabels(true);
			 Axis yAxis = barmodel.getAxis(AxisType.Y);
			 yAxis.setMin(0);
			 yAxis.setMax(100);	
			return barmodel;
		}

		public void setBarmodel(BarChartModel barmodel) {
			this.barmodel = barmodel;
		}
		
		
		//----------------------------------Bar-Chart-Reclamation--------------------------------------------------
		private BarChartModel recmodel;
		
		public BarChartModel getRecmodel() {
		
			recmodel = new BarChartModel();	
			 BarChartSeries avg = new BarChartSeries();
			 List<Map<String, BigInteger>> reclamation = userrepository.getRec();
			 for (Map<String, BigInteger> map : reclamation) {				   
				       avg.set(String.valueOf(map.get("state")),map.get("nbstate"));
		    
				    }
			 avg.setLabel("State of reclamation");	
			 recmodel.addSeries(avg);
			 recmodel.setTitle("Bar ");
			 recmodel.setLegendPosition("ne");
			 recmodel.setMouseoverHighlight(false);
			 recmodel.setShowDatatip(false);
			 recmodel.setShowPointLabels(true);
			 Axis yAxis = recmodel.getAxis(AxisType.Y);
			 yAxis.setMin(0);
			 yAxis.setMax(20);	
			return recmodel;
		}

		public void setRecmodel(BarChartModel recmodel) {
			this.recmodel = recmodel;
		}
}
		