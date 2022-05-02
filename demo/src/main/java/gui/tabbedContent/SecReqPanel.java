package gui.tabbedContent;

import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;

public class SecReqPanel extends GridBagPanel{
    
    public SecReqPanel(JTabbedPane tabbedPane){
        super(tabbedPane);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel secLabel = new JLabel();
        secLabel.setText("Security requirement for a threat");
        addGBLComponent(secLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        String[][] secList = new String[30][2];
        for (int i=0;i<secList.length;i++){
            secList[i][0]="T"+(i+1);
            secList[i][1]="Security Requirement "+(i+1);
        }

        String[] secHeader={"Threat","Security Requirements"};
        JTable secTable = new JTable(secList,secHeader);
        JScrollPane secTScPane = new JScrollPane(secTable);
        secTScPane.setPreferredSize(new Dimension(10,10));

        secTable.getColumnModel().getColumn(0).setMaxWidth(60);

        addGBLComponent(secTScPane, 0, 1,0.1,0.5,"BOTH");

        JLabel adapLabel = new JLabel();
        adapLabel.setText("Adaptive Security Requirements for a threat-affected asset");
        addGBLComponent(adapLabel, 1, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        String[][] adapList = new String[30][2];
        for (int i=0;i<adapList.length;i++){
            adapList[i][0]="A"+(i+1);
            adapList[i][1]="Security Requirement "+(i+1);
        }

        String[] adapHeader={"Asset","Security Requirements"};
        JTable adapTable = new JTable(adapList,adapHeader);
        JScrollPane adapTScPane = new JScrollPane(adapTable);
        adapTScPane.setPreferredSize(new Dimension(10,10));

        adapTable.getColumnModel().getColumn(0).setMaxWidth(60);

        addGBLComponent(adapTScPane, 1, 1,0.1,0.5,"BOTH");
        
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel.removeAll();
                
                JLabel label = new JLabel();
                label.setText("Adaptive Security Requirements for a threat-affected asset");
                addGBLComponent(label, 0, 0, 0.1, 0.1, "NONE", GridBagConstraints.LINE_START);

                IModelFieldGroup groups[] = new IModelFieldGroup[] {
                        new ModelField("Asset","Asset"),
                        new ModelField("Threat", "Threat"),
                        new ModelField("Technique", "Technique"),
                        new ModelField("Security Requirements for threats","Security Requirements for threats"),
                        new ModelFieldGroup("Adaptive Security Requirements for threat-affected assets", "Adaptive Security Requirements for threat-affected assets")
                                .withChild(new ModelField("M", "M"))
                                .withChild(new ModelField("R", "R"))
                                .withChild(new ModelField("P", "P"))
                                .withChild(new ModelField("P2", "P"))
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

                addGBLComponent(table.getScrollPane(), 0, 1,3,1,0.,0.8,"BOTH");

                JButton saveButton = new JButton("Save");
                addGBLComponent(saveButton, 1, 2,0.15,0.1,"NONE",GridBagConstraints.LINE_END);

                JButton closeButton = new JButton("Close");
                addGBLComponent(closeButton, 2, 2,0.01,0.1,"NONE");


                panel.revalidate();

            }
        });

        addGBLComponent(nextButton, 1, 2,0.1,0.1,"NONE",GridBagConstraints.LINE_END);

    }

}
