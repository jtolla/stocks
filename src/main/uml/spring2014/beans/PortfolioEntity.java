package uml.spring2014.beans;
/**
 * @author Andrew Conniff
 */

public class PortfolioEntity {
	
	
	private int	portfolioId;
	private String portfolioName;

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}


}
