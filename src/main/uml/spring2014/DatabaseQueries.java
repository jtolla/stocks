package uml.spring2014;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * These methods take a SQL query string as an argument 
 */

public class DatabaseQueries  {

	/*
	 * Variable all of these queries use
	 */
	private static ResultSet rs;

	
	/*
	 * Returns a list of stocks in stock table 
	 */
	public static ResultSet getStocks(String Query)
	
	{
	//Try with resources
	try (
			Connection conn = DatabaseConnect.getConnection();
			java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(Query);
			){
		StockTable.displayData(rs);
		//String stockResults = rs.getString("stock");
		//System.out.println("Number of rows " + stockResults);
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rs; 
	}
	
	/*
	 * Returns a list of portfolio names
	 */
public static ResultSet getPortfolios(String Query)
	
	{
	//Try with resources
	try (
			Connection conn = DatabaseConnect.getConnection();
			java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(Query);
			){
		PortfolioTable.displayData(rs);
		//String stockResults = rs.getString("stock");
		//System.out.println("Number of rows " + stockResults);
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rs; 
	}

public static ResultSet getPortfolioStockRelationships(String Query)

{
//Try with resources
try (
		Connection conn = DatabaseConnect.getConnection();
		java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(Query);
		){
	PortfolioStockRelationshipTable.displayData(rs);
	//String stockResults = rs.getString("stock");
	//System.out.println("Number of rows " + stockResults);

	
} catch (SQLException e) {
	e.printStackTrace();
}

return rs; 
}

}
