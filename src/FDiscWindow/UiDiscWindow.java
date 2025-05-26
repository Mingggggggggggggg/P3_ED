package FDiscWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import Other.P3Style;

public class UiDiscWindow extends JPanel {
    ActionDiscWindow adw = ActionDiscWindow.getInstance();

    private JButton startButton = new JButton("Start");
    private JTextField pathField = new JTextField("Dateipfad hier");
    private JLabel dataMerkmal = new JLabel();
    private JLabel dataUrliste = new JLabel();
    private JTable dataTable = new JTable();
    private JLabel dataAverage = new JLabel();
    private JLabel dataVariance = new JLabel();
    private JPanel dataDiagram = new JPanel();

    private GridBagConstraints rules = new GridBagConstraints();

    public UiDiscWindow() {
        startButton.setActionCommand("1");
        startButton.addActionListener(adw);
        startButton.setFont(P3Style.BUTTON_FONT);


        rules.gridx = 0;
        rules.gridy = 0;
        rules.weightx = 1;
        rules.insets = new Insets(5, 5, 5, 5);
        rules.fill = GridBagConstraints.FIRST_LINE_START;

        this.setLayout(new GridBagLayout());
        
        this.add(startButton, rules);

        rules.gridy = 1;
        this.add(pathField, rules);

        rules.gridy = 2;
        this.add(dataUrliste, rules);
    }


}
