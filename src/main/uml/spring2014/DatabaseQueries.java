package uml.spring2014;
    	/**
    	 * @author Andrew Conniff
    	 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * These methods take a SQL query string as an argument
 * 
 * @author Andrew Conniff
 */
public class DatabaseQueries{
    
    private static ResultSet rs;

    /**
     * Returns a list of stocks in stock table do not use in UI Use Relationship instead
     * 
     * @param Query
     * @return 
     */
    public static ResultSet getStocks(String Query){
        /**Try with resources*/ 
	try(
            Connection conn = DatabaseConnect.getConnection();
            java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(Query);
	){
            StockTable.displayData(rs);

	}catch(SQLException e){
            e.printStackTrace();
	}/* end try/catch */
        
	return rs; 
    }/* end getStocks */
	
    /**
     * Returns a list of portfolio names
     * 
     * @param Query
     * @return 
     */
    public static ResultSet getPortfolios(String Query){
        /**Try with resources*/
	try(
            Connection conn = DatabaseConnect.getConnection();
            java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(Query);
	){
            //PortfolioTable.displayData(rs);
            Portfolio.displayPortfolio(rs);
	
	}catch(SQLException e){
            e.printStackTrace();
	}/* end try/catch */
	
	return rs; 
    }/* end getPortfolios */

    /**
     * Gets the relationship of portfolio and stocks and returns in a ResultSet.
     * 
     * @param Query
     * @return 
     */
    public static ResultSet getPortfolioStockRelationships(String Query){
        /**Try with resources*/
        try(
            Connection conn = DatabaseConnect.getConnection();
            java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(Query);
            
        ){
            PortfolioStockRelationshipTable.displayData(rs);
        }catch(SQLException e){
            e.printStackTrace();
         }/* end try/catch */

        return rs;
        
    }/* end getPortfolioStockRelationship */

}/* end DatabaseQueries */