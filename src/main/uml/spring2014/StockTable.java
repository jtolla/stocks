package uml.spring2014;
/**
 * @author Andrew Conniff
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uml.spring2014.beans.StockEntity;

/**
 * This class is designed to interact with the stock table.
 * 
 * @author Andrew Conniff
 */
public class StockTable {
	
    /**
     * returns list of all stocks if the query is correct 
     * Not used for display to sending to the array list
     * 
     * @param rs
     * @throws SQLException 
     */
    public static void displayData (ResultSet rs) throws SQLException {
        while (rs.next()){
            String stockTickers = rs.getString("stockSymbol");
            System.out.println(stockTickers);
        }/* end while */
    }/* end displayData*/

    /**
     * returns a single row from the stock table
     * 
     * @param stockSymbol
     * @return
     * @throws SQLException 
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
            }finally{
                if (rs != null){
                rs.close();
                }
            }/* end try/catch/finally block*/

    }/** end getRow */

    /**
     * adds a stockSymbol to the stock table
     * 
     * @param bean
     * @return
     * @throws SQLException 
     */
    public static boolean insert (StockEntity bean) throws SQLException {
        String sql = "INSERT INTO stock (stockSymbol) " + "VALUES (?)";
        ResultSet keys = null;
        /** Try with resources */
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
            } /* end try/catch/finally */
            return true;

    }/* end insert */

    /**
     * Future use - we would use this to clean this table up if the stock
     * does not exist in the relationship table (does not belong to a portfolio)
     * 
     * @param stockSymbol
     * @return 
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
            } /* end try/catch */

    } /* end delete */


} /* end StockTable */