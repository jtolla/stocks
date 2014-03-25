package uml.spring2014;
/*
This is the "AdminManager" table 
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uml.spring2014.beans.StockEntity;

public class StockTable {
	

	public static void displayData (ResultSet rs) throws SQLException
	{
		while (rs.next()){
			String stockTickers = rs.getString("stockSymbol");
			System.out.println(stockTickers);
		}
		
	}
	

public static StockEntity getRow(int stockid) throws SQLException {
	
	String sql = "SELECT * FROM stock WHERE idstock = ?";
	ResultSet rs = null;
	/* Try with resources */
	try (
			Connection conn = DatabaseConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
		stmt.setInt(1, stockid);
		rs = stmt.executeQuery();
		
		if (rs.next()){
			StockEntity bean = new StockEntity();
			bean.setStockId(stockid);
			bean.setStockTicker(rs.getString("stockSymbol"));
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
	

}
