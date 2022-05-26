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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.tabbedContent.api.OntologyFunc;
import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;

public class RiskPanel extends GridBagPanel {
    
    public RiskPanel(JTabbedPane tabbedPane) {
        super(tabbedPane);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Threat");
        addGBLComponent(nameLabel, 0, 0,3,1,0.1,0.1,"NONE",GridBagConstraints.LINE_START);


        JLabel detailLabel = new JLabel();
        detailLabel.setText("Attack Component");
        addGBLComponent(detailLabel, 3, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        
        String[] header = {"Threat"};
        
        JTable table = new JTable(new DefaultTableModel(header,0));

        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Threat ID");
        JLabel label1=makeHeader("Technique");
        JLabel label2=makeHeader("Tactics");
        JLabel label3=makeHeader("Software");
        
        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 1,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(label3, 0, 3,1,4,"BOTH");
        
        // 나중에 추가
       

        
    }

    
}
