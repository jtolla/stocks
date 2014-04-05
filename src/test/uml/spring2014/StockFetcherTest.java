package spring2014;

import org.junit.Before;
import org.junit.Test;
import uml.spring2014.StockFetcher;
import uml.spring2014.Stock;

/**
 * @author jtolla
 *
 * Test the Yahoo Finance API call
 */
public class StockFetcherTest {

    @Before
    public void setup() {
        // No setup required
    }

    /**
     * Test API call by pinging Yahoo and requesting current price, volume, 52 week high and low for TSLA
     */
    @Test
    public void testGetStockData() {

        Stock tesla = StockFetcher.getStockData("TSLA");
        System.out.println("Current Price: " + tesla.getCurrentPrice());
        System.out.println("Volume: " + tesla.getVolume());
        System.out.println("52 Week Low: " + tesla.getFiftyTwoWeekHigh());
        System.out.println("52 Week High: " + tesla.getFiftyTwoWeekLow());

    }

}
