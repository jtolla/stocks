package spring2014;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import uml.spring2014.Stock;

/**
 * @author jtolla
 *
 * Test the stock class. These tests get information from the stock object rather the API.
 */
public class StockTest {

    private Stock stock;

    /**
     * Setup test
     */
    @Before
    public void setup() {
        stock = new Stock("TSLA", 0.0, 1, 0.0, 0.0);
    }

    /**
     * Test getTickerSymbol
     */
    @Test
    public void testGetTickerSymbol() {
        assertEquals("get ticker symbol test", stock.getTickerSymbol(), "TSLA");
    }

    /**
     * Test getCurrentPrice
     */
    @Test
    public void testGetCurrentPrice() {
        assertEquals("get current price test", (Object) stock.getCurrentPrice(), 0.0);
    }

    /**
     * Test getGetVolume
     */
    @Test
    public void testGetVolume() {
        assertEquals("get volume test", (Object) stock.getVolume(), 1);
    }

    /**
     * Test getFiftyTwoWeekHigh
     */
    @Test
    public void testGetFiftyTwoWeekHigh() {
        assertEquals("get fifty two week high test", (Object) stock.getFiftyTwoWeekHigh(), 0.0);
    }

    /**
     * Test getFiftyTwoWeekLow
     */
    @Test
    public void testGetFiftyTwoWeekLow() {
        assertEquals("get fifty two week low test", (Object) stock.getFiftyTwoWeekLow(), 0.0);
    }

}
