package uml.spring2014.beans;

/*
		This is the "Admin" table representing the rows of the stock table
		*/


public class StockEntity {
	

private int stockId;
private String stockSymbol;

public int getStockId() {
	return stockId;
}
public void setStockId(int stockId) {
	this.stockId = stockId;
}
public String getstockSymbol() {
	return stockSymbol;
}
public void setStockTicker(String stockSymbol) {
	this.stockSymbol = stockSymbol;
}


}
