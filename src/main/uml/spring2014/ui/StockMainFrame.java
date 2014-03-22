package uml.spring2014.ui;

import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.Font;
import uml.spring2014.Stock;
import uml.spring2014.Portfolio;
import uml.spring2014.StockFetcher;
import uml.spring2014.exceptions.*;

/**
 *
 * @author Sara
 */
public class StockMainFrame extends javax.swing.JFrame {

    Portfolio portfolio = new Portfolio();

    /**
     * Creates new form StockMainFrame
     */
    public StockMainFrame() {
        initComponents();
        this.setSize(450,550);
        this.setTitle("Stock Market Portfolio System");
        portNameField.setText(portfolio.getPortfolioName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    private void initComponents() {

	stockPanel = new javax.swing.JPanel();
        portNameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
	listModel = new DefaultListModel();
        stockList = new javax.swing.JList(listModel);
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
        exitButton2 = new javax.swing.JButton();
        clearButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));

        stockPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock Information", 2, 1));

        portNameField.setFocusable(false);
	
	stockList.setBorder(javax.swing.BorderFactory.createTitledBorder("Stocks:"));
        stockList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        stockList.setToolTipText("");
        stockList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stockList);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
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
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockButtonActionPerformed(evt);
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
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(searchButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(tickerSearchField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(addStockButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                            .addComponent(portNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(symbolField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearHighField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newSymbolField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newYearHighField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newYearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(stockPanelLayout.createSequentialGroup()
                                .addComponent(searchLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        stockPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newPriceField, newSymbolField, newVolumeField, newYearHighField, newYearLowField, priceField, symbolField, volumeField, yearHighField, yearLowField});

        stockPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addStockButton, searchButton});

        stockPanelLayout.setVerticalGroup(
            stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(newYearLowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stockPanelLayout.createSequentialGroup()
                        .addComponent(tickerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addStockButton)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        stockPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {newPriceField, newPriceLabel, newSymbolField, newSymbolLabel, newVolumeField, newVolumeLabel, newYearHighField, newYearHighLabel, newYearLowField, newYearLowLabel});

        exitButton2.setText("Exit");
        exitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton2ActionPerformed(evt);
            }
        });

        clearButton2.setText("Clear Form");
        clearButton2.addActionListener(new java.awt.event.ActionListener() {
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 238, Short.MAX_VALUE)
                        .addComponent(clearButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton2))
                    .addComponent(stockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton2)
                    .addComponent(clearButton2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }
    
    /** Closes application */
    private void exitButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
	this.dispose();
    }                                           

    
    /** Clears all text fields, does not clear stockList */    
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

    /** Checks value entered is not null, and equal to four digits. 
      * Catch requires user to enter new value before search is executed.
      * Sends symbol to StockFetcher to retrieve data and parse to text fields.
      */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
	
  
        try {
                        
            String symbol = tickerSearchField.getText();
            
            if((symbol == null) || (symbol.length() != 4)) {
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

    /** Checks value entered is not null, and equal to four digits. 
      * Catch requires user to enter new value before search is executed.
      * Adds symbol value as an element in the list
      */
    private void addStockButtonActionPerformed(java.awt.event.ActionEvent evt) {
	
	try {
                String symbol = newSymbolField.getText();
                                
                if((symbol == null) || (symbol.length() != 4)) {
                    throw new NoDataException("Invalid Symbol");
                } // end if
                
                Stock stock = StockFetcher.getStockData(symbol);
                portfolio.addStock(stock);
                listModel.addElement(symbol);             

            } catch(NoDataException e) {

                JOptionPane.showConfirmDialog(this, e.getMessage(), "Unable to Add Stock", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
              } // end try catch
        
    }

    /**
     * On mouseclick in stockList, query selected symbol and parse data to text fields.
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockMainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton addStockButton;
    private javax.swing.JButton clearButton2;
    private javax.swing.JButton exitButton2;
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
    private javax.swing.JTextField portNameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JList stockList;
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
    private DefaultListModel listModel;
    // End of variables declaration
}
