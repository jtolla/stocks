package uml.spring2014;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * @author jtolla
 *
 */
public class PortfolioTest {

    private Portfolio portfolio;

    @Before
    public void setup() {
        portfolio = new Portfolio("My Portfolio");
    }

    @Test
    public void testPortfolioConstruction() {
        assertEquals("portfolio constructor test", portfolio.getPortfolioName(), "My Portfolio");
    }

    @Test
    public void testAddStock() {

    }

    @Test
    public void testRemoveStock() {

    }

    @Test
    public void testDisplayPortfolio() {

    }

}
