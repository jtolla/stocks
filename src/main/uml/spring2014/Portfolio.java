package uml.spring2014;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uml.spring2014.beans.PortfolioEntity;
import uml.spring2014.beans.PortfolioStockRelationshipEntity;

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
    	/**USE setPortfolio */ 
        return portfolioName;
    }

    public void addStock(Stock stock) {
    	/** take the stock and portfolio and create java beans to pass to SQL methods*/
   	 stock = this.stock;
   	 PortfolioStockRelationshipEntity bean = new PortfolioStockRelationshipEntity();
   	 bean.setPortfolioName(portfolioName);
   	 bean.setStockSymbol(stock.toString());
   	 try {
		PortfolioStockRelationshipTable.insert(bean);
	} catch (SQLException e) {
		/** add correct UI feedback here*/
		e.printStackTrace();
	}
   	 
    }

    public void removeStock(Stock stock) {
    	/** take the stock and portfolio and pass the strings */
    	 stock = this.stock;
    	 PortfolioStockRelationshipTable.deleteStockFromPortfolio(stock.toString(), portfolioName);
    }

    public ArrayList<Stock> displayPortfolio() {
    	
    	ResultSet rs;
        ArrayList<Stock> stocks = new ArrayList<Stock>();
       rs = DatabaseQueries.getPortfolioStockRelationships("SELECT * FROM portfolioStockRelationships WHERE portfolioName = " + portfolioName);
       try {
		while (rs.next()){
				Stock stockSymbol = (Stock) rs.getObject("stockSymbol");
		    stocks.add(stockSymbol);
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return stocks;
    }

	public void setName(String portfolioName2) {
		// TODO Auto-generated method stub delete? 
		
	}

	/** inserts the new portfolio name into the portfolio table 
	 * @author Andrew */
	public static void setPortfolio(String portfolioName) {

		PortfolioEntity bean = new PortfolioEntity();
    	bean.setPortfolioName(portfolioName);
    	boolean result = false;
		try {
			result = PortfolioTable.insert(bean);
		} catch (SQLException e) {
			/** Add correct error message here to the UI*/
			e.printStackTrace();
		}
    	if (result){
    		/** Remove this output and send appropriate Success! message*/
    		System.out.println("The new value for Portfolio name " + bean.getPortfolioName() + " Was inserted");
    	}
		
	}
	/** deletes everything for a portfolio - keeps the stocks in the stock table
	 * @author Andrew */
	public static void deletePortfolio(String portfolioName){
		
		 String bean = portfolioName;
	    	
		    /** Deletes the name of the portfolio from the portfolio table */
	    	if (PortfolioTable.delete(bean)) {
	    		System.out.println("Success deleting " + bean);
	    	} else {
	    		System.out.println("The Portfolio " + " ' " + bean + " ' " + " was not deleted.");
	    	}
	    	
	    	/** Deletes the portfolio stock relationships from the relationship table */
	    	if (PortfolioStockRelationshipTable.deletePortfolioAndContents(bean)) {
	    		System.out.println("Success deleting " + bean + " contents");
	    	} else {
	    		System.out.println("The Portfolio " + " ' " + bean + " ' " + " contents were not deleted.");
	    	}
	    	
	    	
		
	}


}
