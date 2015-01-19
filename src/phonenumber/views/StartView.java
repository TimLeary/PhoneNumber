/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumber.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import phonenumber.model.PersonModel;
/**
 *
 * @author David
 */
public class StartView extends JFrame{
    private JButton createButton;
    private JButton deleteButton;
    private JPanel defaultPanel;
    private JScrollPane personScrollPane;
    private JTable personListTable;
    private String[] personColumnsName;
    private Object[][] personDatas;
    private DefaultTableModel tableModel;
    
    class CActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public void initComponents(){
        createButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        defaultPanel = new javax.swing.JPanel();
        personScrollPane = new javax.swing.JScrollPane();
        personListTable = new javax.swing.JTable();
        personColumnsName = PersonModel.getPersonListColumnNames();
        personDatas = PersonModel.getPersonListData();
        
        tableModel = new DefaultTableModel(personDatas, personColumnsName);
        personListTable.setModel(tableModel);
        personListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        personScrollPane.setViewportView(personListTable);
        
        createButton.setText("create");
        deleteButton.setText("delete");
        
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(personListTable.getSelectedRow() != -1){
                    System.out.println(personListTable.getSelectedRow());
                    Boolean isDeleted = PersonModel.deletePersonDatasById((int)personDatas[personListTable.getSelectedRow()][0]);
                    
                    if(isDeleted){
                        tableModel.removeRow(personListTable.getSelectedRow());
                    }
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        

        javax.swing.GroupLayout defaultPanelLayout = new javax.swing.GroupLayout(defaultPanel);
        defaultPanel.setLayout(defaultPanelLayout);
        defaultPanelLayout.setHorizontalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addComponent(createButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(personScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        
        defaultPanelLayout.setVerticalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defaultPanelLayout.createSequentialGroup()
                .addGroup(defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(defaultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    
    public StartView(String title){        
        super(title);
        initComponents();
    }
}
