package uml.spring2014;

import java.sql.SQLException;

import uml.spring2014.beans.PortfolioEntity;
import uml.spring2014.beans.PortfolioStockRelationshipEntity;
import uml.spring2014.beans.StockEntity;

/**
 * The Stock class is used to instantiate new Stock objects. Those objects have simple get methods that return
 * data fetched from the API. The actual API call is done in the StockFetcher class. The Stock object is simply a
 * data store. It also allows contains the addToStockPortfolio method which will add the stock to the relevant
 * portfolio in the database.
 * 
 * @author Jason Tolla
 */
public class Stock {

    private String tickerSymbol;
    private Double price;
    private Integer volume;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekLow;
    
    /**
     * Stock Constructor.
     * @param tickerSymbol stockSymbol
     * @param price a value of a single share
     * @param volume
     * @param fiftyTwoWeekHigh highest share price in last year
     * @param fiftyTwoWeekLow lowest share price in last year
     */
    public Stock(String tickerSymbol, Double price, Integer volume,
                 Double fiftyTwoWeekHigh, Double fiftyTwoWeekLow) {

        this.tickerSymbol = tickerSymbol;
        this.price = price;
        this.volume = volume;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;

    }
    
    /**
     * Getter for stockSymbol variable.
     * @return 
     */
    public String getTickerSymbol() {
        return tickerSymbol;
    }
    
    /**
     * Getter for price variable.
     * @return 
     */
    public Double getCurrentPrice() {
        return price;
    }
    
    /**
     * Getter for volume variable.
     * @return
     */
    public Integer getVolume() {
        return volume;
    }
    
    /**
     * Getter for 52 week high.
     * @return 
     */
    public Double getFiftyTwoWeekHigh() { return fiftyTwoWeekHigh; }

    /**
     * Getter for 52 week low.
     * @return 
     */
    public Double getFiftyTwoWeekLow() { return fiftyTwoWeekLow; }
    
    /**
     * Associates stocks to the portfolio that is open.
     * 
     * @param stock
     * @param portfolio
     * @throws SQLException
     * @author Andrew Conniff
     */
    public static void addStockToPortfolio(String stock, String portfolio) throws SQLException {
    	
        int portfolioId = 0;
        int stockId = 0;
        String stockSymbol = null;
        String portfolioName = null;
    	
    	/** 
         * Take the stock argument and try to get the Id from the row in the stock table
    	 * this returns the original stock text and the new ID
         */
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
	        }else{
                    System.err.println("Unable to get stock id from database");
	        }
    		
    	}else{
            /*bean is not null; assign the existing ID and stockSymbol to local variables*/
            stockId =  bean.getStockId();
            stockSymbol = bean.getstockSymbol();
    	} /* end if else */
    	
    	/*Get Portfolio ID from portfolio table, assign the variables then insert all of these into the relationship table. */
    	PortfolioEntity bean2 = PortfolioTable.getRow(portfolio);
            if (bean2 == null){
                System.err.println("Unable to get portfolio id from database");
            }else{
    		portfolioId = bean2.getPortfolioId();
    		portfolioName = bean2.getPortfolioName();
            } /* end if else */
    		
            PortfolioStockRelationshipEntity bean3 = new PortfolioStockRelationshipEntity();
    	
            if ((portfolioId < 1) && (stockId < 1) && (stockSymbol != null) && (portfolioName != null)){
                System.err.println("Variable not set");
            }else{
    		/*Set the bean object parameters */
    		bean3.setStockId(stockId);
    		bean3.setStockSymbol(stockSymbol);
    		bean3.setPortfolioId(portfolioId);
    		bean3.setPortfolioName(portfolioName);
            } /* end if else */
    		
            /*Insert the variables into the relationship table in order*/
            boolean insertResult = PortfolioStockRelationshipTable.insert(bean3);
            if (insertResult){ 
                System.err.println("Variable inserted to relationship table");
            } else {
                System.err.println("Variable not inserted to relationship table");
            }/* end if else */

    } /* end addStockToPortfolio */

} /* end Stock */

