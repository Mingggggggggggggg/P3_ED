package FContWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import Other.P3Style;

public class UiContWindow extends JPanel {
    private static UiContWindow instance;

    public static UiContWindow getInstance() {
        if (instance == null) {
            instance = new UiContWindow();
        }
        return instance;
    }
    ActionContWindow acw = ActionContWindow.getInstance();
    String[] columnNames = {
        "1", "2", "3", "4", "5", "6"
    };

    Object[][] data = {
        {2, 5, 2, 1, 1, 4, 3, 6, 1, 3}
    };


    private JButton startButton = new JButton("Start");
    private JLabel pathField = new JLabel("Datei auswählen");
    public void setPathField(String path) {
        this.pathField.setText(path);
    }

    private JButton openDialog = new JButton("Select file");
    private JLabel dataMerkmal = new JLabel("MERKMAL HIER");
    private JLabel dataUrliste = new JLabel("Urliste: ");
    private JLabel tableLabel = new JLabel("Klassentabelle:");
    private JTable dataTable = new JTable(data, columnNames);
    private JScrollPane dataScrollPane = new JScrollPane(dataTable);
    private JLabel dataAverage = new JLabel("Arithmetisches Mittel: ");
    private JLabel dataVariance = new JLabel("Empirische Standardabweichung: ");
    private JPanel dataDiagram = new JPanel();

    private GridBagConstraints rules = new GridBagConstraints();

    private UiContWindow() {
        startButton.setActionCommand("startContMaths");
        startButton.addActionListener(acw);
        startButton.setFont(P3Style.BUTTON_FONT);

        openDialog.setActionCommand("openFile");
        openDialog.addActionListener(acw);


        rules.gridx = 0;
        rules.gridy = 0;
        //rules.weightx = 1;
        rules.insets = new Insets(5, 5, 5, 5);
        rules.anchor = GridBagConstraints.FIRST_LINE_START;

        this.setLayout(new GridBagLayout());
        
        this.add(startButton, rules);

    
        rules.gridx = 1;
        rules.anchor = GridBagConstraints.NORTHWEST;
        rules.fill = GridBagConstraints.HORIZONTAL;
        this.add(dataMerkmal, rules);

        rules.gridx = 0;
        rules.weighty = 0;
        rules.gridy = 1;
        rules.fill = GridBagConstraints.NONE;
        //this.add(pathField, rules);
        this.add(openDialog, rules);

        rules.gridx = 1;
        rules.weightx = 1;
        rules.fill = GridBagConstraints.HORIZONTAL;
        this.add(pathField, rules);

        rules.gridx = 0;
        rules.gridy = 2;
        rules.weightx = 0;
        rules.fill = GridBagConstraints.NONE;
        this.add(dataUrliste, rules);

        rules.gridy = 3;
        this.add(dataAverage, rules);

        rules.gridy = 4;
        rules.weighty = 0.1;
        this.add(dataVariance, rules);

        rules.gridy = 6;
        rules.weighty = 0;
        this.add(tableLabel, rules);

        rules.gridy = 7;
        rules.weightx = 1;
        rules.fill = GridBagConstraints.NONE;
        dataScrollPane.setPreferredSize(new Dimension(600, 50));
        this.add(dataScrollPane, rules);
        

        rules.gridy = 8;
        rules.weighty = 1;
        dataDiagram.setBackground(Color.GREEN);
        rules.fill = GridBagConstraints.BOTH;
        //rules.gridheight = GridBagConstraints.REMAINDER;
        rules.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dataDiagram, rules);
    }


}
