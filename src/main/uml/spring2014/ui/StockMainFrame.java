package uml.spring2014.ui;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import uml.spring2014.DatabaseQueries;
import uml.spring2014.PortfolioStockRelationshipTable;
import uml.spring2014.Stock;
import uml.spring2014.Portfolio;
import uml.spring2014.StockFetcher;
import uml.spring2014.beans.PortfolioStockRelationshipEntity;
import uml.spring2014.exceptions.*;

/**
 * This frame will add or remove stocks from a users portfolio. 
 * Users can search ticker symbols for data about a stock.
 *
 * @author Sara Gerstung
 */
public class StockMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form StockMainFrame
     */
    public StockMainFrame(Portfolio portfolio) {
        initComponents();
        this.setSize(450,600);
        this.setTitle("Stock Market Portfolio System");
        this.portfolio = portfolio;
        portNameLabel.setText(portfolio.getPortfolioName());
        portNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    private void initComponents() {

	stockPanel = new javax.swing.JPanel();
        portNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JList();
        searchButton = new javax.swing.JButton();
        tickerSearchField = new javax.swing.JTextField();
        symbolLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        volumeLabel = new javax.swing.JLabel();
        yearHighLabel = new javax.swing.JLabel();
        yearLowLabel = new javax.swing.JLabel();
        yearLowField = new javax.swing.JTextField();
        yearHighField = new javax.swing.JTextField();
        volumeField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        symbolField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        newSymbolLabel = new javax.swing.JLabel();
        newSymbolField = new javax.swing.JTextField();
        newPriceLabel = new javax.swing.JLabel();
        newVolumeLabel = new javax.swing.JLabel();
        newYearHighLabel = new javax.swing.JLabel();
        newYearLowLabel = new javax.swing.JLabel();
        newPriceField = new javax.swing.JTextField();
        newVolumeField = new javax.swing.JTextField();
        newYearHighField = new javax.swing.JTextField();
        newYearLowField = new javax.swing.JTextField();
        addStockButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        removeStockButton = new javax.swing.JButton();
        exitButton2 = new javax.swing.JButton();
        clearButton2 = new javax.swing.JButton();
        portfolio = new Portfolio();
        listModel = new DefaultListModel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        stockPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock Information", 2, 1));

        stockList.setBorder(javax.swing.BorderFactory.createTitledBorder("Your Stocks:"));
        stockList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        stockList.setToolTipText("");
        stockList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stockList);
        
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        /** Search label and ticker entry field with text example */
	searchLabel.setText("Search Symbol:");

        tickerSearchField.setFont(new java.awt.Font("Tahoma", 2, 11));
        tickerSearchField.setText("ex: 'TSLA'");
        tickerSearchField.setToolTipText("");
        tickerSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tickerSearchFieldMouseClicked(evt);
            }
        });

	/** Create Labels and text fields to parse Stock data */
        symbolLabel.setText("Symbol:");
	symbolField.setFocusable(false);

        priceLabel.setText("Price:");
	priceField.setFocusable(false);

        volumeLabel.setText("Volume:");
        volumeField.setFocusable(false);

        yearHighLabel.setText("52 Week High:");
        yearHighField.setFocusable(false);

        yearLowLabel.setText("52 Week Low:");
        yearLowField.setFocusable(false);

        newSymbolLabel.setText("Symbol:");
        newSymbolField.setFocusable(false);

        newPriceLabel.setText("Price:");
        newPriceField.setFocusable(false);

        newVolumeLabel.setText("Volume:");
        newVolumeField.setFocusable(false);
        
	newYearHighLabel.setText("52 Week High:");
        newYearHighField.setFocusable(false);
        
	newYearLowLabel.setText("52 Week Low:");
        newYearLowField.setFocusable(false);


        addStockButton.setText("Add Stock");
        addStockButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addStockButtonActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(StockMainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        removeStockButton.setText("Remove Stock");
        removeStockButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stockPanelLayout = new javax.swing.GroupLayout(stockPanel);
        stockPanel.setLayout(stockPanelLayout);
        stockPanelLayout.setHorizontalGroup(
            stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(searchButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(tickerSearchField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(addStockButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(stockPanelLayout.createSequentialGroup()
                                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(yearLowLabel)
                                    .addComponent(yearHighLabel)
                                    .addComponent(volumeLabel)
                                    .addComponent(priceLabel)
                                    .addComponent(symbolLabel)
                                    .addComponent(newSymbolLabel)
                                    .addComponent(newPriceLabel)
                                    .addComponent(newVolumeLabel)
                                    .addComponent(newYearHighLabel)
                                    .addComponent(newYearLowLabel)
                                    .addComponent(portNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(symbolField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(volumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yearHighField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(newYearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newYearHighField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newSymbolField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(stockPanelLayout.createSequentialGroup()
                                .addComponent(removeStockButton, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        stockPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newPriceField, newSymbolField, newVolumeField, newYearHighField, newYearLowField, priceField, symbolField, volumeField, yearHighField, yearLowField});

        stockPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addStockButton, searchButton});

        stockPanelLayout.setVerticalGroup(
            stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(symbolLabel)
                            .addComponent(symbolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(priceLabel)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(volumeLabel)
                            .addComponent(volumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(yearHighLabel)
                            .addComponent(yearHighField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(yearLowLabel)
                            .addComponent(yearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(removeStockButton)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tickerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addStockButton))
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addComponent(newSymbolLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newVolumeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newYearHighLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newYearLowLabel))
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addComponent(newSymbolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newYearHighField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newYearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        stockPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {newPriceField, newPriceLabel, newSymbolField, newSymbolLabel, newVolumeField, newVolumeLabel, newYearHighField, newYearHighLabel, newYearLowField, newYearLowLabel});

        exitButton2.setText("Exit");
        exitButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton2ActionPerformed(evt);
            }
        });

        clearButton2.setText("Clear Form");
        clearButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton2ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton2)
                    .addComponent(exitButton2))
                .addContainerGap())
        );

        pack();
    }
    /** Assuming this fills the list of stocks based on the current portfolio name*/
    static void FillStockList(){
        try{
        	
           String currentPortfolioName = portfolio.getPortfolioName();;
			// String sql = "select * from Portfolio";
           // pst = conn.prepareStatement(sql);
            ResultSet rs = DatabaseQueries.getPortfolioStockRelationships("SELECT * FROM portfoliostockrelationship WHERE portfolioName = " + currentPortfolioName);
            
            while(rs.next()){
                String stock = rs.getString("stockSymbol");
                stockList.setModel(listModel);
                listModel.addElement(stock);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
    /** Closes application */
    private void exitButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
	this.dispose();
    }                                           

    
    /** Clears all text fields, does not clear stockList if items are present. */    
    private void clearButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        newPriceField.setText("");
        newSymbolField.setText("");
        newVolumeField.setText("");
        newYearHighField.setText("");
        newYearLowField.setText("");
        priceField.setText("");
        symbolField.setText("");
        tickerSearchField.setText("ex: 'TSLA'");
        volumeField.setText("");
        yearHighField.setText("");
        yearLowField.setText("");
        
    }                                            

     /** 
      * Checks value entered is not null and equal to four digits. 
      * Catch requires user to enter new value before search is executed.
      * Sends symbol to StockFetcher to retrieve data and parse to text fields.
      * 
      * @throws NoDataException
      */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        try {
                        
            String symbol = tickerSearchField.getText();
            
            if((symbol == null) || (symbol.length() == 0)) {
                    throw new NoDataException("Invalid Symbol");
                } // end if
            
                Stock stock = StockFetcher.getStockData(symbol);
                String price = Double.toString(stock.getCurrentPrice());
                String volume = Integer.toString(stock.getVolume());
                String fiftyTwoWeekHigh = Double.toString(stock.getFiftyTwoWeekHigh());
                String fiftyTwoWeekLow = Double.toString(stock.getFiftyTwoWeekLow());
        
                newPriceField.setText(price);
                newSymbolField.setText(stock.getTickerSymbol());
                newVolumeField.setText(volume);
                newYearHighField.setText(fiftyTwoWeekHigh);
                newYearLowField.setText(fiftyTwoWeekLow);
                
        } catch(NoDataException e) {

                JOptionPane.showConfirmDialog(this, e.getMessage(), "Unable to Search", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
          } // end try catch
    }
    

    /**
     * On mouseclick in tickerSearchField, remove example text and change font to plain.
     */
    private void tickerSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {                                               
        
	tickerSearchField.setText("");
        tickerSearchField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        
    }                                            

     /** 
      * Adds symbol value as an element in stockList and Portfolio array.
      * Checks value entered is not null, and equal to four digits. 
      * Catch requires user to enter new value before search is executed.
      * 
      * @throws NoDataException
      */
    private void addStockButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
	
	try {

                String symbol = newSymbolField.getText();
                String portfolioName = portfolio.getPortfolioName();
                                
                if((symbol == null) || (symbol.length() == 0)) {
                    throw new NoDataException("Invalid Symbol");
                } // end if
                
                Stock.addStockToPortfolio(symbol, portfolioName);
                stockList.setModel(listModel);
                listModel.addElement(symbol);

            } catch(NoDataException e) {

                JOptionPane.showConfirmDialog(this, e.getMessage(), "Unable to Add Stock", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
              } // end try catch
        
    }

    /**
     * Gets selected index from stockList and removes element from list and Portfolio array.
     */
    private void removeStockButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        String symbol = (String)stockList.getSelectedValue();
        Stock stock = StockFetcher.getStockData(symbol);
        
        portfolio.removeStock(stock);
        listModel.remove(stockList.getSelectedIndex());
    }

    /**
     * On mouse click in stockList, query selected symbol and parse data to text fields.
     */
    private void stockListMouseClicked(java.awt.event.MouseEvent evt) {                                       
  
        String symbol = (String)stockList.getSelectedValue();
        
        Stock stock = StockFetcher.getStockData(symbol);
        String price = Double.toString(stock.getCurrentPrice());
        String volume = Integer.toString(stock.getVolume());
        String fiftyTwoWeekHigh = Double.toString(stock.getFiftyTwoWeekHigh());
        String fiftyTwoWeekLow = Double.toString(stock.getFiftyTwoWeekLow());
        
        priceField.setText(price);
        symbolField.setText(stock.getTickerSymbol());
        volumeField.setText(volume);
        yearHighField.setText(fiftyTwoWeekHigh);
        yearLowField.setText(fiftyTwoWeekLow);
        
    }                                              

    // Variables declaration - do not modify
    private javax.swing.JButton addStockButton;
    private javax.swing.JButton clearButton2;
    private javax.swing.JButton exitButton2;
    private javax.swing.JButton removeStockButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField newPriceField;
    private javax.swing.JLabel newPriceLabel;
    private javax.swing.JTextField newSymbolField;
    private javax.swing.JLabel newSymbolLabel;
    private javax.swing.JTextField newVolumeField;
    private javax.swing.JLabel newVolumeLabel;
    private javax.swing.JTextField newYearHighField;
    private javax.swing.JLabel newYearHighLabel;
    private javax.swing.JTextField newYearLowField;
    private javax.swing.JLabel newYearLowLabel;
    private javax.swing.JLabel portNameLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private static javax.swing.JList stockList;
    private javax.swing.JPanel stockPanel;
    private javax.swing.JTextField symbolField;
    private javax.swing.JLabel symbolLabel;
    private javax.swing.JTextField tickerSearchField;
    private javax.swing.JTextField volumeField;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JTextField yearHighField;
    private javax.swing.JLabel yearHighLabel;
    private javax.swing.JTextField yearLowField;
    private javax.swing.JLabel yearLowLabel;
    private static Portfolio portfolio;
    private static DefaultListModel listModel;
    // End of variables declaration
}
