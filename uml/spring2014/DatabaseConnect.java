/*
 * Author Andrew Conniff
 */
package uml.spring2014;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnect {
	private static final String USERNAME = "appuser";
	private static final String PASSWORD = "appuser";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/stockportfolio";
	
	public static java.sql.Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD );
		
	}
}



