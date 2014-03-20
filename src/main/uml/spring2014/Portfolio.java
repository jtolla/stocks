package uml.spring2014;

import java.util.ArrayList;

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

    }

    public void removeStock(Stock stock) {

    }

    public ArrayList<Stock> displayPortfolio() {
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        return stocks;
    }



}
