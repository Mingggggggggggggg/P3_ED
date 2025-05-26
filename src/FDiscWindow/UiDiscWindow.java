package FDiscWindow;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import Other.P3Style;

public class UiDiscWindow extends JPanel {
    ActionDiscWindow adw = ActionDiscWindow.getInstance();
    private JButton startButton = new JButton("Start");
    private JTextField pathField = new JTextField("Dateipfad hier");
    private JLabel dataMerkmal = new JLabel("MERKMAL HIER");
    private JLabel dataUrliste = new JLabel("Urliste: ");
    private JTable dataTable = new JTable();
    private JLabel dataAverage = new JLabel("Arithmetisches Mittel: ");
    private JLabel dataVariance = new JLabel("Empirische Standardabweichung: ");
    private JPanel dataDiagram = new JPanel();

    private GridBagConstraints rules = new GridBagConstraints();

    public UiDiscWindow() {
        startButton.setActionCommand("startDiscMaths");
        startButton.addActionListener(adw);
        startButton.setFont(P3Style.BUTTON_FONT);


        rules.gridx = 0;
        rules.gridy = 0;
        rules.weightx = 1;
        rules.insets = new Insets(5, 5, 5, 5);
        rules.fill = GridBagConstraints.FIRST_LINE_START;

        this.setLayout(new GridBagLayout());
        
        this.add(startButton, rules);

        rules.gridx = 1;
        rules.anchor = GridBagConstraints.NORTHWEST;
        rules.fill = GridBagConstraints.HORIZONTAL;
        this.add(dataMerkmal, rules);

        rules.gridx = 0;
        rules.weighty = 0;
        rules.gridy = 1;
        //rules.fill = GridBagConstraints.NONE;
        this.add(pathField, rules);

        rules.gridy = 2;
        this.add(dataUrliste, rules);

        rules.gridy = 3;
        this.add(dataAverage, rules);

        rules.gridy = 4;
        this.add(dataVariance, rules);

        rules.gridy = 5;
        this.add(dataTable, rules);

        rules.gridy = 10;
        rules.weighty = 1;
        dataDiagram.setBackground(Color.GREEN);
        //rules.gridheight = GridBagConstraints.REMAINDER;
        rules.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dataDiagram, rules);
    }


}
