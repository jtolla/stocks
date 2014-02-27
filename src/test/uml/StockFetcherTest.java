package test.java;

import main.java.StockFetcher;
import main.java.Stock;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jtolla
 *
 */
public class StockFetcherTest {

    @Before
    public void setup() {
        // No setup required
    }

    @Test
    public void testGetStockData() {

        Stock tesla = StockFetcher.getStockData("TSLA");
        System.out.println("Current Price: " + tesla.getCurrentPrice());
        System.out.println("Volume: " + tesla.getVolume());
        System.out.println("52 Week Low: " + tesla.getFiftyTwoWeekHigh());
        System.out.println("52 Week High: " + tesla.getFiftyTwoWeekLow());

    }

}
