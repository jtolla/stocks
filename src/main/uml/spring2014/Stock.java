package uml.spring2014;

import java.sql.SQLException;

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
    	int portfolioId;
    	int stockId;
    	String stockSymbol;
    	String PortfolioName;
    	
    	StockEntity bean = StockTable.getRow(stock);
    	if (bean == null){
    		/* Add stock to stock table and get back the id  */
    	  	
    		StockEntity bean1 = new StockEntity();
        	
        	bean1.setStockSymbol(stock);

        	boolean result = StockTable.insert(bean);
        	if (result){
        		stockId = bean1.getStockId();
        		stockSymbol =  bean1.getstockSymbol();
        	}
    		
    	}else{
    		/*result is not null insert result into relationship table with portfolio name.*/
    		stockId =  bean.getStockId();
    		stockSymbol = bean.getstockSymbol();
    	}
    	
    	/*Get Portfolio ID from portfolio table, assign the variables then insert all of these into the relationship table. */
    	
    }

}

