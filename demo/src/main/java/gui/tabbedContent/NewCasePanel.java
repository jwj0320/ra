package gui.tabbedContent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class NewCasePanel extends GridBagPanel{

    public NewCasePanel(JTabbedPane tabbedPane){
        super(tabbedPane);

        JLabel newLabel = new JLabel("New Case");
        addGBLComponent(newLabel, 0, 0,3,1);
        
        JLabel typeLabel = new JLabel("Type");
        JTextField typeField = new JTextField();
        JButton typeButton = new JButton(">");
        addGBLComponent(typeLabel, 0, 1);
        addGBLComponent(typeField, 1, 1);
        addGBLComponent(typeButton, 2, 1);
        

        JLabel objectiveLabel = new JLabel("Objective");
        JTextField objectiveField = new JTextField();
        JButton objectiveButton = new JButton(">");

        JLabel targetLabel = new JLabel("Target");
        JTextField targetField = new JTextField();
        JButton targetButton = new JButton(">");

        JLabel tacticsLabel = new JLabel("Tactics");
        JTextField tacticsField = new JTextField();
        JButton tacticsButton = new JButton(">");

        JLabel techniqueLabel = new JLabel("Techniques");
        JTextField techniqueField = new JTextField();
        JButton techniqueButton = new JButton(">");

        JLabel softwareLabel = new JLabel("Software");
        JTextField softwareField = new JTextField();
        JButton softwareButton = new JButton(">");
    }
}
