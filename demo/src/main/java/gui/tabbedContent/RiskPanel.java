package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import gui.tabbedContent.api.OntologyFunc;
import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;
import type.ProcessedData;
import type.Software;
import type.Threat;

public class RiskPanel extends GridBagPanel {

    private JTable table;
    
    public RiskPanel(JTabbedPane tabbedPane) {
        super(tabbedPane);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // JLabel nameLabel = new JLabel();
        // nameLabel.setText("Threat");
        // addGBLComponent(nameLabel, 0, 0,3,1,0.1,0.1,"NONE",GridBagConstraints.LINE_START);


        // JLabel detailLabel = new JLabel();
        // detailLabel.setText("Attack Component");
        // addGBLComponent(detailLabel, 3, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        GridBagPanel threatPane = new GridBagPanel();
        threatPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),"Threats"), 
            BorderFactory.createEmptyBorder(20,20,20,20)));
        addGBLComponent(threatPane, 0, 0,2,1);

        String[] header = {"Threats"};

        table = new JTable(new DefaultTableModel(header,0));
        

        JScrollPane thTabSc = new JScrollPane(table);
        thTabSc.setPreferredSize(new Dimension(200,100));

        threatPane.addGBLComponent(thTabSc, 0, 0,0.2,0.2,"BOTH");

        

        GridBagPanel detailPane = new GridBagPanel();
        detailPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel threatLabel = new JLabel("Threat Details");
        JLabel threatEmptyLabel = new JLabel("");
        threatEmptyLabel.setPreferredSize(new Dimension(10,10));

        detailPane.addGBLComponent(threatLabel, 0, 0);
        detailPane.addGBLComponent(threatEmptyLabel, 0, 1);

        JLabel label0=makeHeader("Threat ID");
        JLabel label1=makeHeader("Technique");
        JLabel label2=makeHeader("Tactics");
        JLabel label3=makeHeader("Software");
        JLabel labelA=makeContent("00");
        JLabel labelB=makeContent("00");

        JTable tacticTable = makeContentTable();
        JScrollPane tacticTableSc=new JScrollPane(tacticTable);

        tacticTableSc.setPreferredSize(new Dimension(100,130));

        JTable swTable = makeContentTable();
        JScrollPane swTableSc=new JScrollPane(swTable);

        swTableSc.setPreferredSize(new Dimension(500,230));
        
        detailPane.addGBLComponent(label0, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 3,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 4,1,1,"BOTH");
        detailPane.addGBLComponent(label3, 0, 5,1,4,"BOTH");
        detailPane.addGBLComponent(labelA, 1, 2,1,1,"BOTH");
        detailPane.addGBLComponent(labelB, 1, 3,1,1,"BOTH");
        detailPane.addGBLComponent(tacticTableSc, 1, 4,1,1,"BOTH");
        detailPane.addGBLComponent(swTableSc, 1, 5);

        JTabbedPane innerTabbedPane = new JTabbedPane();
        innerTabbedPane.addTab("Threat", detailPane);
        
        threatPane.addGBLComponent(innerTabbedPane, 3, 0,5,1,0.6,0.6,"BOTH");

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                String value = table.getValueAt(table.getSelectedRow(), 0).toString();
                Threat threat = ProcessedData.getThreat(value);
                labelA.setText(threat.getName());
                labelB.setText(threat.getTechnique().getName());
                ((DefaultTableModel)tacticTable.getModel()).setRowCount(0);
                for (String t:threat.getTacticList()){
                    ((DefaultTableModel)tacticTable.getModel()).addRow(new String[]{t});
                }
                ((DefaultTableModel)swTable.getModel()).setRowCount(0);
                for (Software s:threat.getSoftwareList()){
                    ((DefaultTableModel)swTable.getModel()).addRow(new String[]{s.getName()});
                }
                
                
                
            }
            
        });

        JLabel emptyLabel1 = new JLabel("");
        emptyLabel1.setPreferredSize(new Dimension(10,10));
        threatPane.addGBLComponent(emptyLabel1, 3, 1);
        
        JLabel emptyLabel2 = new JLabel("");
        emptyLabel2.setPreferredSize(new Dimension(20,10));
        threatPane.addGBLComponent(emptyLabel2, 2, 0);

        // JButton vulButton = new JButton("Vulnerability");

        // threatPane.addGBLComponent(vulButton, 4, 2,0.1,0.1);

        // JButton assetButton = new JButton("Asset");

        // threatPane.addGBLComponent(assetButton, 5, 2,0.1,0.1);
        
        // JDialog vulDialog = new JDialog();
        
        GridBagPanel vulPane = new GridBagPanel();
        vulPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel vulLabel = new JLabel("Vulnerability Details");
        JLabel vulEmptyLabel = new JLabel("");
        vulEmptyLabel.setPreferredSize(new Dimension(10,10));

        vulPane.addGBLComponent(vulLabel, 0, 0);
        vulPane.addGBLComponent(vulEmptyLabel, 0, 1);
        
        JLabel vulLabel0=makeHeader("Vulnerability ID");
        JLabel vulLabel1=makeHeader("CAPEC-ID");
        JLabel vulLabel2=makeHeader("CWE-ID");
        JLabel vulLabel3=makeHeader("CVE-ID");
        JLabel vulLabelA=makeContent("V0034"); // 추후 수정
        JLabel vulLabelB=makeContent("CAPEC-309");

        JTable cweTable = makeContentTable();
        JScrollPane cweTabSc = new JScrollPane(cweTable);
        cweTabSc.setPreferredSize(new Dimension(500,170));
        

        JTable cveTable = makeContentTable();
        JScrollPane cveTabSc = new JScrollPane(cveTable);
        cveTabSc.setPreferredSize(new Dimension(500,180));

        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2000-1117:Virtual machine allows malicious web site operators to determine the existence of files on the client by measuring delays in the execution of the getSystemResource method."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2001-1483:Enumeration of valid usernames based on inconsistent responses"});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2001-1528:Account number enumeration via inconsistent responses."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2002-0515:Product sets a different TTL when a port is being filtered than when it is not being filtered, which allows remote attackers to identify filtered ports by comparing TTLs."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2002-1725:Script calls phpinfo(), revealing system configuration to web user"});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2003-0190:Product immediately sends an error message when a user does not exist, which allows remote attackers to determine valid usernames via a timing attack."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2004-0778:Version control system allows remote attackers to determine the existence of arbitrary files and directories via the -X command for an alternate history file, which causes different error messages to be returned."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2004-2150:User enumeration via discrepancies in error messages."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2004-2268:Password exposed in debug information."});
        ((DefaultTableModel)cveTable.getModel()).addRow(new String[]{"CVE-2005-0603:Malformed regexp syntax leads to information exposure in error message."});

        ((DefaultTableModel)cweTable.getModel()).addRow(new String[]{"CWE-200:Exposure of Sensitive Information to an Unauthorized Actor"});
        
        vulPane.addGBLComponent(vulLabel0, 0, 2,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabel1, 0, 3,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabel2, 0, 4,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabel3, 0, 5,1,4,"BOTH");
        vulPane.addGBLComponent(vulLabelA, 1, 2,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabelB, 1, 3,1,1,"BOTH");
        vulPane.addGBLComponent(cweTabSc, 1, 4,1,1,"BOTH");
        vulPane.addGBLComponent(cveTabSc, 1, 5);
        
        innerTabbedPane.addTab("Vulnerability", vulPane);

        // vulDialog.add(vulPane);
        // vulDialog.setSize(450,300);
        // vulDialog.setLocationRelativeTo(null);
        
        // vulButton.addActionListener(new ActionListener(){
        //     @Override
        //     public void actionPerformed(ActionEvent e){
        //         vulDialog.setVisible(true);
        //     }
        // });


        JDialog assetDialog = new JDialog();
        
        GridBagPanel assetPane = new GridBagPanel();

        JLabel assetLabel = new JLabel("Vulnerability Details");
        JLabel assetEmptyLabel = new JLabel("");
        assetEmptyLabel.setPreferredSize(new Dimension(10,10));

        assetPane.addGBLComponent(assetLabel, 0, 0);
        assetPane.addGBLComponent(assetEmptyLabel, 0, 1);
        
        JLabel assetLabel0=makeHeader("Asset ID");
        JLabel assetLabel1=makeHeader("Criticality");
        JLabel assetLabel2=makeHeader("Exposure to threat");
        JLabel assetLabelA=makeContent("00");
        JLabel assetLabelB=makeContent("00");
        JLabel assetLabelC=makeContent("00");
        
        assetPane.addGBLComponent(assetLabel0, 0, 2,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabel1, 0, 3,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabel2, 0, 4,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabelA, 1, 2,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabelB, 1, 3,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabelC, 1, 4,1,1,"BOTH");

        innerTabbedPane.addTab("Asset", assetPane);
        
        // assetDialog.add(assetPane);
        // assetDialog.setSize(450,300);
        // assetDialog.setLocationRelativeTo(null);
        
        // assetButton.addActionListener(new ActionListener(){
        //     @Override
        //     public void actionPerformed(ActionEvent e){
        //         assetDialog.setVisible(true);
        //     }
        // });


        JButton nextButton = new JButton("Next");
        addGBLComponent(nextButton, 1, 1,0.0,0.0,"NONE",GridBagConstraints.LINE_END);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((SecReqPanel)(tabbedPane.getComponentAt(tabbedPane.getSelectedIndex()+1))).updateTable();
                tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
            }
        });

    }

    public void updateTable(){
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        for (Threat t : ProcessedData.threatList) {
            ((DefaultTableModel) table.getModel()).addRow(new String[] { t.getName() });

        }
    }

    
}
