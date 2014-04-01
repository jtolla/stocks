package uml.spring2014;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uml.spring2014.beans.PortfolioEntity;


/*
 * This is the Adminmanager table
 * 
 */
public class PortfolioTable {
	

	

	public static void displayData (ResultSet rs) throws SQLException
	{
		while (rs.next()){
			String portfolioNames = rs.getString("portfolioName");
			System.out.println(portfolioNames);
		}
		
	}
	

public static PortfolioEntity getRow(int portfolioId) throws SQLException {
	
	String sql = "SELECT * FROM portfolio WHERE portfolioId = ?";
	ResultSet rs = null;
	/* Try with resources */
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
		stmt.setInt(1, portfolioId);
		rs = stmt.executeQuery();
		
		if (rs.next()){
			PortfolioEntity bean = new PortfolioEntity();
			bean.setPortfolioId(portfolioId);
			bean.setPortfolioName(rs.getString("portfolioName"));
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
	
public static boolean insert(PortfolioEntity bean) throws SQLException
{
	String sql = "INSERT INTO portfolio (portfolioName) " + "VALUES (?)";
	ResultSet keys = null;
	/* Try with resources */
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
		
		stmt.setString(1, bean.getPortfolioName());
		int affected = stmt.executeUpdate();
		if (affected == 1){
			keys = stmt.getGeneratedKeys();
			keys.next();
			int newKey = keys.getInt(1);
			bean.setPortfolioId(newKey);
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
public static boolean delete(String portfolioName){
	
	
	String sql = "DELETE from portfolio WHERE portfolioName = ?";
	
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
