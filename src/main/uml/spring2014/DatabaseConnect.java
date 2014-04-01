/*
 * Author Andrew Conniff
 */
package uml.spring2014;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This class supplies the password and user name and connection driver to connect to a MySQL database on the local machine.
 * 
 * ******Change to a try catch to handle the exception in the ui.********************** 
 */
public class DatabaseConnect {
	private static final String USERNAME = "appuser";
	private static final String PASSWORD = "appuser";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/stockportfolio";
	
	public static java.sql.Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD );
		
	}
}



