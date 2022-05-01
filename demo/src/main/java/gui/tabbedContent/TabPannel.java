package gui.tabbedContent;

import java.awt.GridBagConstraints;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public abstract class TabPannel extends JPanel {

    protected JTabbedPane tabbedPane;

    public TabPannel(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    protected void addGBLComponent(JComponent component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, int width, int height) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, double weightx, double weighty, String option) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        switch (option) {
            case "NONE":
                gbc.fill = GridBagConstraints.NONE;
                break;
            case "HORIZONTAL":
                gbc.fill = GridBagConstraints.HORIZONTAL;
                break;
            case "VERTICAL":
                gbc.fill = GridBagConstraints.VERTICAL;
                break;
            case "BOTH":
                gbc.fill = GridBagConstraints.BOTH;
                break;
            default:
                System.err.println("Warning: Unidentified Option");
                break;
        }

        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, double weightx, double weighty, String option,
            int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        switch (option) {
            case "NONE":
                gbc.fill = GridBagConstraints.NONE;
                break;
            case "HORIZONTAL":
                gbc.fill = GridBagConstraints.HORIZONTAL;
                break;
            case "VERTICAL":
                gbc.fill = GridBagConstraints.VERTICAL;
                break;
            case "BOTH":
                gbc.fill = GridBagConstraints.BOTH;
                break;
            default:
                System.err.println("Warning: Unidentified Option");
                break;
        }

        gbc.anchor = anchor;

        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, int width, int height, double weightx,
            double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, int width, int height, String option) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;

        switch (option) {
            case "NONE":
                gbc.fill = GridBagConstraints.NONE;
                break;
            case "HORIZONTAL":
                gbc.fill = GridBagConstraints.HORIZONTAL;
                break;
            case "VERTICAL":
                gbc.fill = GridBagConstraints.VERTICAL;
                break;
            case "BOTH":
                gbc.fill = GridBagConstraints.BOTH;
                break;
            default:
                System.err.println("Warning: Unidentified Option");
                break;
        }

        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, int width, int height, double weightx,
            double weighty, String option) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        switch (option) {
            case "NONE":
                gbc.fill = GridBagConstraints.NONE;
                break;
            case "HORIZONTAL":
                gbc.fill = GridBagConstraints.HORIZONTAL;
                break;
            case "VERTICAL":
                gbc.fill = GridBagConstraints.VERTICAL;
                break;
            case "BOTH":
                gbc.fill = GridBagConstraints.BOTH;
                break;
            default:
                System.err.println("Warning: Unidentified Option");
                break;
        }

        this.add(component, gbc);
        return;
    }

    protected void addGBLComponent(JComponent component, int x, int y, int width, int height, double weightx,
            double weighty, String option, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        switch (option) {
            case "NONE":
                gbc.fill = GridBagConstraints.NONE;
                break;
            case "HORIZONTAL":
                gbc.fill = GridBagConstraints.HORIZONTAL;
                break;
            case "VERTICAL":
                gbc.fill = GridBagConstraints.VERTICAL;
                break;
            case "BOTH":
                gbc.fill = GridBagConstraints.BOTH;
                break;
            default:
                System.err.println("Warning: Unidentified Option");
                break;
        }
        gbc.anchor = anchor;

        this.add(component, gbc);
        return;
    }

    public void disableOtherTabs() {
        int index = tabbedPane.getSelectedIndex();
        int count = tabbedPane.getTabCount();
        for (int i = 0; i < count; i++) {
            if (i != index) {
                tabbedPane.setEnabledAt(i, false);
            }
        }
    }

}
