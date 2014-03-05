package src.test.uml.spring2014;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.main.uml.Stock;

/**
 * @author jtolla
 *
 */
public class StockTest {

    private Stock stock;

    @Before
    public void setup() {
        stock = new Stock("TSLA", 0.0, 1, 0.0, 0.0);
    }

    @Test
    public void testStockConstructor() {
        // assertEquals("stock constructor test", stock, new Stock("TSLA", 0.0, 1, 0.0, 0.0));
    }

    @Test
    public void testGetTickerSymbol() {
        assertEquals("get ticker symbol test", stock.getTickerSymbol(), "TSLA");
    }

    @Test
    public void testGetCurrentPrice() {
        assertEquals("get current price test", stock.getCurrentPrice(), 0.0);
    }

    @Test
    public void testGetVolume() {
        // Why am I being forced to cast this as an Object?
        assertEquals("get volume test", (Object) stock.getVolume(), 1);
    }

    @Test
    public void testGetFiftyTwoWeekHigh() {
        assertEquals("get fifty two week high test", stock.getFiftyTwoWeekHigh(), 0.0);
    }

    @Test
    public void testGetFiftyTwoWeekLow() {
        assertEquals("get fifty two week low test", stock.getFiftyTwoWeekLow(), 0.0);
    }

}
