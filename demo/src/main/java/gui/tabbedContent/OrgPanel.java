package gui.tabbedContent;

import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrgPanel extends JPanel{
    public OrgPanel(){
        JPanel mainPanel = this;
        mainPanel.setLayout(new GridLayout(4,1));

        JLabel infoLabel = new JLabel();
        infoLabel.setText("Select an organizaion to assess security risks for an attack.");

        mainPanel.add(infoLabel);

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new GridLayout(1,4));
        
        JLabel orgLabel = new JLabel();
        orgLabel.setText("Organizaion");
        selectPanel.add(orgLabel);
        JComboBox<Object> orgComboBox = new JComboBox<>(); //Object는 추후에 수정
        selectPanel.add(orgComboBox);
        JButton selectButton = new JButton("Select");
        selectPanel.add(selectButton);
        JButton createButton = new JButton("Create");
        selectPanel.add(createButton);


        mainPanel.add(selectPanel);
        
        


        mainPanel.add(new JLabel("hello"));
        mainPanel.add(new JLabel("hello"));

    }
}
