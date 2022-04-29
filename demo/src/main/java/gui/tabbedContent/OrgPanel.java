package gui.tabbedContent;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

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

import io.github.qualtagh.swing.table.model.IModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelData;
import io.github.qualtagh.swing.table.model.ModelField;
import io.github.qualtagh.swing.table.model.ModelFieldGroup;
import io.github.qualtagh.swing.table.model.ModelRow;
import io.github.qualtagh.swing.table.view.JBroTable;

public class OrgPanel extends JPanel{
    JTabbedPane tabbedPane;

    public OrgPanel(JTabbedPane tabbedPane){
        this.tabbedPane = tabbedPane;
        JPanel panel = this;
        panel.setLayout(new GridBagLayout());

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel infoLabel = new JLabel();
        infoLabel.setText("Select an organizaion to assess security risks for an attack.");

        addGBLComponent(infoLabel, 0, 0, 5,1,0.0,0.1);
        // panel.add(infoLabel);

        
        JLabel orgLabel = new JLabel();
        orgLabel.setText("Organizaion");
        addGBLComponent(orgLabel, 1, 1,0.01,0.1);
        // panel.add(orgLabel);
        JComboBox<Object> orgComboBox = new JComboBox<>(); //Object는 추후에 수정
        orgComboBox.addItem("Sample Company");
        orgComboBox.setPreferredSize(new Dimension(250,22));
        addGBLComponent(orgComboBox, 2, 1,0.0,0.1);
        // panel.add(orgComboBox);
        
        JButton selectButton = new JButton("Select");
        addGBLComponent(selectButton, 4, 1,0.005,0.1);
        // panel.add(selectButton);
        JButton createButton = new JButton("Create");
        addGBLComponent(createButton, 5, 1,0.005,0.1);
        // panel.add(createButton);


        // String header[] = {
        //     "Business Process", "Role", "Person", "Software", "Data", "Platform", "Hardware", "Physical & Environment"
        // };
        
        String header[] = {
            "Role", "Person"
        };

        // String contents[][]={{"hello","world"}};
        // JTable table = new JTable(contents,header);
        // JScrollPane tbScrollPane = new JScrollPane(table);
        // addGBLComponent(tbScrollPane, 0, 2,7,1, 0.0,0.4, "BOTH");


        IModelFieldGroup groups[] = new IModelFieldGroup[] {
            new ModelField("Business Process","Business Process"),
            new ModelFieldGroup( "Human", "Human" )
              .withChild( new ModelField( "Role", "Role" ) )
              .withChild( new ModelField( "Person", "Person" ).withRowspan( 2 ) ), // Custom rowspan set.
            new ModelFieldGroup( "Information Technology", "Information Technology" )
              .withChild( new ModelField( "Software", "Software" ) )
              .withChild( new ModelField( "Data", "Data" ) )
              .withChild( new ModelField( "Platform", "Platform" ) )
              .withChild( new ModelField( "Hardware", "Hardware" ) ),
            new ModelField( "Physical & Environment", "Physical & Environment" )
          };
      
          // Get leafs of columns tree.
          ModelField fields[] = ModelFieldGroup.getBottomFields( groups );
          
          // Sample data.
          ModelRow rows[] = new ModelRow[ 30 ];
          for ( int i = 0; i < rows.length; i++ ) {
            rows[ i ] = new ModelRow( fields.length );
            for ( int j = 0; j < fields.length; j++ )
              rows[ i ].setValue( j, fields[ j ].getCaption() + i );
          }
          
          // Table.
          ModelData data = new ModelData( groups );
          data.setRows( rows );
          JBroTable table = new JBroTable( data );
          
          addGBLComponent(table.getScrollPane(), 0, 2,7,1, 0.0,0.4, "BOTH");

        JButton nextButton = new JButton("Next");
        addGBLComponent(nextButton, 6, 3,0.5,0.1,"NONE","LINE_END");

    }

    private void addGBLComponent(JComponent component, int x, int y){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(component,gbc);
        return;
    }


    private void addGBLComponent(JComponent component, int x, int y, int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        this.add(component,gbc);
        return;
    }

    private void addGBLComponent(JComponent component, int x, int y, double weightx, double weighty){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        this.add(component,gbc);
        return;
    }

    private void addGBLComponent(JComponent component, int x, int y, double weightx, double weighty, String option){
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

        this.add(component,gbc);
        return;
    }

    private void addGBLComponent(JComponent component, int x, int y, double weightx, double weighty, String option, String anchor){
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

        // switch (anchor) {
        //     case "":
                
        //         break;
        
        //     default:
        //         break;
        // }
        gbc.anchor=GridBagConstraints.LINE_END;

        this.add(component,gbc);
        return;
    }

    private void addGBLComponent(JComponent component, int x, int y, int width, int height, double weightx, double weighty){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        this.add(component,gbc);
        return;
    }
    
    

    private void addGBLComponent(JComponent component, int x, int y, int width, int height, String option){
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

        this.add(component,gbc);
        return;
    }

    private void addGBLComponent(JComponent component, int x, int y, int width, int height, double weightx, double weighty, String option){
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

        this.add(component,gbc);
        return;
    }

    public void disableOtherTabs(){
        int index = tabbedPane.getSelectedIndex();
        int count = tabbedPane.getTabCount();
        for (int i = 0;i<count;i++){
            if (i!=index){
                tabbedPane.setEnabledAt(i, false);
            }
        }
    }
}
