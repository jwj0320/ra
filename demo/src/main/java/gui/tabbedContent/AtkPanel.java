package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;

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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

public class AtkPanel extends GridBagPanel {
    public AtkPanel(JTabbedPane tabbedPane){
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

        JLabel detailLabel = new JLabel();
        detailLabel.setText("Group Details");
        panel.addGBLComponent(detailLabel, 1, 0,0.8,0.1,"NONE",GridBagConstraints.LINE_START);

        String[][] nameList = new String[50][1];
        for (int i=0;i<nameList.length;i++){
            nameList[i][0]="Group "+i;
        }

        String[] nameHeader = {"Group Name"};
        JTable nameTable = new JTable(nameList,nameHeader);
        // nameTable.setTableHeader(null);

        JScrollPane nameTableScPane=new JScrollPane(nameTable);
        
        nameTableScPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(nameTableScPane, 0, 1,0.1,1.0,"BOTH");

        JTextArea detailArea = new JTextArea();
        detailArea.setText("Details.");
        detailArea.setEditable(false);
        
        JScrollPane detailArScPane = new JScrollPane(detailArea);
        detailArScPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(detailArScPane, 1, 1,0.8,1.0,"BOTH");

        return panel;
    }

    private JPanel makeTechTab(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Techniques");
        panel.addGBLComponent(nameLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        JLabel detailLabel = new JLabel();
        detailLabel.setText("Techniques for Risk Assessment");
        panel.addGBLComponent(detailLabel, 2, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        
        String[][] techList = new String[50][1];
        for (int i=0;i<techList.length;i++){
            techList[i][0]="tech "+i;
        }

        String[] techHeader = {"Techniues"};
        JTable techTable = new JTable(techList,techHeader);
        
        JScrollPane techTableSCPane= new JScrollPane(techTable);
        techTableSCPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(techTableSCPane, 0, 1, 0.6,0.8,"BOTH");

        JButton selectButton = new JButton(">");
        panel.addGBLComponent(selectButton, 1, 1, 0.1,0.8);

        String[][] selectedList = new String[0][1];

        JTable selectedTable = new JTable(selectedList,techHeader);

        JScrollPane selectedScrollPane = new JScrollPane(selectedTable);
        selectedScrollPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(selectedScrollPane, 2,1, 0.6,0.8,"BOTH");


        return panel;
    }

    private JPanel makeSoftTab(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Software");
        panel.addGBLComponent(nameLabel, 0, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        JLabel detailLabel = new JLabel();
        detailLabel.setText("Software for Risk Assessment");
        panel.addGBLComponent(detailLabel, 2, 0,0.1,0.1,"NONE",GridBagConstraints.LINE_START);

        
        String[][] softList = new String[50][1];
        for (int i=0;i<softList.length;i++){
            softList[i][0]="soft "+i;
        }

        String[] softHeader = {"Software"};
        JTable softTable = new JTable(softList,softHeader);
        
        JScrollPane softTableSCPane= new JScrollPane(softTable);
        softTableSCPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(softTableSCPane, 0, 1, 0.6,0.8,"BOTH");

        JButton selectButton = new JButton(">");
        panel.addGBLComponent(selectButton, 1, 1, 0.1,0.8);

        String[][] selectedList = new String[0][1];

        JTable selectedTable = new JTable(selectedList,softHeader);

        JScrollPane selectedScrollPane = new JScrollPane(selectedTable);
        selectedScrollPane.setPreferredSize(new Dimension(10,10));

        panel.addGBLComponent(selectedScrollPane, 2,1, 0.6,0.8,"BOTH");


        return panel;
    }

    private JPanel makeNCPanel(JTabbedPane innerTPane){
        GridBagPanel panel = new GridBagPanel(innerTPane);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        JLabel newLabel = new JLabel("New Case");
        panel.addGBLComponent(newLabel, 0, 0,4,1,0.0,0.0,"NONE",GridBagConstraints.LINE_START);
        
        JLabel typeLabel = new JLabel("Type");
        JButton typeButton = new JButton(">");
        JTextField typeField = new JTextField();
        typeField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(typeLabel, 0, 1);
        panel.addGBLComponent(typeField, 1, 1);
        panel.addGBLComponent(typeButton, 2, 1);
        

        JLabel objectiveLabel = new JLabel("Objective");
        JTextField objectiveField = new JTextField();
        JButton objectiveButton = new JButton(">");
        objectiveField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(objectiveLabel, 0, 2);
        panel.addGBLComponent(objectiveField, 1, 2);
        panel.addGBLComponent(objectiveButton, 2, 2);

        JLabel targetLabel = new JLabel("Target");
        JTextField targetField = new JTextField();
        JButton targetButton = new JButton(">");
        targetField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(targetLabel, 0, 3);
        panel.addGBLComponent(targetField, 1, 3);
        panel.addGBLComponent(targetButton, 2, 3);

        JLabel tacticsLabel = new JLabel("Tactics");
        JTextField tacticsField = new JTextField();
        JButton tacticsButton = new JButton(">");
        tacticsField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(tacticsLabel, 0, 4);
        panel.addGBLComponent(tacticsField, 1, 4);
        panel.addGBLComponent(tacticsButton, 2, 4);

        JLabel techniqueLabel = new JLabel("Techniques");
        JTextField techniqueField = new JTextField();
        JButton techniqueButton = new JButton(">");
        techniqueField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(techniqueLabel, 0, 5);
        panel.addGBLComponent(techniqueField, 1, 5);
        panel.addGBLComponent(techniqueButton, 2, 5);

        JLabel softwareLabel = new JLabel("Software");
        JTextField softwareField = new JTextField();
        JButton softwareButton = new JButton(">");
        softwareField.setPreferredSize(new Dimension(200,28));
        panel.addGBLComponent(softwareLabel, 0, 6);
        panel.addGBLComponent(softwareField, 1, 6);
        panel.addGBLComponent(softwareButton, 2, 6);

        JTextArea selectArea = new JTextArea();
        panel.addGBLComponent(selectArea, 3, 1,1,7,0.1,0.1,"BOTH");

        return panel;
    }
}
