package gui;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import gui.tabbedContent.AssessPanel;
import gui.tabbedContent.AtkPanel;
import gui.tabbedContent.OrgPanel;
import gui.tabbedContent.RiskPanel;
import gui.tabbedContent.SecReqPanel;
import gui.tabbedContent.type.Group;
import gui.tabbedContent.type.Software;
import gui.tabbedContent.type.TabbedPaneInfo;
import gui.tabbedContent.type.Technique;



public class MainFrame extends JFrame{

    Container contentPane;
    public MainFrame(){
        super("Threat-driven Risk Assessment");
        File imageFile = new File(this.getClass().getResource("").getPath(),"../../../icon.png");
        try {
            setIconImage(ImageIO.read(imageFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = this.getContentPane();
        TabbedPaneInfo tPane = new TabbedPaneInfo();
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
        
        AssessPanel assessPanel = new AssessPanel(tPane);
        tPane.addTab("Risk Assessment", assessPanel);

        // orgPanel.disableOtherTabs();

        setVisible(true);
    }

}

