/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.BloodBankMgr;
import domain.BloodBank;
import domain.BloodBankAddress;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author howar
 */
public class JIFrameAddBloodBank extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFrameAddBloodBank
     */
    public JIFrameAddBloodBank() {
        initComponents();
        loadInitDatabaseData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jPanelInsert = new javax.swing.JPanel();
        jLabelBloodBankId = new javax.swing.JLabel();
        jTextFieldBloodBankId = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelNumber = new javax.swing.JLabel();
        jLabelStreet = new javax.swing.JLabel();
        jTextFieldNumber = new javax.swing.JTextField();
        jTextFieldStreet = new javax.swing.JTextField();
        jLabelAddressLine1 = new javax.swing.JLabel();
        jTextFieldAddressLine1 = new javax.swing.JTextField();
        jLabelAddressLine2 = new javax.swing.JLabel();
        jTextFieldAddressLine2 = new javax.swing.JTextField();
        jLabelAddressId = new javax.swing.JLabel();
        jTextFieldAddressId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelAccountDetails = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBloodBank = new javax.swing.JTable();

        jTextField5.setText("jTextField5");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add Blood Bank");

        jPanelInsert.setBackground(new java.awt.Color(0, 255, 255));
        jPanelInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelInsertMouseClicked(evt);
            }
        });

        jLabelBloodBankId.setLabelFor(jTextFieldBloodBankId);
        jLabelBloodBankId.setText("Blood Bank ID:");

        jLabelName.setLabelFor(jTextFieldName);
        jLabelName.setText("Name:");

        jLabelNumber.setLabelFor(jTextFieldNumber);
        jLabelNumber.setText("Number:");

        jLabelStreet.setLabelFor(jTextFieldStreet);
        jLabelStreet.setText("Street");

        jLabelAddressLine1.setLabelFor(jTextFieldAddressLine1);
        jLabelAddressLine1.setText("Address Line 1:");

        jLabelAddressLine2.setLabelFor(jTextFieldAddressLine2);
        jLabelAddressLine2.setText("Address Line 2:");

        jLabelAddressId.setLabelFor(jTextFieldAddressId);
        jLabelAddressId.setText("Address ID:");

        jTextFieldAddressId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddressIdActionPerformed(evt);
            }
        });

        jLabelAccountDetails.setText("Address Details:");

        jButtonSave.setText("Save");
        jButtonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jLabelError.setBackground(new java.awt.Color(0, 255, 51));
        jLabelError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelError.setForeground(new java.awt.Color(255, 0, 0));
        jLabelError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonUpdate.setText("Update");
        jButtonUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDelete.setEnabled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInsertLayout = new javax.swing.GroupLayout(jPanelInsert);
        jPanelInsert.setLayout(jPanelInsertLayout);
        jPanelInsertLayout.setHorizontalGroup(
            jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelInsertLayout.createSequentialGroup()
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInsertLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInsertLayout.createSequentialGroup()
                                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBloodBankId)
                                    .addComponent(jLabelName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldName)
                                    .addComponent(jTextFieldBloodBankId)))
                            .addGroup(jPanelInsertLayout.createSequentialGroup()
                                .addComponent(jLabelNumber)
                                .addGap(39, 39, 39)
                                .addComponent(jTextFieldNumber))
                            .addGroup(jPanelInsertLayout.createSequentialGroup()
                                .addComponent(jLabelAccountDetails)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInsertLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSave))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInsertLayout.createSequentialGroup()
                                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStreet)
                                    .addComponent(jLabelAddressLine1)
                                    .addComponent(jLabelAddressLine2)
                                    .addComponent(jLabelAddressId))
                                .addGap(6, 6, 6)
                                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAddressLine2)
                                    .addComponent(jTextFieldAddressLine1)
                                    .addComponent(jTextFieldStreet)
                                    .addGroup(jPanelInsertLayout.createSequentialGroup()
                                        .addComponent(jTextFieldAddressId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 59, Short.MAX_VALUE)))
                                .addGap(79, 79, 79))))
                    .addGroup(jPanelInsertLayout.createSequentialGroup()
                        .addComponent(jLabelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(77, 77, 77)))
                .addContainerGap())
        );
        jPanelInsertLayout.setVerticalGroup(
            jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBloodBankId)
                    .addComponent(jTextFieldBloodBankId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumber)
                    .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAccountDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddressId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldAddressId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStreet)
                    .addComponent(jTextFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddressLine1)
                    .addComponent(jTextFieldAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddressLine2)
                    .addComponent(jTextFieldAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTableBloodBank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Bank Id", "Name", "Number", "Address Id", "Street", "Address Line 1", "Address Line 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBloodBank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBloodBankMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBloodBank);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAddressIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddressIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddressIdActionPerformed
    private void loadInitDatabaseData(){
        DefaultTableModel model = (DefaultTableModel)jTableBloodBank.getModel();
        //reset tabel row | set table row to zero
        model.setRowCount(0);
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
        BloodBankMgr bloodBankMgr = (BloodBankMgr)context.getBean("bloodBankMgr"); 
        //bloodBankMgr.addBloodBank(bloodBank);
        //List<BloodBank> bBankList = new ArrayList();
        try{
            List<BloodBank> bBankList = new ArrayList();
            bBankList = bloodBankMgr.getAllBloodBank();
            Object [] row = new Object[7];
            for(int i = 0; i < bBankList.size(); i++)
            {
                row[0] = bBankList.get(i).getId();
                row[1] = bBankList.get(i).getName();
                row[2] = bBankList.get(i).getNumber();
                row[3] = bBankList.get(i).getBloodBankAddress().getAddressId();
                row[4] = bBankList.get(i).getBloodBankAddress().getStreet();
                row[5] = bBankList.get(i).getBloodBankAddress().getAddressLine1();
                row[6] = bBankList.get(i).getBloodBankAddress().getAddressLine2();
                model.addRow(row);
            }
        }catch(Exception e){System.out.println("Presentation (GUI) Error: " + e.toString());}
    }
    
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try
        {
            BloodBank bloodBank = new BloodBank();
            BloodBankAddress address = new BloodBankAddress();
            
            if(jTextFieldBloodBankId.getText().equals(""))
            {
                throw new Exception("Enter Blood Bank ID!!");
            }
            else
            {
                bloodBank.setId(jTextFieldBloodBankId.getText());
            }
            address.setAddressId(jTextFieldAddressId.getText());
            address.setStreet(jTextFieldStreet.getText());
            address.setAddressLine1(jTextFieldAddressLine1.getText());
            address.setAddressLine2(jTextFieldAddressLine2.getText());
            bloodBank.setName(jTextFieldName.getText());
            bloodBank.setNumber(jTextFieldNumber.getText());
            bloodBank.setBloodBankAddress(address);
            
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
            BloodBankMgr bloodBankMgr = (BloodBankMgr)context.getBean("bloodBankMgr"); 
            bloodBankMgr.addBloodBank(bloodBank); 
            
            
            jLabelError.setForeground(Color.GREEN);
            jLabelError.setText("Saved...");
            loadInitDatabaseData();
            JOptionPane.showMessageDialog(this,"Details Saved!!");
             
        }catch(Exception e){ jLabelError.setText("Error:" +e.toString());}
    }//GEN-LAST:event_jButtonSaveActionPerformed
    /**
     * Clear form data
     * */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearComponents();
