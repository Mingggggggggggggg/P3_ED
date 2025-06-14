﻿package FDiscWindow;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import LogicMath.discData.Bar;
import LogicMath.discData.DrawBarDiagram;

public class ActionDiscWindow implements ActionListener {
    private static ActionDiscWindow instance = null;
    String path = "";

    public void setPath(String path) {
        this.path = path;
    }

    public static ActionDiscWindow getInstance() {
        if (instance == null) {
            instance = new ActionDiscWindow();
        }
        return instance;
    }

    private ActionDiscWindow() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "startDiscMaths":
                try {
                    // Überprüfe, ob Datei ausgewählt wurde
                    if (path.isEmpty() || path == null) {
                        System.err.println("Pfad ist leer");
                        return;
                    }

                    UiDiscWindow instance = UiDiscWindow.getInstance();

                    // Setze ausgelesene Daten in JLabel rawDataUrliste ein
                    // set Methode ist hier, weil data später noch sortiert wird.
                    double[] data = LogicMath.discData.DiscDataReader.getDiscData(path);
                    instance.setRawDataUrliste(Arrays.toString(data));
                    instance.getRawDataUrliste().setVisible(true);

                    // Berechne und setze arithmetisches Mittel ein
                    double avg = LogicMath.DataBasicMath.getAverage(data);

                    // Berechne und setze empirische Standardabweichung ein
                    double var = LogicMath.DataBasicMath.getVariance(data);

                    // Extrahiere und setze Merkmalsausprägung für die Tabelle ein
                    String[] charExp = LogicMath.discData.DiscDataReader.getCharExpString(data);
                    double[] charExpDouble = LogicMath.discData.DiscDataReader.getCharExp(data);
                    Object[][] freqTable = LogicMath.discData.DiscDataReader.getAbsFreq(charExpDouble, data);
                    
                    // Transponiere Matrix, damit diese korrekt in der JTable angezeigt werden
                    Object[][] transFreqTable = new Object[1][freqTable.length];
                    for (int i = 0; i < freqTable.length; i++) {
                        transFreqTable[0][i] = freqTable[i][1];
                    }
                    double[][] absFreqDouble = LogicMath.discData.DiscDataReader.getAbsFreqDouble(charExpDouble, data);
                    int panelHeight = instance.getDataDiagram().getHeight();
                    int panelWidth = instance.getDataDiagram().getWidth();
                    Bar[] bars = LogicMath.discData.Bar.barDimensions(absFreqDouble, panelHeight, panelWidth);

                    DrawBarDiagram diagramPanel = new DrawBarDiagram(bars, panelWidth, panelHeight);
                    diagramPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));

                    // System.out.println(Arrays.toString(data));

                    instance.setDataAverage(avg);
                    instance.setDataVariance(var);
                    instance.setColumnNames(charExp);
                    // System.out.println(Arrays.toString(charExp));
                    instance.setData(transFreqTable);
                    instance.updateTable();
                    instance.setDataDiagram(diagramPanel);
                    instance.repaint();

                    break;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                break;
            case "openFile":
                // Angelehnt und teilweise übernommen aus https://youtu.be/A6sA9KItwpY?si=7aRrMU3ojHs9loe-&t=301
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                int response = fileChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    setPath(file.toString());
                    // System.out.println(file);
                    UiDiscWindow.getInstance().setPathField(file.toString());
                    try {
                        UiDiscWindow.getInstance()
                                .setDataMerkmal(LogicMath.DataCharacteristics.getDataName(file.toString()));
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

                break;
            default:
                throw new UnsupportedOperationException("Unbekannte Eingabe 'actionPerformed' in ActionDiscWindow");
        }

    }
}
