package uml.spring2014;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uml.spring2014.beans.PortfolioStockRelationshipEntity;

public class PortfolioStockRelationshipTable {

	

	public static void displayData (ResultSet rs) throws SQLException
	{
		while (rs.next()){
			int relId = rs.getInt("relationshipId");
			System.out.println(relId);
		}
		
	}
	

public static PortfolioStockRelationshipEntity getRow(int relationshipId) throws SQLException {
	
	/*
	 * returns a single row from
	 */
	String sql = "SELECT * FROM portfoliostockrelationship WHERE relationshipId = ?";
	ResultSet rs = null;
	/* Try with resources */
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
	
public static boolean insert ( PortfolioStockRelationshipEntity bean) throws SQLException
{
	String sql = "INSERT INTO  portfolioStockRelationship (idstock, stockSymbol, portfolioId, portfolioName) " + "VALUES (?, ?, ?, ?)";
	
	/*
	 * ResultSet Keys holds the system generated key value for the new row in this table
	 */
	ResultSet keys = null;
	/* Try with resources */
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
		/*
		 * assign the variables ? to the SQL string from left to right using stmt.set<data type>(?, bean.get<data>) format.
		 */
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
/*
 * next here
 */
public static boolean deleteStockFromPortfolio(String stockSymbol){
	String sql = "DELETE from portfolioStockRelationship WHERE stockSymbol = ?";
	
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
