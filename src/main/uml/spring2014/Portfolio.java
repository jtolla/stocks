package uml.spring2014;

import java.sql.SQLException;
import java.util.ArrayList;

import uml.spring2014.beans.PortfolioEntity;

/**
 * @author jtolla
 *
 */
public class Portfolio {

    private Stock stock;
    private String portfolioName;
   
    public Portfolio(){
    
    };

    public Portfolio(String portfolioName) {
        this.portfolioName = portfolioName;
    	
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void addStock(Stock stock) {
      stock = this.stock;
    }

    public void removeStock(Stock stock) {
    	 stock = this.stock;
    }

    public ArrayList<Stock> displayPortfolio() {
    	
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        return stocks;
    }

	public void setName(String portfolioName2) {
		// TODO Auto-generated method stub
		
	}

	public static void setPortfolio(String portfolioName) {
		
		PortfolioEntity bean = new PortfolioEntity();
    	bean.setPortfolioName(portfolioName);
    	boolean result = false;
		try {
			result = PortfolioTable.insert(bean);
		} catch (SQLException e) {
			//Add correct error message here
			e.printStackTrace();
		}
    	if (result){
    		System.out.println("The new value for Portfolio name " + bean.getPortfolioName() + " Was inserted");
    	}
		
	}
	public static void deletePortfolio(String portfolioName){
		
		 String bean = portfolioName;
	    	
		    /* Deletes the name of the portfolio from the portfolio table */
	    	if (PortfolioTable.delete(bean)) {
	    		System.out.println("Success deleting " + bean);
	    	} else {
	    		System.out.println("The Portfolio " + " ' " + bean + " ' " + " was not deleted.");
	    	}
	    	
	    	/* Deletes the portfolio stock relationships from the relationship table */
	    	if (PortfolioStockRelationshipTable.deletePortfolioAndContents(bean)) {
	    		System.out.println("Success deleting " + bean + " contents");
	    	} else {
	    		System.out.println("The Portfolio " + " ' " + bean + " ' " + " contents were not deleted.");
	    	}
	    	
	    	
		
	}


}
