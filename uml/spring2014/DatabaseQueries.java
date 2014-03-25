package uml.spring2014;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueries  {

	
	private static ResultSet rs;

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
}
