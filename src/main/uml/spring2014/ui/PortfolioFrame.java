package uml.spring2014.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.sun.jndi.ldap.Connection;

import uml.spring2014.exceptions.NoDataException;
import uml.spring2014.*;


/**
*
* @author Sara Gerstung
*/
public class PortfolioFrame extends javax.swing.JFrame {

    /**
    * Creates new form PortfolioFrame
    */
    public PortfolioFrame() {
        initComponents();
        this.setTitle("Stock Market Portfolio System");
    }

   /**
    * This method is called from within the constructor to initialize the form.
    */
    private void initComponents() {
        
        portfolioPanel  = new javax.swing.JPanel();
        newPortLabel    = new javax.swing.JLabel();
        newPortField    = new javax.swing.JTextField();
        newPortButton   = new javax.swing.JButton();
        existPortLabel  = new javax.swing.JLabel();
        openPortButton  = new javax.swing.JButton();
        portListCombo   = new javax.swing.JComboBox();
        exitButton      = new javax.swing.JButton();
        clearFormButton = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        portfolioPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Portfolio Information", 2, 0));

        newPortLabel.setText("Create New Portfolio:");

        newPortButton.setText("Create");
        newPortButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPortButtonActionPerformed(evt);
            }
        });

        existPortLabel.setText("Open Existing Portfolio:");

        openPortButton.setText("Open");
        openPortButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPortButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout portfolioPanelLayout = new javax.swing.GroupLayout(portfolioPanel);
        portfolioPanel.setLayout(portfolioPanelLayout);
        portfolioPanelLayout.setHorizontalGroup(
            portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portfolioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPortLabel)
                    .addComponent(existPortLabel)
                    .addGroup(portfolioPanelLayout.createSequentialGroup()
                        .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPortField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        portfolioPanelLayout.setVerticalGroup(
            portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portfolioPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(newPortLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPortButton))
                .addGap(18, 18, 18)
                .addComponent(existPortLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openPortButton)
                    .addComponent(portListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        clearFormButton.setText("Clear Form");
        clearFormButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(portfolioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearFormButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portfolioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(clearFormButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }
    
    /**
     * Query the Portfolio table for a list
     */
    private static void FillCombo(){
        
        DatabaseQueries.getPortfolios("SELECT * FROM portfolio");
        
        java.sql.Connection conn = null;
        
        try {
            conn = DatabaseConnect.getConnection();
        
        }catch(SQLException e4) {
            
            e4.printStackTrace();
        }
        
        ArrayList<String> PortfolioArray = new ArrayList<>();
        String query = ("SELECT * FROM portfolio");
        PreparedStatement stm = null;

        try {
            stm = (PreparedStatement) conn.prepareStatement(query);
        }catch(SQLException e3){
        
            e3.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = stm.executeQuery(query);
        }catch(SQLException e2){
        
            e2.printStackTrace();
        }

        try {
            while (rs.next()) {
                String portfolio = rs.getString("portfolioName");
                
                // add group names to the array list
                PortfolioArray.add(portfolio);
            }
        }catch(SQLException e1){
            ArrayList<String> DefaultArray = new ArrayList<String>();
            String message = "Add portfolio above.";
            DefaultArray.add(message);
            DefaultComboBoxModel model = new DefaultComboBoxModel(DefaultArray.toArray());
            portListCombo.setModel(model);
        }

        try {
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }


     // Populate the combo box
     DefaultComboBoxModel model = new DefaultComboBoxModel(PortfolioArray.toArray());
     portListCombo.setModel(model);

    } /* End FillCombo */
    
    /**
    * If newPortField is blank an error shown and creation is not executed.
    */
    private void newPortButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {       
                String str = newPortField.getText();
                               
                if((str == null) || (str.length() == 0)) {
                    throw new NoDataException("Please enter a portfolio name.");
                } // end if
                else{
                    
                    for(int i = 0; i < str.length(); ++i){
                        char c = str.charAt(i);
                        if(!Character.isDigit(c) && !Character.isLetter(c) && !Character.isWhitespace(c)){
                            throw new NoDataException("Alpha-Numeric Names Only");
                        }
                        
                    }
                }
                
                                
                final Portfolio portfolio = new Portfolio(str);
                Portfolio.setPortfolio(str);

                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                        public void run() {
                            new StockMainFrame(portfolio).setVisible(true);
                       }
                    });

                } catch(NoDataException e) {

                JOptionPane.showConfirmDialog(this, e.getMessage(), "Unable to Create Portfolio",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
              } // end try catch
        
    }/* End newPortButtonActionPerformed */

    /**
    * User selects a portfolio from the comboBox to be opened.
    */
    private void openPortButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
                String portfolioName = (String)portListCombo.getSelectedItem();
                
                final Portfolio portfolio = new Portfolio(portfolioName);
                if(portListCombo.getSelectedIndex() == -1) {
                    throw new NoDataException("Please Select a Portfolio to Open");
                } // end if
                                
                Portfolio.setPortfolio(portfolioName);
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new StockMainFrame(portfolio).setVisible(true);
                        
                    }
                });
                
            }catch(NoDataException e){

                JOptionPane.showConfirmDialog(this, e.getMessage(), "Unable to Open Portfolio",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
             } // end try catch

    } /* end openPortButtonActionPerformed */

    /**
     * Exits program when Exit button is selected.
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        this.dispose();
        
    } /* end exitButtonActionPerformed */
    
    /**
     * Clears all text fields on form when Clear button is selected.
     */
    private void clearFormButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        newPortField.setText("");
        portListCombo.setSelectedIndex(-1);
        
    } /* end clearFormButtonActionPerformed */

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String args[]){
        
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortfolioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PortfolioFrame().setVisible(true);
                //StockMainFrame.FillStockList();
                FillCombo();
                
                
            }
        });
    } /* End main */

    // Variables declaration
    private        javax.swing.JButton clearFormButton;
    private static javax.swing.JComboBox<String> portListCombo;
    private        javax.swing.JLabel existPortLabel;
    private        javax.swing.JButton exitButton;
    private        javax.swing.JButton newPortButton;
    private        javax.swing.JTextField newPortField;
    private        javax.swing.JLabel newPortLabel;
    private        javax.swing.JButton openPortButton;
    private        javax.swing.JPanel portfolioPanel;
    // End of variables declaration
}/*End PortfolioFrame*/