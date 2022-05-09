package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;

public class OrgPanel extends GridBagPanel {

    public OrgPanel(JTabbedPane tabbedPane) {
        super(tabbedPane);
        // JPanel panel = this;
        // panel.setLayout(new GridBagLayout());

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel();
        infoLabel.setText("Select an organizaion to assess security risks for an attack.");

        addGBLComponent(infoLabel, 0, 0, 5, 1, 0.0, 0.1, "NONE", GridBagConstraints.LINE_START);

        JLabel orgLabel = new JLabel();
        orgLabel.setText("Organizaion");
        addGBLComponent(orgLabel, 1, 1, 0.01, 0.1);

        JComboBox<Object> orgComboBox = new JComboBox<>(); // Object는 추후에 수정
        orgComboBox.addItem("Sample Company");
        orgComboBox.setPreferredSize(new Dimension(250, 22));
        addGBLComponent(orgComboBox, 2, 1, 0.0, 0.1);

        JButton selectButton = new JButton("Select");
        addGBLComponent(selectButton, 4, 1, 0.005, 0.1);

        JButton createButton = new JButton("Create");
        addGBLComponent(createButton, 5, 1, 0.005, 0.1);

        IModelFieldGroup groups[] = new IModelFieldGroup[] {
                new ModelField("Business Process", "Business Process"),
                new ModelFieldGroup("Human", "Human")
                        .withChild(new ModelField("Role", "Role"))
                        .withChild(new ModelField("Person", "Person")), // Custom rowspan set.
                new ModelFieldGroup("Information Technology", "Information Technology")
                        .withChild(new ModelField("Software", "Software"))
                        .withChild(new ModelField("Data", "Data"))
                        .withChild(new ModelField("Platform", "Platform"))
                        .withChild(new ModelField("Hardware", "Hardware")),
                new ModelField("Physical & Environment", "Physical & Environment")
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

        addGBLComponent(table.getScrollPane(), 0, 2, 7, 1, 0.0, 0.4, "BOTH");

        JButton nextButton = new JButton("Next");
        addGBLComponent(nextButton, 6, 3, 0.5, 0.1, "NONE", GridBagConstraints.LINE_END);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GridBagPanel createPanel = new GridBagPanel(tabbedPane);

                createPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JLabel infoLabel = new JLabel();
                infoLabel.setText("");

                createPanel.addGBLComponent(infoLabel, 0, 0, 5, 1, 0.0, 0.1, "NONE", GridBagConstraints.LINE_START);

                JLabel orgLabel = new JLabel();
                orgLabel.setText("Organizaion");
                createPanel.addGBLComponent(orgLabel, 1, 1, 0.01, 0.1);

                JComboBox<Object> orgComboBox = new JComboBox<>(); // Object는 추후에 수정
                orgComboBox.addItem("Sample Company");
                orgComboBox.setPreferredSize(new Dimension(250, 22));
                createPanel.addGBLComponent(orgComboBox, 2, 1, 0.0, 0.1);


                IModelFieldGroup groups[] = new IModelFieldGroup[] {
                        new ModelField("Business Process", "Business Process"),
                        new ModelFieldGroup("Human", "Human")
                                .withChild(new ModelField("Role", "Role"))
                                .withChild(new ModelField("Person", "Person")), // Custom rowspan set.
                        new ModelFieldGroup("Information Technology", "Information Technology")
                                .withChild(new ModelField("Software", "Software"))
                                .withChild(new ModelField("Data", "Data"))
                                .withChild(new ModelField("Platform", "Platform"))
                                .withChild(new ModelField("Hardware", "Hardware")),
                        new ModelField("Physical & Environment", "Physical & Environment")
                };

                // Get leafs of columns tree.
                ModelField fields[] = ModelFieldGroup.getBottomFields(groups);

                String[][] innerValue;
                String[] temp = null;
                // Sample data.
                ModelRow rows[] = new ModelRow[0];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = new ModelRow(fields.length);
                    for (int j = 0; j < fields.length; j++) {
                        // rows[i].setValue(j, fields[j].getCaption() + i);
                        innerValue = new String[3][1];
                        temp = new String[1];
                        temp[0] = fields[j].getCaption();
                        innerValue[0] = temp;
                        innerValue[1] = temp;
                        innerValue[2] = temp;
                        rows[i].setValue(j, innerValue);
                    }
                }

                // Table.
                ModelData data = new ModelData(groups);
                data.setRows(rows);
                JBroTable table = new JBroTable(data);
                table.getTableHeader().setEnabled(false);
                table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                            boolean hasFocus, int row, int column) {
                        String[] headers = { "" };
                        String[][] rows = (String[][]) value;
                        String[] t = (String[])value;
                        // DefaultTableModel model = new DefaultTableModel(columns,0);
                        JTable insideTable = new JTable(rows, headers);

                        table.setRowHeight(row, 20 + (15 * insideTable.getRowCount()));
                        JScrollPane columnFix = new JScrollPane(insideTable);
                        columnFix.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

                        return columnFix;
                    }
                });

                JScrollPane tableScPane = table.getScrollPane();
                // tableScPane.setPreferredSize(new Dimension(10,46));

                createPanel.addGBLComponent(tableScPane, 0, 2, 9, 1, 0.0, 0.4, "BOTH");

                JButton cancelButton = new JButton("Cancel");
                createPanel.addGBLComponent(cancelButton, 6, 3, 0.8, 0.1,"NONE", GridBagConstraints.LINE_END);
                JButton applyButton = new JButton("Apply");
                createPanel.addGBLComponent(applyButton, 7, 3, 0.05, 0.1);
                JButton confirmButton = new JButton("Confirm");
                createPanel.addGBLComponent(confirmButton, 8, 3, 0.05, 0.1);
                tabbedPane.setComponentAt(tabbedPane.getSelectedIndex(), createPanel);

            }
        });
    }
}
