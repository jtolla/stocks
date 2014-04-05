package uml.spring2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import uml.spring2014.Stock;

import javax.swing.*;


/**
 * This method fetches stock data via the Yahoo Finance API. The stock symbol is inserted
 * into the URL. The response is a csv file which includes the desired data as defined in
 * the last parameter of the query string. The CSV is then parsed and all data is stored
 * in an array. A new Stock instance is returned.
 * 
 * @author Jason Tolla - special thanks to natehefner & erbycfischer (GitHub)
 *
 */
public class StockFetcher {

    
    public StockFetcher() {
        // Stub
    }
    
    /**
     * Gets stock info based on symbol sent from UI.
     * 
     * @param tickerSymbol
     * @return 
     */
    public static Stock getStockData(String tickerSymbol) {

        String symbol           = tickerSymbol.toUpperCase();
        double price            = 0.0;
        int volume              = 0;
        double fiftyTwoWeekLow  = 0.0;
        double fiftyTwoWeekHigh = 0.0;

        try {

            // Create a URL instance using the tickerSymbol parameter
            URL yahooFinance = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=l1vr2ejkghm3j3");
            // Connect to the URL
            URLConnection connection = yahooFinance.openConnection();
            // Get the CSV
            InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
            // Buffer the input
            BufferedReader bufferedReader = new BufferedReader(inputStream);

            // Grab the row of data
            String line = bufferedReader.readLine();
            // Parse the resulting comma delimited string
            String[] stockData = line.split(",");

            // Handle any data returned as "N/A"
            price = handleDoubleHelper(stockData[0]);
            volume = handleIntegerHelper(stockData[1]);
            fiftyTwoWeekLow = handleDoubleHelper(stockData[4]);
            fiftyTwoWeekHigh = handleDoubleHelper(stockData[5]);

        } catch (IOException e) {

            // - HANDLE THIS - Log messages if API call fails
            Logger log = Logger.getLogger(Stock.class.getName());
            log.log(Level.SEVERE, e.toString(), e);

        }

        // Return an instance of Stock using newly attained data in the constructor
        return new Stock(symbol, price, volume, fiftyTwoWeekHigh, fiftyTwoWeekLow);
    } /* end getStockData */

    /**
     * Helper method used to handle "N/A" values when Double is expected.
     * 
     * @param x
     * @return 
     */
    public static double handleDoubleHelper(String x) {
        Double y;
        if (Pattern.matches("N/A", x)) {
            y = 0.0;
        } else {
            y = Double.parseDouble(x);
        }
        return y;
    } /* end handleDoubleHelper */

    /**
     * Helper method used to handle "N/A" values when Integer is expected.
     * 
     * @param x
     * @return 
     */
    public static int handleIntegerHelper(String x) {
        int y;
        if (Pattern.matches("N/A", x)) {
            y = 0;
        } else {
            y = Integer.parseInt(x);
        }
        return y;
    } /* end handleIntegerHelper */

} /* end StockFetcher */

