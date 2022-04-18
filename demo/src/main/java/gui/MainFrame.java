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

import gui.tabbedContent.OrgPanel;



public class MainFrame extends JFrame{

    Container contentPane;
    public MainFrame(){
        super("title");

        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = this.getContentPane();
        JTabbedPane tPane = new JTabbedPane();
        tPane.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
        add(tPane);

        OrgPanel orgPanel = new OrgPanel();

        tPane.addTab("Organizaion", orgPanel);

        
        
        // JLabel schedulerLabel = new JLabel("두번째", SwingConstants.CENTER);
        // JPanel schedulerPanel = new JPanel();
        // schedulerPanel.add(schedulerLabel);
        // tPane.addTab("Attack Component", schedulerPanel);
        
        
        // JLabel reportLabel = new JLabel("세번째", SwingConstants.CENTER);
        // JPanel reportPanel = new JPanel();
        // reportPanel.add(reportLabel);
        // tPane.addTab("Risk Component", reportPanel);
        
        
        // JLabel diaryLabel = new JLabel("네번째", SwingConstants.CENTER);
        // JPanel diaryPanel = new JPanel();
        // diaryPanel.add(diaryLabel);
        // tPane.addTab("Security Requirements", diaryPanel);
        
        
        // JLabel diaLabel = new JLabel("다섯번째", SwingConstants.CENTER);
        // JPanel diaPanel = new JPanel();
        // diaPanel.add(diaLabel);
        // tPane.addTab("Risk Assessment", diaPanel);
        
        tPane.setEnabledAt(0, false);
        
        setVisible(true);
    }

}
