package uml.spring2014;
    	/**
    	 * @author Andrew Conniff
    	 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**These methods take a SQL query string as an argument */
public class DatabaseQueries  {

	
	private static ResultSet rs;

	
	/** Returns a list of stocks in stock table do not use in UI Use Relationship instead */
	public static ResultSet getStocks(String Query)
	
	{
		/**Try with resources*/ 
	try (
			Connection conn = DatabaseConnect.getConnection();
			java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(Query);
			){
		StockTable.displayData(rs);

		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rs; 
	}
	
	/** Returns a list of portfolio names*/
public static ResultSet getPortfolios(String Query)
	
	{
	/**Try with resources*/
	try (
			Connection conn = DatabaseConnect.getConnection();
			java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(Query);
			){
		//PortfolioTable.displayData(rs);
		Portfolio.displayPortfolio(rs);
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rs; 
	}

public static ResultSet getPortfolioStockRelationships(String Query)

{
	/**Try with resources*/
try (
		Connection conn = DatabaseConnect.getConnection();
		java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(Query);
		){
	PortfolioStockRelationshipTable.displayData(rs);

} catch (SQLException e) {
	e.printStackTrace();
}

return rs; 
}

}