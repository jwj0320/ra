package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import gui.tabbedContent.api.OntologyFunc;
import gui.tabbedContent.type.Software;
import gui.tabbedContent.type.TabbedPaneInfo;
import gui.tabbedContent.type.Technique;

public class AtkPanel extends GridBagPanel {

    OntologyFunc ontologyFunc = new OntologyFunc();

    public AtkPanel(TabbedPaneInfo tabbedPane){
        super(tabbedPane);
        setLayout(new BorderLayout());
        JTabbedPane innerTPane = new JTabbedPane(JTabbedPane.LEFT);
        innerTPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(innerTPane);
        

        JPanel grTab = makeGrTab(innerTPane);
        innerTPane.addTab("Group", grTab);

        JPanel techTab = makeTechTab(innerTPane);
        innerTPane.addTab("Techniques", techTab);

        JPanel softTab = makeSoftTab(innerTPane);
        innerTPane.addTab("Software", softTab);

        JPanel ncPanel = makeNCPanel(innerTPane);
        innerTPane.addTab("New Case", ncPanel);

        innerTPane.addTab("Result", new JPanel());
        

    }

    private JPanel makeGrTab(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Group Name");
        panel.addGBLComponent(nameLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

 
        String[] nameHeader = {"Group Name"};

        ArrayList<String[]> groupList = ontologyFunc.LoadAllGroup();
        String[][] groupAry=new String[groupList.size()][1];
        for (int i=0;i<groupList.size();i++){
            groupAry[i]=groupList.get(i);
        }

        JTable nameTable = new JTable(groupAry,nameHeader);
        // nameTable.setTableHeader(null);

        JScrollPane nameTableScPane=new JScrollPane(nameTable);
        
        nameTableScPane.setPreferredSize(new Dimension(10,10));
        panel.addGBLComponent(nameTableScPane, 0, 1,0.1,1.0,"BOTH");


        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Group ID");
        JLabel label1=makeContent("");
        JLabel label2=makeHeader("Techniques");
        JLabel label3=makeHeader("Software");
        JTable techTable=makeContentTable();
        JScrollPane techSc=new JScrollPane(techTable);
        JTable softTable=makeContentTable();
        JScrollPane softSc=new JScrollPane(softTable);
        softSc.setPreferredSize(new Dimension(203,403));

        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 1, 0,2,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 1,2,1,"BOTH");
        detailPane.addGBLComponent(label3, 2, 1,1,1,"BOTH");
        detailPane.addGBLComponent(techSc, 0, 2,2,1,"BOTH");
        detailPane.addGBLComponent(softSc, 2, 2,1,1,"BOTH");


        panel.addGBLComponent(detailPane, 2, 1,0.4,0.8,"BOTH");

        nameTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String value = nameTable.getValueAt(nameTable.getSelectedRow(), 0).toString();

                
                ArrayList<String[]> techList=ontologyFunc.LoadGroupTechnique(value);
                System.out.println("size: "+techList.size());
                String[][] techs=new String[techList.size()][1];
                for (int i=0;i<techList.size();i++){
                    techs[i]=new String[]{techList.get(i)[0]};
                }
                ((DefaultTableModel)techTable.getModel()).setRowCount(0);
                for (String[] row : techs){
                    ((DefaultTableModel)techTable.getModel()).addRow(row);
                    System.out.println(row);
                }

                
                
                // ArrayList<String[]> platformList=ontologyFunc.LoadSWPlatform(value);
                // String[][] swPlatforms=new String[platformList.size()][1];
                // for (int i=0;i<platformList.size();i++){
                //     swPlatforms[i]=platformList.get(i);
                // }
                // String text=swPlatforms[0][0];
                // for (int i=1;i<swPlatforms.length;i++){
                //     text+=", "+swPlatforms[i][0];
                // }
            }
        });
        
        return panel;
    }

    private JPanel makeTechTab(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Techniques for Risk Assessment");
        panel.addGBLComponent(nameLabel, 0, 0,3,1,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        JLabel detailLabel = new JLabel();
        detailLabel.setText("Attack Component");
        panel.addGBLComponent(detailLabel, 3, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);


        String[] techHeader = {"Techniues"};

        ArrayList<String[]> techList = ontologyFunc.LoadAllTech();
        String[][] techAry=new String[techList.size()][1];
        for (int i=0;i<techList.size();i++){
            techAry[i]=techList.get(i);
        }
        
        JTable techTable = new JTable(techAry,techHeader);
        
        JScrollPane techTableSCPane= new JScrollPane(techTable);
        techTableSCPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(techTableSCPane, 0, 1, 0.3,0.8,"BOTH");

        JButton selectButton = new JButton(">");
        
        panel.addGBLComponent(selectButton, 1, 1, 0.05,0.8);
        
        String[][] selectedList = new String[0][1];

        JTable selectedTable = new JTable(new DefaultTableModel(techHeader,0));

        JScrollPane selectedScrollPane = new JScrollPane(selectedTable);
        selectedScrollPane.setPreferredSize(new Dimension(10,10));
        
        panel.addGBLComponent(selectedScrollPane, 2,1, 0.3,0.8,"BOTH");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=techTable.getValueAt(techTable.getSelectedRow(), techTable.getSelectedColumn()).toString();
                ((DefaultTableModel)selectedTable.getModel()).addRow(new String[]{value});
            }
        });

        String colNames[] = {"header","content"};
        
        Object data[][];
        data = new Object[4][2];

        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Technique ID");
        JLabel label1=makeHeader("Sub-technique of");
        JLabel label2=makeHeader("Platforms");
        JLabel label3=makeHeader("Tactics");
        JLabel label4=makeHeader("Mitigations");
        JLabel label5=makeHeader("Detections");
        JLabel label6=makeHeader("Attack Patterns");
        
        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 1,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 2,1,3,"BOTH");
        detailPane.addGBLComponent(label3, 0, 5,1,1,"BOTH");
        detailPane.addGBLComponent(label4, 0, 6,1,1,"BOTH");
        detailPane.addGBLComponent(label5, 0, 7,1,3,"BOTH");
        detailPane.addGBLComponent(label6, 0, 10,1,1,"BOTH");
        
        JLabel labelA=makeContent("00");
        JLabel labelB=makeContent("00");
        JLabel labelC=makeContent("00");
        JLabel labelD=makeContent("00");
        JLabel labelE=makeContent("00");
        JLabel labelF=makeContent("00");
        JLabel labelG=makeContent("00");
        JLabel labelH=makeContent("00");
        JLabel labelI=makeContent("00");
        JLabel labelJ=makeContent("00");
        JLabel labelK=makeContent("00");

        detailPane.addGBLComponent(labelA, 1, 0,1,1,"BOTH");
        detailPane.addGBLComponent(labelB, 1, 1,1,1,"BOTH");
        detailPane.addGBLComponent(labelC, 1, 2,1,1,"BOTH");
        detailPane.addGBLComponent(labelD, 1, 3,1,1,"BOTH");
        detailPane.addGBLComponent(labelE, 1, 4,1,1,"BOTH");
        detailPane.addGBLComponent(labelF, 1, 5,1,1,"BOTH");
        detailPane.addGBLComponent(labelG, 1, 6,1,1,"BOTH");
        detailPane.addGBLComponent(labelH, 1, 7,1,1,"BOTH");
        detailPane.addGBLComponent(labelI, 1, 8,1,1,"BOTH");
        detailPane.addGBLComponent(labelJ, 1, 9,1,1,"BOTH");
        detailPane.addGBLComponent(labelK, 1, 10,1,1,"BOTH");


        panel.addGBLComponent(detailPane, 3, 1,0.4,0.8,"BOTH");

        selectedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String value = selectedTable.getValueAt(selectedTable.getSelectedRow(), 0).toString();

                String techID=value.split(":")[0];
                labelA.setText(techID);
                labelB.setText(techID.split("\\.")[0]);

                // ArrayList<String[]> platformList=ontologyFunc.LoadSWPlatform(value);
                // String[][] swPlatforms=new String[platformList.size()][1];
                // for (int i=0;i<platformList.size();i++){
                //     swPlatforms[i]=platformList.get(i);
                // }
                // String text=swPlatforms[0][0];
                // for (int i=1;i<swPlatforms.length;i++){
                //     text+=", "+swPlatforms[i][0];
                // }
                // labelC.setText(text); // 추후 수정


                // ArrayList<String[]> techList=ontologyFunc.LoadSWTech(value);
                // String[][] swTechs=new String[techList.size()][1];
                // for (int i=0;i<techList.size();i++){
                //     swTechs[i]=techList.get(i);
                // }
                // ((DefaultTableModel)contTable.getModel()).setRowCount(0);
                // for (String[] row : swTechs){
                //     ((DefaultTableModel)contTable.getModel()).addRow(row);
                // }
            }
        });
 

        // JTable detailTable = new JTable(data, colNames);
        // detailTable.setTableHeader(null);

   
        // JScrollPane detailScroll = new JScrollPane(detailTable);
        // detailScroll.setPreferredSize(new Dimension(10,10));
  
        // panel.addGBLComponent(detailScroll, 3, 1,0.1,0.8,"BOTH");


        return panel;
    }

    private JPanel makeSoftTab(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Software for Risk Assessment");
        panel.addGBLComponent(nameLabel, 0, 0,3,1,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        // JLabel nameLabel = new JLabel();
        // nameLabel.setText("Software");
        // panel.addGBLComponent(nameLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        JLabel detailLabel = new JLabel();
        detailLabel.setText("Attack Component");
        panel.addGBLComponent(detailLabel, 3, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        
        String[] softHeader = {"Software"};
        
        
        ArrayList<String[]> swList = ontologyFunc.LoadAllSW();
        String[][] swAry=new String[swList.size()][1];
        for (int i=0;i<swList.size();i++){
            swAry[i]=swList.get(i);
        }

        JTable softTable = new JTable(swAry,softHeader);
        
        
        JScrollPane softTableSCPane= new JScrollPane(softTable);
        softTableSCPane.setPreferredSize(new Dimension(10,10));
        
        panel.addGBLComponent(softTableSCPane, 0, 1, 0.6,0.8,"BOTH");



        JButton selectButton = new JButton(">");
        panel.addGBLComponent(selectButton, 1, 1, 0.1,0.8);

        String[][] selectedList = new String[0][1];

        JTable selectedTable = new JTable(new DefaultTableModel(softHeader,0));


        JScrollPane selectedScrollPane = new JScrollPane(selectedTable);
        selectedScrollPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(selectedScrollPane, 2,1, 0.6,0.8,"BOTH");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=softTable.getValueAt(softTable.getSelectedRow(), softTable.getSelectedColumn()).toString();
                ((DefaultTableModel)selectedTable.getModel()).addRow(new String[]{value});
            }
        });

        GridBagPanel detailPane = new GridBagPanel();
        JLabel label0=makeHeader("Software ID");
        JLabel label1=makeHeader("Type");
        JLabel label2=makeHeader("Platforms");
        JLabel label3=makeHeader("Techniques");
        
        detailPane.addGBLComponent(label0, 0, 0,1,1,"BOTH");
        detailPane.addGBLComponent(label1, 0, 1,1,1,"BOTH");
        detailPane.addGBLComponent(label2, 0, 2,1,1,"BOTH");
        detailPane.addGBLComponent(label3, 0, 3,1,4,"BOTH");
        
        JLabel labelA=makeContent("00");
        JLabel labelB=makeContent("00");
        JLabel labelC=makeContent("00");
        JTable contTable=makeContentTable();
        JScrollPane contTabSc=new JScrollPane(contTable);
        // contTabSc.setPreferredSize(new Dimension(100,100));

        detailPane.addGBLComponent(labelA, 1, 0,1,1,"BOTH");
        detailPane.addGBLComponent(labelB, 1, 1,1,1,"BOTH");
        detailPane.addGBLComponent(labelC, 1, 2,1,1,"BOTH");
        detailPane.addGBLComponent(contTabSc, 1, 3,1,4,"BOTH");


        panel.addGBLComponent(detailPane, 3, 1,0.4,0.8,"BOTH");


        
        selectedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String value = selectedTable.getValueAt(selectedTable.getSelectedRow(), 0).toString();

                labelA.setText(value.split(":")[0]);
            

                ArrayList<String[]> platformList=ontologyFunc.LoadSWPlatform(value);
                String[][] swPlatforms=new String[platformList.size()][1];
                for (int i=0;i<platformList.size();i++){
                    swPlatforms[i]=platformList.get(i);
                }
                String text=swPlatforms[0][0];
                for (int i=1;i<swPlatforms.length;i++){
                    text+=", "+swPlatforms[i][0];
                }
                labelC.setText(text); // 추후 수정


                ArrayList<String[]> techList=ontologyFunc.LoadSWTech(value);
                String[][] swTechs=new String[techList.size()][1];
                for (int i=0;i<techList.size();i++){
                    swTechs[i]=techList.get(i);
                }
                ((DefaultTableModel)contTable.getModel()).setRowCount(0);
                for (String[] row : swTechs){
                    ((DefaultTableModel)contTable.getModel()).addRow(row);
                }
            }
        });

        
        // String colNames[] = {"header","content"};
        
        // Object data[][];
        // data = new Object[4][2];
 

        // JTable detailTable = new JTable(data, colNames);
        // detailTable.setTableHeader(null);

   
        // JScrollPane detailScroll = new JScrollPane(detailTable);
  
        // panel.addGBLComponent(detailScroll, 3, 1,0.6,0.8,"BOTH");


        return panel;
    }

    private JPanel makeNCPanel(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        JLabel newLabel = new JLabel("New Case");
        panel.addGBLComponent(newLabel, 0, 0,4,1,0.0,0.0,"NONE",GridBagConstraints.LINE_START);
        
    
        JLabel tacticsLabel = new JLabel("Tactics");
        JTextField tacticsField = new JTextField();
        tacticsField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(tacticsLabel, 0, 1);
        panel.addGBLComponent(tacticsField, 1, 1);

        JLabel techniqueLabel = new JLabel("Techniques");
        JTextField techniqueField = new JTextField();
        techniqueField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(techniqueLabel, 0, 2);
        panel.addGBLComponent(techniqueField, 1, 2);

        JLabel softwareLabel = new JLabel("Software");
        JTextField softwareField = new JTextField();
        softwareField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(softwareLabel, 0, 3);
        panel.addGBLComponent(softwareField, 1, 3);

        
        JButton arrowButton = new JButton(">");
        panel.addGBLComponent(arrowButton, 1, 4,0.0,0.0,"NONE",GridBagConstraints.LINE_END);

        JLabel componentLabel = new JLabel("Attack Component");
        JTable componentTable = new JTable(new DefaultTableModel(new String[]{"Tactics","Techniques","Software"},0));
        JScrollPane compoTabSc= new JScrollPane(componentTable);
        
        panel.addGBLComponent(componentLabel, 2, 0);
        panel.addGBLComponent(compoTabSc, 2, 1,4,4);


        return panel;
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

    private Software makeSoftware(String value){
        Software software = new Software(value);
        
        ArrayList<String[]> platformList=ontologyFunc.LoadSWPlatform(value);
        String[] swPlatforms=new String[platformList.size()];

        for (int i=0;i<platformList.size();i++){
            swPlatforms[i]=platformList.get(i)[0];
        }

        ArrayList<String[]> techList=ontologyFunc.LoadSWTech(value);
        // String[] swTechs=new String[techList.size()];
        // for (int i=0;i<techList.size();i++){
        //     swTechs[i]=techList.get(i)[0];
        // }

        software.setPlatforms(swPlatforms);
        
        Technique[] techs= new Technique[techList.size()];
        for(int i=0;i<techList.size();i++){
            techs[i]=new Technique(techList.get(i)[0]);
        }

        software.setTechniques(techs);
        
        return software;
    }

    
}
