package uml.spring2014;
/**
* @author Andrew Conniff
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uml.spring2014.beans.PortfolioStockRelationshipEntity;

public class PortfolioStockRelationshipTable {

/**
* !Important - send the query "SELECT * FROM portfolioStockRelationship */	

public static void displayData (ResultSet rs) throws SQLException
{
while (rs.next()){
String stockSymbol = rs.getString("stockSymbol");
/** send list to the array list for the UI instead and remove the following line */
System.out.println(stockSymbol);
}

}


public static PortfolioStockRelationshipEntity getRow(int relationshipId) throws SQLException {

/** returns a single row from the relationship table when you know the relationship ID - not used in UI */
String sql = "SELECT * FROM portfoliostockrelationship WHERE relationshipId = ?";
ResultSet rs = null;
/** Try with resources */
try (
Connection conn = DatabaseConnect.getConnection();
PreparedStatement stmt = conn.prepareStatement(sql);
){
stmt.setInt(1, relationshipId);
rs = stmt.executeQuery();

if (rs.next()){
PortfolioStockRelationshipEntity bean = new PortfolioStockRelationshipEntity();
bean.setPortfolioId(relationshipId);
bean.setPortfolioName(rs.getString("portfolioName"));
bean.setStockSymbol(rs.getString("stockSymbol"));

return bean;
} else {

return null;
}

}catch (SQLException e){
System.err.println(e);
return null;
}finally {
if (rs != null){
rs.close();
}
}

}
/**
* !Important - This is how we Insert a stock into the relationship table
*
**/
public static boolean insert ( PortfolioStockRelationshipEntity bean) throws SQLException
{
String sql = "INSERT INTO portfolioStockRelationship (idstock, stockSymbol, portfolioId, portfolioName) " + "VALUES (?, ?, ?, ?)";

/** ResultSet Keys holds the system generated key value for the new row in this table*/
ResultSet keys = null;
/** Try with resources */
try (
Connection conn = DatabaseConnect.getConnection();
PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
){
/** assign the variables ? to the SQL string from left to
* right using stmt.set<data type>(?, bean.get<data>) format.*/
stmt.setInt(1, bean.getStockId());
stmt.setString(2, bean.getStockSymbol());
stmt.setInt(3, bean.getPortfolioId());
stmt.setString(4, bean.getPortfolioName());

int affected = stmt.executeUpdate();
if (affected == 1){
keys = stmt.getGeneratedKeys();
keys.next();
int newKey = keys.getInt(1);
bean.setRelationshipId(newKey);
} else {
System.err.println("No rows were affected");
return false;
}

} catch (SQLException e){
System.err.println(e);
return false;
} finally {
if (keys != null) keys.close();
}
return true;
}
/**
* !Important - this is how we delete
* a stock from a portfolio */

public static boolean deleteStockFromPortfolio(String stockSymbol, String portfolioName){
String sql = "DELETE from portfolioStockRelationship WHERE stockSymbol = ?, ?";

try (
Connection conn = DatabaseConnect.getConnection();
PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
){

stmt.setString(1, stockSymbol);
stmt.setString(2, portfolioName);
int affected = stmt.executeUpdate();

if (affected == 1 ){
return true;
} else {
return false;
}

} catch (SQLException e) {
System.err.println(e);
return false;
}

}
/**
* !Important -
* this is how we delete an entire portfolio
* and its stocks from the relationship table */

public static boolean deletePortfolioAndContents(String portfolioName){
String sql = "DELETE from portfolioStockRelationship WHERE portfolioName = ?";

try (
Connection conn = DatabaseConnect.getConnection();
PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
){

stmt.setString(1, portfolioName);
int affected = stmt.executeUpdate();

if (affected == 1 ){
return true;
} else {
return false;
}

} catch (SQLException e) {
System.err.println(e);
return false;
}


}

}