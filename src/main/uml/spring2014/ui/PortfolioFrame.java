package uml.spring2014.ui;

import javax.swing.*;
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
     * 
     */
    private void initComponents() {
        
        portfolioPanel = new javax.swing.JPanel();
        newPortLabel = new javax.swing.JLabel();
        newPortField = new javax.swing.JTextField();
        newPortButton = new javax.swing.JButton();
        existPortLabel = new javax.swing.JLabel();
        openPortButton = new javax.swing.JButton();
        portListCombo = new javax.swing.JComboBox();
        exitButton = new javax.swing.JButton();
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
    private void FillCombo(){
        try{
            String sql = "select * from Portfolio";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String portfolio = rs.getString("Portfolio");
                portListCombo.addItem(portfolio);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * If newPortField is blank an error shown and creation is not executed.
     */
    private void newPortButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
                final Portfolio portfolio = new Portfolio(newPortField.getText());
                Portfolio.setPortfolio(newPortField.getText());
                
                
                if((newPortField.getText() == null) || (newPortField.getText().length() == 0)) {
                    throw new NoDataException("Please Enter a Portfolio Name");
                } // end if
                
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
        
    }                                             

    /**
     * Method searches for an existing portfolio to open. If no name is entered
     * an error message occurs and does not proceed with code. Need to add
     * functionality to search in next iteration.
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
                
            } catch(NoDataException e) {

                JOptionPane.showConfirmDialog(this, e.getMessage(), "Unable to Open Portfolio", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
              } // end try catch

    }

    /**
     * Exits program when Exit button is selected.
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        this.dispose();
        
    }
    
    /**
     * Clears all text fields on form when Clear button is selected.
     *  
     */
    private void clearFormButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        newPortField.setText("");
        portListCombo.setSelectedIndex(-1);
        
    }

    /**
     * @param args the command line arguments
     * @throws SQLException 
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
                
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton clearFormButton;
    private javax.swing.JComboBox portListCombo;
    private javax.swing.JLabel existPortLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton newPortButton;
    private javax.swing.JTextField newPortField;
    private javax.swing.JLabel newPortLabel;
    private javax.swing.JButton openPortButton;
    private javax.swing.JPanel portfolioPanel;
    // End of variables declaration
}
