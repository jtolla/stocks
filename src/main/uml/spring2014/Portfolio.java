package uml.spring2014;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uml.spring2014.beans.PortfolioEntity;

/**
 * The Portfolio class allows us to instantiate new Portfolio objects with a user-defined name. It contains the
 * displayPortfolio method that returns an array of associated stocks from the database and prints those to the
 * Watch List. It also contains setPortfolio method and deletePortfolio method that allow us to create and remove
 * portfolio instances from the database.
 * 
 * @author Jason Tolla
 */
public class Portfolio {

    private Stock stock;
    private String portfolioName;
   
    public Portfolio(){
        // stub
    };

    /**
     * Portfolio constructor that accepts a portfolio name as a parameter
     * 
     * @param portfolioName 
     */
    public Portfolio(String portfolioName) {
        this.portfolioName = portfolioName;
    }
    
    /**
     * Getter for portfolioName variable
     * @return 
     */
    public String getPortfolioName() {
        return portfolioName;
    }
    
    /**
     * 
     * @param portfolioName2 
     */
    public void setName(String portfolioName2) {
        this.portfolioName = portfolioName2;
    }

    /**
     * 
     * @param stock 
     */
    public void addStock(Stock stock) {
      stock = this.stock;
    }

    /**
     * 
     * @param stock 
     */
    public void removeStock(Stock stock) {
    	 stock = this.stock;
    }

    /**
     * Return an array of stocks to be looped through and added to the UI watchlist.
     *
     * @return stocks
     * @throws SQLException
     */
    public static ArrayList<String> displayPortfolio(ResultSet rs) throws SQLException{
	
        ArrayList<String> PortfolioArray = new ArrayList<>();
    	
        try {
            while(rs.next()){
            PortfolioArray.add(rs.getString(1)); 
            }
	}catch(SQLException e){
		System.out.println("The Result Set is NULL or " + rs);
	}/* end try/catch */
               
        return PortfolioArray;
    } /* end displayPortfolio */

    /**
     * inserts the new portfolio name into the portfolio table
     * 
     * @param portfolioName
     * @author Andrew Conniff
     */
    public static void setPortfolio(String portfolioName){

        PortfolioEntity bean = new PortfolioEntity();
    	bean.setPortfolioName(portfolioName);
    	boolean result = false;
	
        try {
            result = PortfolioTable.insert(bean);
	}catch(SQLException e){
            e.printStackTrace();
	}/* end try/catch */
    	
        if(result){
            
            System.out.println("The new value for Portfolio name " + bean.getPortfolioName() + " Was inserted");
    	}/* end if */
		
    }/* end setPortfolio */

    /**
     * deletes everything for a portfolio - keeps the stocks in the stock table
     * 
     * @param portfolioName
     * @throws SQLException 
     */
    public static void deletePortfolio(String portfolioName) throws SQLException{
        String bean = portfolioName;
	 	
	/** Deletes the name of the portfolio from the portfolio table */
	if(PortfolioTable.delete(bean)) {
            System.out.println("Success deleting " + bean);
	}else{
	    System.out.println("The Portfolio " + " ' " + bean + " ' " + " was not deleted.");
	 }/* end if else */
	    	
	/** Deletes the portfolio stock relationships from the relationship table */
	if (PortfolioStockRelationshipTable.deletePortfolioAndContents(bean)) {
            System.out.println("Success deleting " + bean + " contents");
	}else{
	    System.out.println("The Portfolio " + " ' " + bean + " ' " + " contents were not deleted.");
	 }/* end if else */	    	
		
    }/* end deletePortfolio */

}/* end Portfolio */