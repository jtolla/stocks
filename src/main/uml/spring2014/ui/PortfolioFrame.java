package uml.spring2014.ui;

import main.uml.spring2014.exceptions.*;
import javax.swing.JOptionPane;
import test.uml.spring2014.PortStubsSara;

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
        setTitle("Stock Market Portfolio System");
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
        existPortField = new javax.swing.JTextField();
        openPortButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        clearFormButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        portfolioPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Portfolio Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        newPortLabel.setText("Create New Portfolio:");

        newPortButton.setText("Create");
        newPortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPortButtonActionPerformed(evt);
            }
        });

        existPortLabel.setText("Open Existing Portfolio:");

        openPortButton.setText("Open");
        openPortButton.addActionListener(new java.awt.event.ActionListener() {
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
                        .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(existPortField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(newPortField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(portfolioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(87, Short.MAX_VALUE))
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
                    .addComponent(existPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openPortButton))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        clearFormButton.setText("Clear Form");
        clearFormButton.addActionListener(new java.awt.event.ActionListener() {
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
                        .addGap(0, 234, Short.MAX_VALUE)
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
     * Creates new instance of portfolio. If newPortField is blank an error
     * shown and creation is not executed.
     */
    private void newPortButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        PortStubsSara newPortfolio = new PortStubsSara();
        
        try {
                String portfolioName = newPortField.getText();
                newPortfolio.setName(portfolioName);

                if((portfolioName == null) || (portfolioName.length() == 0)) {
                    throw new NoDataException("Please Enter a Portfolio Name");
                } // end if
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new StockMainFrame().setVisible(true);
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
                String portfolioName = existPortField.getText();
                                
                if((portfolioName == null) || (portfolioName.length() == 0)) {
                    throw new NoDataException("Please Enter a Portfolio Name");
                } // end if
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new StockMainFrame().setVisible(true);
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
     */
    private void clearFormButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        newPortField.setText("");
        existPortField.setText("");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PortfolioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PortfolioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PortfolioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortfolioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PortfolioFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton clearFormButton;
    private javax.swing.JTextField existPortField;
    private javax.swing.JLabel existPortLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton newPortButton;
    private javax.swing.JTextField newPortField;
    private javax.swing.JLabel newPortLabel;
    private javax.swing.JButton openPortButton;
    private javax.swing.JPanel portfolioPanel;
    // End of variables declaration
}