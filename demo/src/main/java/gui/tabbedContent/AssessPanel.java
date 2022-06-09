package gui.tabbedContent;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;
import type.TabbedPaneInfo;

public class AssessPanel extends GridBagPanel{
    public AssessPanel(TabbedPaneInfo tabbedPane){
        super(tabbedPane);
        // setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Security Requirements"),
                    BorderFactory.createEmptyBorder(10,10,10,10)
            )
            )
        );

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Evidence");
        addGBLComponent(nameLabel, 0, 0,3,1,0.0,0.0,"NONE",GridBagConstraints.LINE_START);

        // JLabel nameLabel = new JLabel();
        // nameLabel.setText("Software");
        // panel.addGBLComponent(nameLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        
        String[] assetHeader = {"Asset"};
        
        
        // ArrayList<String[]> swList = ontologyFunc.LoadAllSW();
        // String[][] swAry=new String[swList.size()][1];
        // for (int i=0;i<swList.size();i++){
        //     swAry[i]=swList.get(i);
        // }

        // JTable softTable = new JTable(swAry,softHeader);

        JTable assetTable = new JTable(new DefaultTableModel(assetHeader,0));
        
        
        JScrollPane assetTableSCPane= new JScrollPane(assetTable);
        assetTableSCPane.setPreferredSize(new Dimension(200,100));
        
        addGBLComponent(assetTableSCPane, 0, 1,1,3, 0.0,0.0,"BOTH");

        
        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Threat-affected asset");
        JLabel label1=makeHeader("SR for detecting (DT)");
        JLabel labelA=makeContent("00");
        JLabel labelB=makeContent("00");
        
        
        JCheckBox active_1 = new JCheckBox("Actively Implemented");
        JCheckBox passive_1 = new JCheckBox("Passively Implemented");
        JCheckBox not_1 = new JCheckBox("Not Implemented");
        
        
        JLabel label2=makeHeader("SR for responding (RP)");
        JLabel labelC=makeContent("00");
        
        
        JCheckBox active_2 = new JCheckBox("Actively Implemented");
        JCheckBox passive_2 = new JCheckBox("Passively Implemented");
        JCheckBox not_2 = new JCheckBox("Not Implemented");
        
        
        JLabel label3=makeHeader("SR for predicting (PD)");
        JLabel labelD=makeContent("00");
        
        
        JCheckBox active_3 = new JCheckBox("Actively Implemented");
        JCheckBox passive_3 = new JCheckBox("Passively Implemented");
        JCheckBox not_3 = new JCheckBox("Not Implemented");
        
        
        JLabel label4=makeHeader("SR for preventing (PV)");
        JLabel labelF=makeContent("00");
        
        
        JCheckBox active_4 = new JCheckBox("Actively Implemented");
        JCheckBox passive_4 = new JCheckBox("Passively Implemented");
        JCheckBox not_4 = new JCheckBox("Not Implemented");

        JLabel emptyLabel1 = new JLabel("");
        emptyLabel1.setPreferredSize(new Dimension(10,10));
        JLabel emptyLabel2 = new JLabel("");
        emptyLabel2.setPreferredSize(new Dimension(10,10));
        JLabel emptyLabel3 = new JLabel("");
        emptyLabel3.setPreferredSize(new Dimension(10,40));
        JLabel emptyLabel4 = new JLabel("");
        emptyLabel4.setPreferredSize(new Dimension(10,10));
        JLabel emptyLabel5 = new JLabel("");
        emptyLabel5.setPreferredSize(new Dimension(10,40));
        JLabel emptyLabel6 = new JLabel("");
        emptyLabel6.setPreferredSize(new Dimension(10,10));
        JLabel emptyLabel7 = new JLabel("");
        emptyLabel7.setPreferredSize(new Dimension(10,40));
        JLabel emptyLabel8 = new JLabel("");
        emptyLabel8.setPreferredSize(new Dimension(10,10));

        detailPane.addGBLComponent(emptyLabel1,0,1);
        detailPane.addGBLComponent(emptyLabel2,0,3);
        detailPane.addGBLComponent(emptyLabel3,0,5);
        detailPane.addGBLComponent(emptyLabel4,0,7);
        detailPane.addGBLComponent(emptyLabel5,0,9);
        detailPane.addGBLComponent(emptyLabel6,0,11);
        detailPane.addGBLComponent(emptyLabel7,0,13);
        detailPane.addGBLComponent(emptyLabel8,0,15);

        
        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(labelA, 1, 0,3,1,"BOTH");
        detailPane.addGBLComponent(labelB, 1, 2,3,1,"BOTH");
        detailPane.addGBLComponent(active_1, 0, 4,1,1,"BOTH");
        detailPane.addGBLComponent(passive_1, 1, 4,1,1,"BOTH");
        detailPane.addGBLComponent(not_1, 2, 4,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 6,1,1,"BOTH");
        detailPane.addGBLComponent(labelC, 1, 6,3,1,"BOTH");
        detailPane.addGBLComponent(active_2, 0, 8,1,1,"BOTH");
        detailPane.addGBLComponent(passive_2, 1, 8,1,1,"BOTH");
        detailPane.addGBLComponent(not_2, 2, 8,1,1,"BOTH");
        detailPane.addGBLComponent(label3, 0, 10,1,1,"BOTH");
        detailPane.addGBLComponent(labelD, 1, 10,3,1,"BOTH");
        detailPane.addGBLComponent(active_3, 0, 12,1,1,"BOTH");
        detailPane.addGBLComponent(passive_3, 1, 12,1,1,"BOTH");
        detailPane.addGBLComponent(not_3, 2, 12,1,1,"BOTH");
        detailPane.addGBLComponent(label4, 0, 14,1,1,"BOTH");
        detailPane.addGBLComponent(labelF, 1, 14,3,1,"BOTH");
        detailPane.addGBLComponent(active_4, 0, 16,1,1,"BOTH");
        detailPane.addGBLComponent(passive_4, 1, 16,1,1,"BOTH");
        detailPane.addGBLComponent(not_4, 2, 16,1,1,"BOTH");

        addGBLComponent(detailPane, 1, 1,1,3,0.0,0.0,"BOTH");


        JButton saveButton = new JButton("Save");
        JButton nextButton = new JButton("Next");
        JLabel emptyLabel9 = new JLabel("");
        emptyLabel9.setPreferredSize(new Dimension(10,10));
        

        addGBLComponent(saveButton, 2, 4,0.0,0.0);
        addGBLComponent(emptyLabel9, 2, 5);
        addGBLComponent(nextButton, 2, 6,0.0,0.0);
        
        nextButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel.removeAll();

                IModelFieldGroup groups[] = new IModelFieldGroup[] {
                        new ModelField("Threat-affected asset", "Threat-affected asset"),                       
                        new ModelFieldGroup("Adaptive Security Requirements", "Adaptive Security Requirements")
                                .withChild(new ModelField("DT", "DT"))
                                .withChild(new ModelField("RP", "RP"))
                                .withChild(new ModelField("PD", "PD"))
                                .withChild(new ModelField("PV", "PV")),
                        new ModelField("Risk", "Risk")
                };

                // Get leafs of columns tree.
                ModelField fields[] = ModelFieldGroup.getBottomFields(groups);

                // Sample data.
                ModelRow rows[] = new ModelRow[30];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = new ModelRow(fields.length);
                    for (int j = 0; j < fields.length; j++)
                        rows[i].setValue(j, fields[j].getCaption() + i);
                }

                // Table.
                ModelData data = new ModelData(groups);
                data.setRows(rows);
                JBroTable table = new JBroTable(data);
                table.getTableHeader().setEnabled(false);

                addGBLComponent(table.getScrollPane(), 0, 1, 2, 1, 0.6, 0.8, "BOTH");

                JButton saveButton = new JButton("Save");
                JButton nextButton = new JButton("Next");
        
                addGBLComponent(saveButton, 1, 4,0.0,0.1,"NONE",GridBagConstraints.LINE_END);
                addGBLComponent(nextButton, 1, 5,0.0,0.1,"NONE",GridBagConstraints.LINE_END);
            }
        });

    }

    
}
