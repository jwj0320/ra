package gui;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import gui.tabbedContent.AtkPanel;
import gui.tabbedContent.OrgPanel;
import gui.tabbedContent.RiskPanel;
import gui.tabbedContent.SecReqPanel;



public class MainFrame extends JFrame{

    Container contentPane;
    public MainFrame(){
        super("");

        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = this.getContentPane();
        JTabbedPane tPane = new JTabbedPane();
        tPane.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
        add(tPane);

        OrgPanel orgPanel = new OrgPanel(tPane);
        tPane.addTab("Organizaion", orgPanel);

        AtkPanel atkPanel = new AtkPanel(tPane);
        tPane.addTab("Attack Component", atkPanel);

        RiskPanel riskPanel = new RiskPanel(tPane);
        tPane.addTab("Risk Component", riskPanel);

        SecReqPanel secReqPanel = new SecReqPanel(tPane);
        tPane.addTab("Security Requirements", secReqPanel);
        
  
        

        
        
        JLabel diaLabel = new JLabel("다섯번째", SwingConstants.CENTER);
        JPanel diaPanel = new JPanel();
        diaPanel.add(diaLabel);
        tPane.addTab("Risk Assessment", diaPanel);

        // orgPanel.disableOtherTabs();
        
        
        setVisible(true);
    }

}
