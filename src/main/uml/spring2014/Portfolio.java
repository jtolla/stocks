package uml.spring2014;

import java.sql.SQLException;
import java.util.ArrayList;

import uml.spring2014.beans.PortfolioEntity;

/**
 * @author jtolla
 *
 * The Portfolio class allows us to instantiate new Portfolio objects with a user-defined name. It contains the
 * displayPortfolio method that returns an array of associated stocks from the database and prints those to the
 * Watch List. It also contains setPortfolio method and deletePortfolio method that allow us to create and remove
 * portfolio instances from the database.
 *
 */
public class Portfolio {

    private Stock stock;
    private String portfolioName;
   
    public Portfolio(){
        /*
         * Stub
         */
    };

    /*
     * Portfolio constructor that accepts a portfolio name as a parameter
     */
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

    /**
     * Return an array of stocks to be looped through and added to the UI watchlist.
     *
     * @return stocks
     */
    public ArrayList<Stock> displayPortfolio() {
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        return stocks;
    }

	public void setName(String portfolioName2) {

        this.portfolioName = portfolioName2;
		
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