//        for(Component control : jPanelInsert.getComponents())
//        {
//            if(control instanceof JTextField)
//            {
//                JTextField ctrl = (JTextField) control;
//                ctrl.setText("");
//            }
//            else if (control instanceof JComboBox)
//            {
//                JComboBox ctr = (JComboBox) control;
//                ctr.setSelectedIndex(0);
//            }
//            jLabelError.setText("");
//        }
//        jButtonSave.setEnabled(Boolean.TRUE);
//        jButtonUpdate.setEnabled(Boolean.FALSE);
//        jButtonDelete.setEnabled(Boolean.FALSE);
//        jTextFieldBloodBankId.setEnabled(Boolean.TRUE);
//        jTextFieldBloodBankId.setEditable(Boolean.TRUE);
//        jTextFieldAddressId.setEnabled(Boolean.TRUE);
//        jTextFieldAddressId.setEditable(Boolean.TRUE);
//        loadInitDatabaseData();
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void clearComponents()
    {
        for(Component control : jPanelInsert.getComponents())
        {
            if(control instanceof JTextField)
            {
                JTextField ctrl = (JTextField) control;
                ctrl.setText("");
            }
            else if (control instanceof JComboBox)
            {
                JComboBox ctr = (JComboBox) control;
                ctr.setSelectedIndex(0);
            }
            jLabelError.setText("");
        }
        jButtonSave.setEnabled(Boolean.TRUE);
        jButtonUpdate.setEnabled(Boolean.FALSE);
        jButtonDelete.setEnabled(Boolean.FALSE);
        jTextFieldBloodBankId.setEnabled(Boolean.TRUE);
        jTextFieldBloodBankId.setEditable(Boolean.TRUE);
        jTextFieldAddressId.setEnabled(Boolean.TRUE);
        jTextFieldAddressId.setEditable(Boolean.TRUE);
        loadInitDatabaseData();
    }
    private void jPanelInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelInsertMouseClicked

    }//GEN-LAST:event_jPanelInsertMouseClicked

    private void jTableBloodBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBloodBankMouseClicked

        //NOTE: I may want to clear the form first
        
        //get selected row
        int row = jTableBloodBank.getSelectedRow();
        //get the table model
        TableModel model = jTableBloodBank.getModel();
        jTextFieldBloodBankId.setText(model.getValueAt(row,0).toString());
        //Disable and make Id not Editable
        jTextFieldBloodBankId.setEditable(Boolean.FALSE);
        jTextFieldBloodBankId.setEnabled(Boolean.FALSE);
        jTextFieldName.setText(model.getValueAt(row,1).toString());
        jTextFieldNumber.setText(model.getValueAt(row,2).toString());
        
        jTextFieldAddressId.setText(model.getValueAt(row,3).toString());
        //Disable and make Id not Editable
        jTextFieldAddressId.setEditable(Boolean.FALSE);
        jTextFieldAddressId.setEnabled(Boolean.FALSE);
        jTextFieldStreet.setText(model.getValueAt(row,4).toString());
        jTextFieldAddressLine1.setText(model.getValueAt(row,5).toString());
        jTextFieldAddressLine2.setText(model.getValueAt(row,6).toString());
        //Enable update button
        jButtonUpdate.setEnabled(Boolean.TRUE);
        //Enable Delete Button
        jButtonDelete.setEnabled(Boolean.TRUE);
        //disable save button
        jButtonSave.setEnabled(Boolean.FALSE);
    }//GEN-LAST:event_jTableBloodBankMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try
        {
            BloodBank bloodBank = new BloodBank();
            BloodBankAddress address = new BloodBankAddress();
            
            if(jTextFieldBloodBankId.getText().equals(""))
            {
                throw new Exception("Enter Blood Bank ID!!");
            }
            else
            {
                bloodBank.setId(jTextFieldBloodBankId.getText());
                //get selected row
//                int row = jTableBloodBank.getSelectedRow();
//                //get the table model
//                TableModel model = jTableBloodBank.getModel();
//                jTextFieldBloodBankId.setText(model.getValueAt(row,0).toString());
            }
            address.setAddressId(jTextFieldAddressId.getText());
            address.setStreet(jTextFieldStreet.getText());
            address.setAddressLine1(jTextFieldAddressLine1.getText());
            address.setAddressLine2(jTextFieldAddressLine2.getText());
            bloodBank.setName(jTextFieldName.getText());
            bloodBank.setNumber(jTextFieldNumber.getText());
            bloodBank.setBloodBankAddress(address);
            
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
            BloodBankMgr bloodBankMgr = (BloodBankMgr)context.getBean("bloodBankMgr"); 
            bloodBankMgr.upDateBloodBank(bloodBank); 
            
            
            jLabelError.setForeground(Color.GREEN);
            jLabelError.setText("Updated...");
            loadInitDatabaseData();
            JOptionPane.showMessageDialog(this,"Details Updated!!");
             
        }catch(Exception e){ jLabelError.setText("Error:" +e.toString());}
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try
        {
            BloodBank bloodBank = new BloodBank();
            BloodBankAddress address = new BloodBankAddress();
            
            if(jTextFieldBloodBankId.getText().equals(""))
            {
                throw new Exception("Enter Blood Bank ID!!");
            }
            else
            {
                bloodBank.setId(jTextFieldBloodBankId.getText());
                //get selected row
//                int row = jTableBloodBank.getSelectedRow();
//                //get the table model
//                TableModel model = jTableBloodBank.getModel();
//                jTextFieldBloodBankId.setText(model.getValueAt(row,0).toString());
            }
            address.setAddressId(jTextFieldAddressId.getText());
            address.setStreet(jTextFieldStreet.getText());
            address.setAddressLine1(jTextFieldAddressLine1.getText());
            address.setAddressLine2(jTextFieldAddressLine2.getText());
            bloodBank.setName(jTextFieldName.getText());
            bloodBank.setNumber(jTextFieldNumber.getText());
            bloodBank.setBloodBankAddress(address);
            
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
            BloodBankMgr bloodBankMgr = (BloodBankMgr)context.getBean("bloodBankMgr"); 
            bloodBankMgr.deleteBloodBank(bloodBank); 
            
            
            jLabelError.setForeground(Color.RED);
            jLabelError.setText("Deleted...");
            loadInitDatabaseData();
            JOptionPane.showMessageDialog(this,"Details Deleted!!");
            //Clear form
            clearComponents();
        }catch(Exception e){ jLabelError.setText("Error:" +e.toString());}
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelAccountDetails;
    private javax.swing.JLabel jLabelAddressId;
    private javax.swing.JLabel jLabelAddressLine1;
    private javax.swing.JLabel jLabelAddressLine2;
    private javax.swing.JLabel jLabelBloodBankId;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelStreet;
    private javax.swing.JPanel jPanelInsert;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableBloodBank;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldAddressId;
    private javax.swing.JTextField jTextFieldAddressLine1;
    private javax.swing.JTextField jTextFieldAddressLine2;
    private javax.swing.JTextField jTextFieldBloodBankId;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldStreet;
    // End of variables declaration//GEN-END:variables
}
