package main.java;

import java.util.ArrayList;

/**
 * Created by aconniff, sgerstrung and jtolla on 2/12/14.
 */
public class Portfolio {

    private Stock stock;
    private String portfolioName;
   

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
