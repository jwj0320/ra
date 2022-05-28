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

public class RiskPanel extends GridBagPanel {

    private ArrayList<String[]> threat;
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

        String[] header = {"Threats"};

        table = new JTable(new DefaultTableModel(header,0));
        

        JScrollPane thTabSc = new JScrollPane(table);
        thTabSc.setPreferredSize(new Dimension(10,10));

        addGBLComponent(thTabSc, 0, 0,0.2,0.2,"BOTH");

        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Threat ID");
        JLabel label1=makeHeader("Technique");
        JLabel label2=makeHeader("Tactics");
        JLabel label3=makeHeader("Software");
        JLabel labelA=makeContent("00");
        JLabel labelB=makeContent("00");
        JLabel labelC=makeContent("00");


        JTable swTable = makeContentTable();
        JScrollPane swTableSc=new JScrollPane(swTable);
        
        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 1,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(label3, 0, 3,1,4,"BOTH");
        detailPane.addGBLComponent(labelA, 1, 0,1,1,"BOTH");
        detailPane.addGBLComponent(labelB, 1, 1,1,1,"BOTH");
        detailPane.addGBLComponent(labelC, 1, 2,1,1,"BOTH");
        detailPane.addGBLComponent(swTableSc, 1, 3);
        
        addGBLComponent(detailPane, 1, 0,0.6,0.6,"BOTH");

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                String threat = table.getValueAt(table.getSelectedRow(), 0).toString();
                int num=Integer.parseInt(threat.split("Threat ID")[0]);
                System.out.println(num);
                //
                
            }
            
        });


        JButton vulButton = new JButton("Vulnerability");

        addGBLComponent(vulButton, 3, 4,0.1,0.1);

        JButton assetButton = new JButton("Asset");

        addGBLComponent(assetButton, 4, 4,0.1,0.1);
        
        JDialog vulDialog = new JDialog();
        
        GridBagPanel vulPane = new GridBagPanel();
        
        JLabel vulLabel0=makeHeader("Vulnerability ID");
        JLabel vulLabel1=makeHeader("CAPEC-ID");
        JLabel vulLabel2=makeHeader("CWE-ID");
        JLabel vulLabel3=makeHeader("CVE-ID");
        JLabel vulLabelA=makeContent("00");
        JLabel vulLabelB=makeContent("00");
        JLabel vulLabelC=makeContent("00");
        JTable vulTable = makeContentTable();
        JScrollPane vulTabSc = new JScrollPane(vulTable);
        vulTabSc.setPreferredSize(new Dimension(300,100));
        
        vulPane.addGBLComponent(vulLabel0, 0, 0,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabel1, 0, 1,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabel2, 0, 2,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabel3, 0, 3,1,4,"BOTH");
        vulPane.addGBLComponent(vulLabelA, 1, 0,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabelB, 1, 1,1,1,"BOTH");
        vulPane.addGBLComponent(vulLabelC, 1, 2,1,1,"BOTH");
        vulPane.addGBLComponent(vulTabSc, 1, 3);
        
        vulDialog.add(vulPane);
        vulDialog.setSize(450,300);
        vulDialog.setLocationRelativeTo(null);
        
        vulButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                vulDialog.setVisible(true);
            }
        });


        JDialog assetDialog = new JDialog();
        
        GridBagPanel assetPane = new GridBagPanel();
        
        JLabel assetLabel0=makeHeader("Asset ID");
        JLabel assetLabel1=makeHeader("Criticality");
        JLabel assetLabel2=makeHeader("Exposure to threat");
        JLabel assetLabelA=makeContent("00");
        JLabel assetLabelB=makeContent("00");
        JLabel assetLabelC=makeContent("00");
        
        assetPane.addGBLComponent(assetLabel0, 0, 0,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabel1, 0, 1,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabel2, 0, 2,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabelA, 1, 0,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabelB, 1, 1,1,1,"BOTH");
        assetPane.addGBLComponent(assetLabelC, 1, 2,1,1,"BOTH");
        
        assetDialog.add(assetPane);
        assetDialog.setSize(450,300);
        assetDialog.setLocationRelativeTo(null);
        
        assetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                assetDialog.setVisible(true);
            }
        });
    }

    public ArrayList<String[]> getThreat() {
        return threat;
    }

    public void setThreat(ArrayList<String[]> threat) {
        this.threat = threat;
    }

    public void update(){
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        int i=0;
        for (String[] t : threat) {
            ((DefaultTableModel) table.getModel()).addRow(new String[] { "Threat ID"+ ++i });

        }
    }

    
}
