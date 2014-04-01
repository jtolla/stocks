package uml.spring2014;
/*
This is the "AdminManager" table 
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uml.spring2014.beans.StockEntity;

public class StockTable {
	

	public static void displayData (ResultSet rs) throws SQLException
	{
		while (rs.next()){
			String stockTickers = rs.getString("stockSymbol");
			System.out.println(stockTickers);
		}
		
	}
	
	
	/*
	 * returns a single row
	 */
public static StockEntity getRow(String stockSymbol) throws SQLException {
	
	String sql = "SELECT * FROM stock WHERE stockSymbol = ?";
	ResultSet rs = null;
	/* Try with resources */
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
		stmt.setString(1, stockSymbol);
		rs = stmt.executeQuery();
		
		if (rs.next()){
			StockEntity bean = new StockEntity();
			bean.setStockSymbol(stockSymbol);
			bean.setStockId(rs.getInt("idstock"));
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
	
public static boolean insert (StockEntity bean) throws SQLException
{
	String sql = "INSERT INTO stock (stockSymbol) " + "VALUES (?)";
	ResultSet keys = null;
	/* Try with resources */
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
		
		stmt.setString(1, bean.getstockSymbol());
		int affected = stmt.executeUpdate();
		if (affected == 1){
			keys = stmt.getGeneratedKeys();
			keys.next();
			int newKey = keys.getInt(1);
			bean.setStockId(newKey);
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
/*
 * next here
 */
public static boolean delete(String stockSymbol){
	String sql = "DELETE from stock WHERE stockSymbol = ?";
	
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
		
		stmt.setString(1, stockSymbol);
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