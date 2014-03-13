package src.test.uml.spring2014;

import org.junit.Before;
import org.junit.Test;

import src.main.uml.Stock;
import src.main.uml.StockFetcher;

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
