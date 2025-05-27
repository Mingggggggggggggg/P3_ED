package FContWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Other.P3Style;

public class UiContWindow extends JPanel {
    
    ActionContWindow acw = ActionContWindow.getInstance();

    String[] columnNames = {
        "1", "2", "3", "4", "5", "6"
    };

    Object[][] data = {
        {2, 5, 2, 1, 1, 4, 3, 6, 1, 3}
    };

    private JButton startButton = new JButton("Start");
    private JTextField pathField = new JTextField("Dateipfad hier");
    private JLabel dataMerkmal = new JLabel("MERKMAL HIER");
    private JLabel dataUrliste = new JLabel("Urliste: ");
    private JLabel tableLabel = new JLabel("Häufigkeitstabelle");
    private JTable dataTable = new JTable(data, columnNames);
    private JScrollPane dataScrollPane = new JScrollPane(dataTable);
    private JLabel dataAverage = new JLabel("Arithmetisches Mittel: ");
    private JLabel dataVariance = new JLabel("Empirische Standardabweichung: ");
    private JPanel dataDiagram = new JPanel();

    private GridBagConstraints rules = new GridBagConstraints();

    public UiContWindow() {
        startButton.setActionCommand("startContMaths");
        startButton.addActionListener(acw);
        startButton.setFont(P3Style.BUTTON_FONT);


        rules.gridx = 0;
        rules.gridy = 0;
        rules.weightx = 1;
        rules.insets = new Insets(5, 5, 5, 5);
        //rules.fill = GridBagConstraints.FIRST_LINE_START;

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
