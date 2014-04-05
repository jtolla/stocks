package spring2014;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import uml.spring2014.Portfolio;

/**
 * @author jtolla
 *
 * This class tests the Portfolio object.
 */
public class PortfolioTest {

    private Portfolio portfolio;

    /**
     * Setup the test
     */
    @Before
    public void setup() {
        portfolio = new Portfolio("My Portfolio");
    }

    /**
     * Test the Portfolio constructor by calling getPortfolioName
     */
    @Test
    public void testPortfolioConstruction() {
        assertEquals("portfolio constructor test", portfolio.getPortfolioName(), "My Portfolio");
    }

}
