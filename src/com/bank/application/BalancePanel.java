
package com.bank.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BalancePanel extends javax.swing.JFrame {
    
    private FileReader fr;
    private BufferedReader br;
    private int interest = 5;
    private int maximum_withdraw = 5000;

   
    public BalancePanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DepositTable = new javax.swing.JTable();
        Cancelbutton = new javax.swing.JButton();
        depoButton = new javax.swing.JButton();
        withDrawbutton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DepositTable.setAutoCreateRowSorter(true);
        DepositTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Name", "Total Balance", "AccountType"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DepositTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DepositTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(DepositTable);
        if (DepositTable.getColumnModel().getColumnCount() > 0) {
            DepositTable.getColumnModel().getColumn(0).setResizable(false);
            DepositTable.getColumnModel().getColumn(1).setResizable(false);
            DepositTable.getColumnModel().getColumn(2).setResizable(false);
        }

        Cancelbutton.setText("Cancel");
        Cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbuttonActionPerformed(evt);
            }
        });

        depoButton.setText("Deposit");
        depoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depoButtonActionPerformed(evt);
            }
        });

        withDrawbutton.setText("Withdraw");
        withDrawbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withDrawbuttonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(depoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(withDrawbutton)
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(18, 18, 18)
                .addComponent(Cancelbutton)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelbutton)
                    .addComponent(depoButton)
                    .addComponent(withDrawbutton)
                    .addComponent(removeButton))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ShowData() throws FileNotFoundException, IOException
    {
        DefaultTableModel model1 = (DefaultTableModel) DepositTable.getModel();
        model1.setRowCount(0);
        //boolean isselected = false;
        
        fr = new FileReader("accountfile.txt");
        br = new BufferedReader(fr);
        String str1;
        while ((str1 = br.readLine()) != null) {
        System.out.println("Reading file in Balance Panel");
        String[] parts = str1.split(",");
        Object[] row = {parts[0],parts[11],parts[12] };
        
        model1.addRow(row);
        //System.out.println("Added!");
    }
    }

    
    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        this.dispose();
       
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void depoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depoButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel) DepositTable.getModel();
        int selectedRow = DepositTable.getSelectedRow();
        if(selectedRow >= 0)
        {
            String total = (String)DepositTable.getValueAt(selectedRow,1);
            String depositValue = JOptionPane.showInputDialog("Enter your deposit amount", null);
            System.out.println("Total is : "+total);
            int totalBalance = Integer.parseInt(total);
            int depositVal = Integer.parseInt(depositValue);
            int total2 = 0;
            if(DepositTable.getValueAt(selectedRow,2).equals("Savings"))
            {
                int prevBalance = totalBalance;
                total2 = (depositVal * interest)/100;
                totalBalance += (total2 + depositVal);
                System.out.println("Total after deposit is : "+totalBalance);
                String tot = String.valueOf(totalBalance);
                DepositTable.setValueAt(tot, selectedRow, 1);
                
                JOptionPane.showMessageDialog(null, "Your deposit is done!"+"You got "+total2+"tk as interest");
            }
            else{
                totalBalance = totalBalance + depositVal;
                String tot = String.valueOf(totalBalance);
                DepositTable.setValueAt(tot, selectedRow, 1);
                JOptionPane.showMessageDialog(null, "Your deposit is done!");
            }
            
        }
    }//GEN-LAST:event_depoButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel) DepositTable.getModel();
        int selectedRow = DepositTable.getSelectedRow();
        if(selectedRow >= 0)
        {
            model2.removeRow(selectedRow);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void withDrawbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withDrawbuttonActionPerformed
        // TODO add your handling code here:
        int selectedRow = DepositTable.getSelectedRow();
        if(selectedRow >= 0)
        {
            String total1 = (String)DepositTable.getValueAt(selectedRow,1);
            String withdraw = JOptionPane.showInputDialog("Enter your withdraw amount", null);
            System.out.println("Total is : "+total1);
            int totalBalance = Integer.parseInt(total1);
            int withdrawval = Integer.parseInt(withdraw);
            if(withdrawval > maximum_withdraw)
            {
                JOptionPane.showMessageDialog(null, "You have to withdraw within 5000");
            }
            else if(withdrawval > totalBalance)
            {
                JOptionPane.showMessageDialog(null, "You don't have enough money");
            }
            else
            {
                totalBalance -= withdrawval;
                String tot = String.valueOf(totalBalance);
                DepositTable.setValueAt(tot, selectedRow, 1);
               JOptionPane.showMessageDialog(null, "Withdraw is done!");

            } 
        }
    }//GEN-LAST:event_withDrawbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(BalancePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BalancePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BalancePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BalancePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BalancePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JTable DepositTable;
    private javax.swing.JButton depoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton withDrawbutton;
    // End of variables declaration//GEN-END:variables
}
