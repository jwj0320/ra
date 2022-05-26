package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import gui.tabbedContent.api.OntologyFunc;
import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;

public class OrgPanel extends GridBagPanel {

    public OrgPanel(JTabbedPane tabbedPane) {
        super(tabbedPane);
        OntologyFunc ontologyFunc2 = new OntologyFunc("");

        // JPanel panel = this;
        // panel.setLayout(new GridBagLayout());

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel();
        infoLabel.setText("Select an organizaion to assess security risks for an attack.");

        addGBLComponent(infoLabel, 0, 0, 5, 1, 0.0, 0.1, "NONE", GridBagConstraints.LINE_START);

        JLabel orgLabel = new JLabel();
        orgLabel.setText("Organizaion");
        addGBLComponent(orgLabel, 1, 1, 0.01, 0.1);

        JComboBox<Object> orgComboBox = new JComboBox<>(); 
        for (String org: ontologyFunc2.LoadAllOrg()){
            orgComboBox.addItem(org);
            System.out.println(org);
        }
        orgComboBox.setSelectedIndex(-1);
        orgComboBox.setPreferredSize(new Dimension(250, 22));

        addGBLComponent(orgComboBox, 2, 1, 0.0, 0.1);

        JButton selectButton = new JButton("Select");
        addGBLComponent(selectButton, 4, 1, 0.005, 0.1);

        JButton createButton = new JButton("Create");
        addGBLComponent(createButton, 5, 1, 0.005, 0.1);

        GridBagPanel bpPane = new GridBagPanel();

        JLabel bplabel=makeHeader("Business Process");
        JLabel hlabel=makeHeader("Human");
        JLabel itslabel=makeHeader("Information Technology System");
        JLabel pelabel=makeHeader("Physical & Environment");

        bpPane.addGBLComponent(bplabel, 0, 0,1,2,"BOTH");
        bpPane.addGBLComponent(hlabel, 1, 0,2,1,"BOTH");
        bpPane.addGBLComponent(itslabel, 3, 0,4,1,"BOTH");
        bpPane.addGBLComponent(pelabel, 7, 0,4,1,"BOTH");

        JLabel rolelabel=makeHeader("Role");
        JLabel personlabel=makeHeader("Person");
        JLabel softwarelabel=makeHeader("Software");
        JLabel datalabel=makeHeader("Data");
        JLabel platformlabel=makeHeader("Platform");
        JLabel hardwarelabel=makeHeader("Hardware");
        JLabel dalabel=makeHeader("DA");
        JLabel celabel=makeHeader("CE");
        JLabel selabel=makeHeader("SE");
        JLabel mdlabel=makeHeader("MD");

        bpPane.addGBLComponent(rolelabel, 1, 1,1,1,"BOTH");
        bpPane.addGBLComponent(personlabel,2, 1,1,1,"BOTH");
        bpPane.addGBLComponent(softwarelabel, 3, 1,1,1,"BOTH");
        bpPane.addGBLComponent(datalabel,4, 1,1,1,"BOTH");
        bpPane.addGBLComponent(platformlabel, 5, 1,1,1,"BOTH");
        bpPane.addGBLComponent(hardwarelabel, 6, 1,1,1,"BOTH");
        bpPane.addGBLComponent(dalabel, 7, 1,1,1,"BOTH");
        bpPane.addGBLComponent(celabel,8, 1,1,1,"BOTH");
        bpPane.addGBLComponent(selabel, 9, 1,1,1,"BOTH");
        bpPane.addGBLComponent(mdlabel, 10, 1,1,1,"BOTH");

        JTable bpTable = makeContentTable();
        JScrollPane bpTbSc = new JScrollPane(bpTable);
        bpTbSc.setPreferredSize(new Dimension(105,450));
        bpTbSc.getViewport().setBackground(Color.WHITE);
        
        orgComboBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ((DefaultTableModel)bpTable.getModel()).setRowCount(0);
                for (String bp : ontologyFunc2.LoadBPFromOrg(orgComboBox.getSelectedItem().toString())) {
                    ((DefaultTableModel) bpTable.getModel()).addRow(new String[] { bp });
                }
            }
        });
        bpPane.addGBLComponent(bpTbSc, 0, 2,1,1,"BOTH");
        
        JTable roleTable = makeContentTable();
        JScrollPane roleTbSc = new JScrollPane(roleTable);
        roleTbSc.setPreferredSize(new Dimension(105,450));
        roleTbSc.getViewport().setBackground(Color.WHITE);

        bpTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)roleTable.getModel()).setRowCount(0);
                for (String role : ontologyFunc2.LoadRoleFromBP(bpTable.getValueAt(bpTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) roleTable.getModel()).addRow(new String[] { role });
                }
            }
        });
        bpPane.addGBLComponent(roleTbSc, 1, 2,1,1,"BOTH");

        JTable personTable = makeContentTable();
        JScrollPane personTbSc = new JScrollPane(personTable);
        personTbSc.setPreferredSize(new Dimension(105,450));
        personTbSc.getViewport().setBackground(Color.WHITE);

        roleTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)personTable.getModel()).setRowCount(0);
                for (String person : ontologyFunc2.LoadPersonFromRole(roleTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) personTable.getModel()).addRow(new String[] { person });
                }
            }
        });
        bpPane.addGBLComponent(personTbSc, 2, 2,1,1,"BOTH");
        
        JTable softwareTable = makeContentTable();
        JScrollPane softwareTbSc = new JScrollPane(softwareTable);
        softwareTbSc.setPreferredSize(new Dimension(105,450));
        softwareTbSc.getViewport().setBackground(Color.WHITE);

        roleTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)softwareTable.getModel()).setRowCount(0);
                for (String software : ontologyFunc2.LoadSWFromRole(roleTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) softwareTable.getModel()).addRow(new String[] { software });
                }
            }
        });
        bpPane.addGBLComponent(softwareTbSc, 3, 2,1,1,"BOTH");

        JTable dataTable = makeContentTable();
        JScrollPane dataTbSc = new JScrollPane(dataTable);
        dataTbSc.setPreferredSize(new Dimension(105,450));
        dataTbSc.getViewport().setBackground(Color.WHITE);

        softwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)dataTable.getModel()).setRowCount(0);
                for (String data : ontologyFunc2.LoadDataFromSW(softwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) dataTable.getModel()).addRow(new String[] { data });
                }
            }
        });
        bpPane.addGBLComponent(dataTbSc, 4, 2,1,1,"BOTH");

        JTable platformTable = makeContentTable();
        JScrollPane platformTbSc = new JScrollPane(platformTable);
        platformTbSc.setPreferredSize(new Dimension(105,450));
        platformTbSc.getViewport().setBackground(Color.WHITE);

        softwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)platformTable.getModel()).setRowCount(0);
                for (String platform : ontologyFunc2.LoadPlatformFromSW(softwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) platformTable.getModel()).addRow(new String[] { platform });
                }
            }
        });
        bpPane.addGBLComponent(platformTbSc, 5, 2,1,1,"BOTH");

        JTable hardwareTable = makeContentTable();
        JScrollPane hardwareTbSc = new JScrollPane(hardwareTable);
        hardwareTbSc.setPreferredSize(new Dimension(105,450));
        hardwareTbSc.getViewport().setBackground(Color.WHITE);

        softwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)hardwareTable.getModel()).setRowCount(0);
                for (String hardware : ontologyFunc2.LoadHardwareFromSW(softwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) hardwareTable.getModel()).addRow(new String[] { hardware });
                }
            }
        });
        bpPane.addGBLComponent(hardwareTbSc, 6, 2,1,1,"BOTH");

        JTable daTable = makeContentTable();
        JScrollPane daTbSc = new JScrollPane(daTable);
        daTbSc.setPreferredSize(new Dimension(105,450));
        daTbSc.getViewport().setBackground(Color.WHITE);

        hardwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)daTable.getModel()).setRowCount(0);
                for (String de : ontologyFunc2.LoadDAFromHW(hardwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) daTable.getModel()).addRow(new String[] { de });
                }
            }
        });
        bpPane.addGBLComponent(daTbSc, 7, 2,1,1,"BOTH");

        JTable ceTable = makeContentTable();
        JScrollPane ceTbSc = new JScrollPane(ceTable);
        ceTbSc.setPreferredSize(new Dimension(105,450));
        ceTbSc.getViewport().setBackground(Color.WHITE);

        // softwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        //     @Override
        //     public void valueChanged(ListSelectionEvent e){
        //         ((DefaultTableModel)ceTable.getModel()).setRowCount(0);
        //         for (String ce : ontologyFunc2.LoadCEFromDA(softwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
        //             ((DefaultTableModel) ceTable.getModel()).addRow(new String[] { ce });
        //         }
        //     }
        // });
        bpPane.addGBLComponent(ceTbSc, 8, 2,1,1,"BOTH");

        JTable seTable = makeContentTable();
        JScrollPane seTbSc = new JScrollPane(seTable);
        seTbSc.setPreferredSize(new Dimension(105,450));
        seTbSc.getViewport().setBackground(Color.WHITE);

        // softwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        //     @Override
        //     public void valueChanged(ListSelectionEvent e){
        //         ((DefaultTableModel)seTable.getModel()).setRowCount(0);
        //         for (String se : ontologyFunc2.LoadSEFromSW(softwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
        //             ((DefaultTableModel) seTable.getModel()).addRow(new String[] { se });
        //         }
        //     }
        // });
        bpPane.addGBLComponent(seTbSc, 9, 2,1,1,"BOTH");

        JTable mdTable = makeContentTable();
        JScrollPane mdTbSc = new JScrollPane(mdTable);
        mdTbSc.setPreferredSize(new Dimension(105,450));
        mdTbSc.getViewport().setBackground(Color.WHITE);

        softwareTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ((DefaultTableModel)mdTable.getModel()).setRowCount(0);
                for (String md : ontologyFunc2.LoadMDFromSW(softwareTable.getValueAt(roleTable.getSelectedRow(),0).toString())) {
                    ((DefaultTableModel) mdTable.getModel()).addRow(new String[] { md });
                }
            }
        });
        bpPane.addGBLComponent(mdTbSc, 10, 2,1,1,"BOTH");


        addGBLComponent(bpPane, 0, 2, 7, 1, 0.0, 0.4, "BOTH");
        //

        // IModelFieldGroup groups[] = new IModelFieldGroup[] {
        //         new ModelField("Business Process", "Business Process"),
        //         new ModelFieldGroup("Human", "Human")
        //                 .withChild(new ModelField("Role", "Role"))
        //                 .withChild(new ModelField("Person", "Person")), // Custom rowspan set.
        //         new ModelFieldGroup("Information Technology", "Information Technology")
        //                 .withChild(new ModelField("Software", "Software"))
        //                 .withChild(new ModelField("Data", "Data"))
        //                 .withChild(new ModelField("Platform", "Platform"))
        //                 .withChild(new ModelField("Hardware", "Hardware")),
        //         new ModelField("Physical & Environment", "Physical & Environment")
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

        // addGBLComponent(table.getScrollPane(), 0, 2, 7, 1, 0.0, 0.4, "BOTH");

        //

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
