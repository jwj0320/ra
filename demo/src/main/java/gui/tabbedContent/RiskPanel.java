package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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

        JPanel tabPanel = new JPanel();
        tabPanel.setLayout(new BorderLayout());

        IModelFieldGroup groups[] = new IModelFieldGroup[] {
                new ModelFieldGroup("Threat", "Threat")
                        .withChild(new ModelField("Threat2","Threat"))
                        .withChild(new ModelField("Group", "Group"))
                        .withChild(new ModelField("Tactic","Tactic"))
                        .withChild(new ModelField("Technique","Technique"))
                        .withChild(new ModelField("Software","Software"))
                        .withChild(new ModelField("Platform","Platform"))
                        .withChild(new ModelField("Attack Pattern","Attack Pattern")),
                new ModelFieldGroup("Vulnerability", "Vulnerability")
                        .withChild(new ModelField("Weakness", "Weakness"))
                        .withChild(new ModelField("Vulnerability2", "Vulnerability"))
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

        
        // vulPanel.addGBLComponent(table.getScrollPane(), 0, 0,0.1,0.1,"BOTH");
        tabPanel.add(table.getScrollPane());

        addGBLComponent(tabPanel, 0, 0,2,1,0.1,0.1,"BOTH");

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener(){
            private boolean isClicked = false;

            @Override
            public void actionPerformed(ActionEvent e){
                if (!isClicked){
                    isClicked=true;
                    JTable assetTable = new JTable();
                    JScrollPane assetScrollPane = new JScrollPane(assetTable);
                    tabPanel.removeAll();
                    tabPanel.add(assetScrollPane);
                    tabPanel.revalidate();
                } else {

                }
            }
        });

        addGBLComponent(nextButton, 1, 1,0.1,0.1,"NONE",GridBagConstraints.LINE_END);
    }
}
