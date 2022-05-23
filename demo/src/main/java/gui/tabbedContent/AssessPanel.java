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

import gui.tabbedContent.type.TabbedPaneInfo;
import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;

public class AssessPanel extends GridBagPanel{
    public AssessPanel(TabbedPaneInfo tabbedPane){
        super(tabbedPane);
        setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Evidence");
        addGBLComponent(nameLabel, 0, 0,3,1,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        // JLabel nameLabel = new JLabel();
        // nameLabel.setText("Software");
        // panel.addGBLComponent(nameLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        
        String[] softHeader = {"Software"};
        
        
        // ArrayList<String[]> swList = ontologyFunc.LoadAllSW();
        // String[][] swAry=new String[swList.size()][1];
        // for (int i=0;i<swList.size();i++){
        //     swAry[i]=swList.get(i);
        // }

        // JTable softTable = new JTable(swAry,softHeader);

        JTable softTable = new JTable(new DefaultTableModel(softHeader,0));
        softTable.setTableHeader(null);
        
        
        JScrollPane softTableSCPane= new JScrollPane(softTable);
        softTableSCPane.setPreferredSize(new Dimension(10,10));
        
        addGBLComponent(softTableSCPane, 0, 1,1,4, 0.6,0.8,"BOTH");

        
        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Threat-affected asset");
        JLabel label1=makeHeader("SR for detecting (DT)");
        JLabel labelA=makeContent("00");
        JLabel labelB=makeContent("00");
        
        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 1,1,1,"BOTH");
        detailPane.addGBLComponent(labelA, 1, 0,3,1,"BOTH");
        detailPane.addGBLComponent(labelB, 1, 1,3,1,"BOTH");

        JCheckBox active_1 = new JCheckBox("Actively Implemented");
        JCheckBox passive_1 = new JCheckBox("Passively Implemented");
        JCheckBox not_1 = new JCheckBox("Not Implemented");
        
        detailPane.addGBLComponent(active_1, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(passive_1, 1, 2,1,1,"BOTH");
        detailPane.addGBLComponent(not_1, 2, 2,1,1,"BOTH");
        
        JLabel label2=makeHeader("SR for responding (RP)");
        JLabel labelC=makeContent("00");

        detailPane.addGBLComponent(label2, 0, 3,1,1,"BOTH");
        detailPane.addGBLComponent(labelC, 1, 3,3,1,"BOTH");

        JCheckBox active_2 = new JCheckBox("Actively Implemented");
        JCheckBox passive_2 = new JCheckBox("Passively Implemented");
        JCheckBox not_2 = new JCheckBox("Not Implemented");
        
        detailPane.addGBLComponent(active_2, 0, 4,1,1,"BOTH");
        detailPane.addGBLComponent(passive_2, 1, 4,1,1,"BOTH");
        detailPane.addGBLComponent(not_2, 2, 4,1,1,"BOTH");

        JLabel label3=makeHeader("SR for predicting (PD)");
        JLabel labelD=makeContent("00");

        detailPane.addGBLComponent(label3, 0, 5,1,1,"BOTH");
        detailPane.addGBLComponent(labelD, 1, 5,3,1,"BOTH");

        JCheckBox active_3 = new JCheckBox("Actively Implemented");
        JCheckBox passive_3 = new JCheckBox("Passively Implemented");
        JCheckBox not_3 = new JCheckBox("Not Implemented");
        
        detailPane.addGBLComponent(active_3, 0, 6,1,1,"BOTH");
        detailPane.addGBLComponent(passive_3, 1, 6,1,1,"BOTH");
        detailPane.addGBLComponent(not_3, 2, 6,1,1,"BOTH");

        JLabel label4=makeHeader("SR for preventing (PV)");
        JLabel labelF=makeContent("00");

        detailPane.addGBLComponent(label4, 0, 7,1,1,"BOTH");
        detailPane.addGBLComponent(labelF, 1, 7,3,1,"BOTH");

        JCheckBox active_4 = new JCheckBox("Actively Implemented");
        JCheckBox passive_4 = new JCheckBox("Passively Implemented");
        JCheckBox not_4 = new JCheckBox("Not Implemented");
        
        detailPane.addGBLComponent(active_4, 0, 8,1,1,"BOTH");
        detailPane.addGBLComponent(passive_4, 1, 8,1,1,"BOTH");
        detailPane.addGBLComponent(not_4, 2, 8,1,1,"BOTH");

        addGBLComponent(detailPane, 1, 1,1,3,0.4,0.8,"BOTH");


        JButton saveButton = new JButton("Save");
        JButton nextButton = new JButton("Next");

        addGBLComponent(saveButton, 2, 4,0.0,0.1);
        addGBLComponent(nextButton, 2, 5,0.0,0.1);
        
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

    private JLabel makeHeader(String text){
        JLabel label = new JLabel(" "+text+" ");
        label.setBorder(BorderFactory.createLineBorder(Color.gray));
        label.setPreferredSize(new Dimension(140,30));
        
        return label;
    }

    private JLabel makeContent(String text){
        JLabel label = new JLabel(" "+text+" ");
        label.setBorder(BorderFactory.createLineBorder(Color.gray));
        label.setPreferredSize(new Dimension(300,30));
        label.setOpaque(true);
        label.setBackground(Color.white);
        
        return label;
    }

    private JTable makeContentTable(){
        JTable table = new JTable(new DefaultTableModel(new String[]{""},0));
        table.setTableHeader(null);
        table.setOpaque(true);
        table.setBackground(Color.white);
        return table;
    }
}
