package uml.spring2014;

import java.sql.SQLException;

import uml.spring2014.beans.PortfolioEntity;
import uml.spring2014.beans.PortfolioStockRelationshipEntity;
import uml.spring2014.beans.StockEntity;

/**
 * @author jtolla
 *
 */
public class Stock {

    private String tickerSymbol;
    private Double price;
    private Integer volume;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekLow;

    public Stock(String tickerSymbol, Double price, Integer volume,
                 Double fiftyTwoWeekHigh, Double fiftyTwoWeekLow) {

        this.tickerSymbol = tickerSymbol;
        this.price = price;
        this.volume = volume;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;

    }

    public String getTickerSymbol() {


        return tickerSymbol;
    }

    public Double getCurrentPrice() { return price; }

    public Integer getVolume() { return volume; }

    public Double getFiftyTwoWeekHigh() { return fiftyTwoWeekHigh; }

    public Double getFiftyTwoWeekLow() { return fiftyTwoWeekLow; }
    
    public static void addStockToPortfolio(String stock, String portfolio) throws SQLException {
    	/**
    	 * @author Andrew Conniff
    	 */
    	int portfolioId = 0;
    	int stockId = 0;
    	String stockSymbol = null;
    	String portfolioName = null;
    	
    	/*Take the stock argument and try to get the Id from the row in the stock table
    	 
    	 * this returns the original stock text and the new ID*/
    	StockEntity bean = StockTable.getRow(stock);
    	if (bean == null){
    		
    		/* If the bean is null then add the stock to the stock table */
    		StockEntity bean1 = new StockEntity();
        	bean1.setStockSymbol(stock);
           /*if the result is true then we assign new values to local variables */
        	boolean result = StockTable.insert(bean1);
	        	if (result){
	        		stockId = bean1.getStockId();
	        		stockSymbol =  bean1.getstockSymbol();
	        	}else {
	        		/*Error message - unable to get stock id from database*/
	        	}
    		
    	}else{
    		/*bean is not null; assign the existing ID and stockSymbol to local variables*/
    		stockId =  bean.getStockId();
    		stockSymbol = bean.getstockSymbol();
    	}
    	
    	/*Get Portfolio ID from portfolio table, assign the variables then insert all of these into the relationship table. */
    	PortfolioEntity bean2 = PortfolioTable.getRow(portfolio);
    		if (bean2 == null){
    			/*something went wrong - */ 
    		} else {
    			portfolioId = bean2.getPortfolioId();
    			portfolioName = bean2.getPortfolioName();
    		}
    		
    		PortfolioStockRelationshipEntity bean3 = new PortfolioStockRelationshipEntity();
    		
    			if ((portfolioId < 1) && (stockId < 1) && (stockSymbol != null) && (portfolioName != null))
    			{
    				/*Something went wrong and a variable is not set */
    			} else {
    				/*Set the bean object parameters */
    				bean3.setStockId(stockId);
    				bean3.setStockSymbol(stockSymbol);
    				bean3.setPortfolioId(portfolioId);
    				bean3.setPortfolioName(portfolioName);
    			}
    		
    	/*Insert the variables into the relationship table in order*/
    		boolean insertResult = PortfolioStockRelationshipTable.insert(bean3);
    		if (insertResult){ 
    			/*Add Success message*/
    		} else {
    			/*Add error message*/
    		}

    }

}

