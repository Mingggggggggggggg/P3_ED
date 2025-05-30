package FDiscWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import Other.P3Style;

public class UiDiscWindow extends JPanel {
    private static UiDiscWindow instance;

    public static UiDiscWindow getInstance() {
        if (instance == null) {
            instance = new UiDiscWindow();
        }
        return instance;
    }
    ActionDiscWindow adw = ActionDiscWindow.getInstance();

    // -------------------------------------------- Tabelle --------------------------------------------
    String[] columnNames = {
    };
 
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
    Object[][] data = {
        {}
    };
    public void setData(Object[][] data) {
        this.data = data;
    }
    // --------------------------------------------- /Tabelle ---------------------------------------------


    private JButton startButton = new JButton("Start");
    private JLabel pathField = new JLabel("Datei auswählen");
    public String getPathField() {
        return pathField.getText();
    }

    public void setPathField(String path) {
        this.pathField.setText(path);
    }

    private JButton openDialog = new JButton("Select file");
    private JLabel dataMerkmal = new JLabel("");
    public void setDataMerkmal(String merkmal) {
        this.dataMerkmal.setText(merkmal);
    }
    private JLabel dataUrliste = new JLabel("Urliste: ");
    private JTextArea rawDataUrliste = new JTextArea();
    public JTextArea getRawDataUrliste() {
        return rawDataUrliste;
    }

    public void setRawDataUrliste(String data) {
        this.rawDataUrliste.setText(data);
    }
    private JLabel tableLabel = new JLabel("Häufigkeitstabelle");
    private JTable dataTable = new JTable(data, columnNames);
    private JScrollPane dataScrollPane = new JScrollPane(dataTable);
    public void updateTable() {
        this.dataTable = new JTable(data, columnNames);
        this.dataScrollPane.setViewportView(dataTable);
    }
    private JLabel dataAverage = new JLabel("Arithmetisches Mittel: ");
    public void setDataAverage(double dataAverage) {
        this.dataAverage.setText("Arithmetisches Mittel: " + dataAverage);
    }

    private JLabel dataVariance = new JLabel("Empirische Standardabweichung: ");
    public void setDataVariance(double dataVariance) {
        this.dataVariance .setText("Empirische Standardabweichung: " + dataVariance);
    }
    private JPanel dataDiagram = new JPanel();

    public JPanel getDataDiagram() {
        return dataDiagram;
    }

    public void setDataDiagram(JPanel dataDiagram) {
        this.dataDiagram = dataDiagram;
    }
    private GridBagConstraints rules = new GridBagConstraints();

    private UiDiscWindow() {
        startButton.setActionCommand("startDiscMaths");
        startButton.addActionListener(adw);
        startButton.setFont(P3Style.BUTTON_FONT);

        openDialog.setActionCommand("openFile");
        openDialog.addActionListener(adw);

        dataMerkmal.setFont(P3Style.TITLE_FONT);

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
        rawDataUrliste.setVisible(false);
        rawDataUrliste.setLineWrap(true);
        rawDataUrliste.setEditable(false);
        rules.fill = GridBagConstraints.HORIZONTAL;
        this.add(rawDataUrliste, rules);

        rules.gridy = 4;
        rules.fill = GridBagConstraints.NONE;
        this.add(dataAverage, rules);

        rules.gridy = 5;
        //rules.weighty = 0.1;
        this.add(dataVariance, rules);

        rules.gridy = 7;
        rules.weighty = 0;
        this.add(tableLabel, rules);

        rules.gridy = 8;
        rules.weightx = 1;
        rules.fill = GridBagConstraints.NONE;
        dataScrollPane.setPreferredSize(new Dimension(600, 50));
        this.add(dataScrollPane, rules);
        

        rules.gridy = 9;
        rules.weighty = 1;
        dataDiagram.setBackground(Color.GREEN);
        rules.fill = GridBagConstraints.BOTH;
        //rules.gridheight = GridBagConstraints.REMAINDER;
        rules.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dataDiagram, rules);
    }


}
