package gui.tabbedContent;

import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;
import type.ProcessedData;
import type.Software;
import type.Threat;

public class SecReqPanel extends GridBagPanel{

    JTable threatTable;
    
    public SecReqPanel(JTabbedPane tabbedPane){
        super(tabbedPane);
        setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10,10,10,10),
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Security Requirements")
            )
        );

        String[] nameHeader = {"Threats"};

        threatTable = new JTable(new DefaultTableModel(nameHeader,0));
        JScrollPane threatTabSc = new JScrollPane(threatTable);
        threatTabSc.setPreferredSize(new Dimension(130,520));
        addGBLComponent(threatTabSc, 0, 0);

        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Techniques");
        JLabel label1=makeHeader("Tactics");
        JLabel label2=makeHeader("Software");
        JLabel label3=makeHeader("Mitigation");

        JLabel labelA=makeContent("");
        // JLabel labelB=makeContent("");
        JTable tacticTable = makeContentTable();
        JScrollPane tacticTabSc= new JScrollPane(tacticTable);
        tacticTabSc.setPreferredSize(new Dimension(400,160));
        JTable softTable = makeContentTable();
        // ((DefaultTableModel)softTable.getModel()).addRow(new String[]{"S0154:Cobalt Strike"});
        // ((DefaultTableModel)softTable.getModel()).addRow(new String[]{"S0002:Mimikatz"});
        JScrollPane softTabSc = new JScrollPane(softTable);
        softTabSc.setPreferredSize(new Dimension(400,160));
        JTable mitiTable = makeContentTable();
        // ((DefaultTableModel)mitiTable.getModel()).addRow(new String[]{"M1028:Operating System Configuration"});
        // ((DefaultTableModel)mitiTable.getModel()).addRow(new String[]{"M1027:Password Policies"});
        // ((DefaultTableModel)mitiTable.getModel()).addRow(new String[]{"M1026:Privileged Account Management"});
        // ((DefaultTableModel)mitiTable.getModel()).addRow(new String[]{"M1017:User Training"});
        JScrollPane mitiTabSc = new JScrollPane(mitiTable);
        mitiTabSc.setPreferredSize(new Dimension(400,160));


        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 1,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(label3, 0, 3,1,1,"BOTH");
        detailPane.addGBLComponent(softTabSc, 1, 2,2,1,"BOTH");
        detailPane.addGBLComponent(mitiTabSc, 1, 3,1,1,"BOTH");
        detailPane.addGBLComponent(labelA, 1, 0,1,1,"BOTH");
        detailPane.addGBLComponent(tacticTabSc, 1, 1,1,1,"BOTH");

        System.out.println(detailPane.getPreferredSize());
        addGBLComponent(detailPane, 1, 0);

        GridBagPanel inputPane = new GridBagPanel();
        inputPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Input"));
        JLabel label2_0=new JLabel("Detect(DT) : ");
        JLabel label2_1=new JLabel("Respond(RP) : ");
        JLabel label2_2=new JLabel("Predict(PD) : ");
        JLabel label2_3=new JLabel("Prevent(PV) : ");

        JTextField dtField = new JTextField();
        dtField.setPreferredSize(new Dimension(300,60));
        JTextField rpField = new JTextField();
        rpField.setPreferredSize(new Dimension(300,60));
        JTextField pdField = new JTextField();
        pdField.setPreferredSize(new Dimension(300,60));
        JTextField pvField = new JTextField();
        pvField.setPreferredSize(new Dimension(300,60));
         

        inputPane.addGBLComponent(label2_0, 0, 0,1,1,"BOTH");
        inputPane.addGBLComponent(label2_1, 0, 2,1,1,"BOTH");
        inputPane.addGBLComponent(label2_2, 0, 4,1,1,"BOTH");
        inputPane.addGBLComponent(label2_3, 0, 6,1,1,"BOTH");


        inputPane.addGBLComponent(dtField, 1, 0,1,1,"BOTH");
        inputPane.addGBLComponent(rpField, 1, 2,1,1,"BOTH");
        inputPane.addGBLComponent(pdField, 1, 4,1,1,"BOTH");
        inputPane.addGBLComponent(pvField, 1, 6,1,1,"BOTH");

        JLabel emptyLabel = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(200,30));
        JLabel emptyLabel2 = new JLabel();
        emptyLabel2.setPreferredSize(new Dimension(200,30));
        JLabel emptyLabel3 = new JLabel();
        emptyLabel3.setPreferredSize(new Dimension(200,30));

        inputPane.addGBLComponent(emptyLabel, 0, 1,1,1,"BOTH");
        inputPane.addGBLComponent(emptyLabel2, 0, 3,1,1,"BOTH");
        inputPane.addGBLComponent(emptyLabel3, 0, 5,1,1,"BOTH");

        JLabel emptyLabel4 = new JLabel();
        emptyLabel4.setPreferredSize(new Dimension(200,165));
        
        inputPane.addGBLComponent(emptyLabel4, 0, 7,1,1,"BOTH");

        addGBLComponent(inputPane, 2, 0,2,1);
        System.out.println(new JButton("aa").getPreferredSize());

        JButton nextButton = new JButton("Next");

        addGBLComponent(nextButton, 3, 1,0.0,0.0,"NONE",GridBagConstraints.LINE_END);

        threatTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                String value = threatTable.getValueAt(threatTable.getSelectedRow(), 0).toString();
                Threat threat = ProcessedData.getThreat(value);
                labelA.setText(threat.getTechnique().getName());
                ((DefaultTableModel)tacticTable.getModel()).setRowCount(0);
                for (String t:threat.getTacticList()){
                    ((DefaultTableModel)tacticTable.getModel()).addRow(new String[]{t});
                }
                ((DefaultTableModel)softTable.getModel()).setRowCount(0);
                for (Software s:threat.getSoftwareList()){
                    ((DefaultTableModel)softTable.getModel()).addRow(new String[]{s.getName()});
                }
                ((DefaultTableModel)mitiTable.getModel()).setRowCount(0);
                for (String m:threat.getMitigationList()){
                    ((DefaultTableModel)mitiTable.getModel()).addRow(new String[]{m});
                }
                
            }
            
        });

        // JButton nextButton = new JButton("Next");


        // IModelFieldGroup groups[] = new IModelFieldGroup[] {
        //         new ModelField("Threat", "Threat"),
        //         new ModelField("Technique", "Technique"),
        //         new ModelField("Tactics", "Tactics"),
        //         new ModelField("Software", "Software"),
        //         new ModelField("Mitigation", "Mitigation"),
        //         new ModelFieldGroup("Adaptive Security Requirements", "Adaptive Security Requirements")
        //                 .withChild(new ModelField("DT", "DT"))
        //                 .withChild(new ModelField("RP", "RP"))
        //                 .withChild(new ModelField("PD", "PD"))
        //                 .withChild(new ModelField("PV", "PV"))
        // };

        // // Get leafs of columns tree.
        // ModelField fields[] = ModelFieldGroup.getBottomFields(groups);

        // // Sample data.
        // ModelRow rows[] = new ModelRow[30];
        // for (int i = 0; i < rows.length; i++) {
        //     rows[i] = new ModelRow(fields.length);
        //     for (int j = 0; j < fields.length; j++)
        //         rows[i].setValue(j, fields[j].getCaption() + i);
        // }

        // // Table.
        // ModelData data = new ModelData(groups);
        // data.setRows(rows);
        // JBroTable table = new JBroTable(data);
        // table.getTableHeader().setEnabled(false);

        // addGBLComponent(table.getScrollPane(), 0, 1,4,1,0.6,0.8,"BOTH");

 

        // JButton closeButton = new JButton("Edit");
        // addGBLComponent(closeButton, 2, 2,0.8,0.1,"NONE",GridBagConstraints.LINE_END);


        // addGBLComponent(nextButton, 3, 2,0.1,0.1,"NONE");



        // JLabel secLabel = new JLabel();
        // secLabel.setText("Security requirement for a threat");
        // addGBLComponent(secLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        // String[][] secList = new String[30][2];
        // for (int i=0;i<secList.length;i++){
        //     secList[i][0]="T"+(i+1);
        //     secList[i][1]="Security Requirement "+(i+1);
        // }

        // String[] secHeader={"Threat","Security Requirements"};
        // JTable secTable = new JTable(secList,secHeader);
        // JScrollPane secTScPane = new JScrollPane(secTable);
        // secTScPane.setPreferredSize(new Dimension(10,10));

        // secTable.getColumnModel().getColumn(0).setMaxWidth(60);

        // addGBLComponent(secTScPane, 0, 1,0.1,0.5,"BOTH");

        // JLabel adapLabel = new JLabel();
        // adapLabel.setText("Adaptive Security Requirements for a threat-affected asset");
        // addGBLComponent(adapLabel, 1, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        // String[][] adapList = new String[30][2];
        // for (int i=0;i<adapList.length;i++){
        //     adapList[i][0]="A"+(i+1);
        //     adapList[i][1]="Security Requirement "+(i+1);
        // }

        // String[] adapHeader={"Asset","Security Requirements"};
        // JTable adapTable = new JTable(adapList,adapHeader);
        // JScrollPane adapTScPane = new JScrollPane(adapTable);
        // adapTScPane.setPreferredSize(new Dimension(10,10));

        // adapTable.getColumnModel().getColumn(0).setMaxWidth(60);

        // addGBLComponent(adapTScPane, 1, 1,0.1,0.5,"BOTH");
        
        // JButton nextButton = new JButton("Next");

        // nextButton.addActionListener(new ActionListener(){
        //     @Override
        //     public void actionPerformed(ActionEvent e){
        //         panel.removeAll();
                
        //         JLabel label = new JLabel();
        //         label.setText("Adaptive Security Requirements for a threat-affected asset");
        //         addGBLComponent(label, 0, 0, 0.1, 0.1, "NONE", GridBagConstraints.LINE_START);

        //         IModelFieldGroup groups[] = new IModelFieldGroup[] {
        //                 new ModelField("Asset","Asset"),
        //                 new ModelField("Threat", "Threat"),
        //                 new ModelField("Technique", "Technique"),
        //                 new ModelField("Security Requirements for threats","Security Requirements for threats"),
        //                 new ModelFieldGroup("Adaptive Security Requirements for threat-affected assets", "Adaptive Security Requirements for threat-affected assets")
        //                         .withChild(new ModelField("M", "M"))
        //                         .withChild(new ModelField("R", "R"))
        //                         .withChild(new ModelField("P", "P"))
        //                         .withChild(new ModelField("P2", "P"))
        //         };

        //         // Get leafs of columns tree.
        //         ModelField fields[] = ModelFieldGroup.getBottomFields(groups);

        //         // Sample data.
        //         ModelRow rows[] = new ModelRow[30];
        //         for (int i = 0; i < rows.length; i++) {
        //             rows[i] = new ModelRow(fields.length);
        //             for (int j = 0; j < fields.length; j++)
        //                 rows[i].setValue(j, fields[j].getCaption() + i);
        //         }

        //         // Table.
        //         ModelData data = new ModelData(groups);
        //         data.setRows(rows);
        //         JBroTable table = new JBroTable(data);
        //         table.getTableHeader().setEnabled(false);

        //         addGBLComponent(table.getScrollPane(), 0, 1,3,1,0.,0.8,"BOTH");

        //         JButton saveButton = new JButton("Save");
        //         addGBLComponent(saveButton, 1, 2,0.15,0.1,"NONE",GridBagConstraints.LINE_END);

        //         JButton closeButton = new JButton("Close");
        //         addGBLComponent(closeButton, 2, 2,0.01,0.1,"NONE");


        //         panel.revalidate();

        //     }
        // });

        // addGBLComponent(nextButton, 1, 2,0.1,0.1,"NONE",GridBagConstraints.LINE_END);

    }

    public void updateTable(){
        ((DefaultTableModel)threatTable.getModel()).setRowCount(0);
        for (Threat t : ProcessedData.threatList) {
            ((DefaultTableModel)threatTable.getModel()).addRow(new String[] { t.getName() });
        }
    }

}
