package FContWindow;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import LogicMath.contData.DrawHistogram;
import LogicMath.contData.Histogram;

public class ActionContWindow implements ActionListener {
    private static ActionContWindow instance = null;
    String path = "";

    public void setPath(String path) {
        this.path = path;
    }

    public static ActionContWindow getInstance() {
        if (instance == null) {
            instance = new ActionContWindow();
        }
        return instance;
    }

    private ActionContWindow() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "startContMaths":
                try {
                    // Überprüfe, ob Datei ausgewählt wurde
                    if (path.isEmpty() || path == null) {
                        System.err.println("Pfad ist leer");
                        return;
                    }

                    UiContWindow instance = UiContWindow.getInstance();

                    // Setze ausgelesene Daten in JLabel rawDataUrliste ein
                    double[] data = LogicMath.contData.ContDataReader.getContData(path);
                    // Berechne und setze arithmetisches Mittel ein
                    double avg = LogicMath.DataBasicMath.getAverage(data);
                    // Berechne und setze empirische Standardabweichung ein
                    double var = LogicMath.DataBasicMath.getVariance(data);
                    // Ermittle Klasseneinteilung aus Datei und gebe dieses als Klassennamen in die Tabelle ein
                    String[] classInterval = LogicMath.contData.ContDataReader.getContClasses(path);
                    Object[][] freqTable = LogicMath.contData.ContDataReader.dataClassification(data, path);
                    // Transponiere Matrix, damit diese korrekt in der JTable angezeigt werden
                    Object[][] transFreqTable = new Object[1][freqTable.length];
                    for (int i = 0; i < freqTable.length; i++) {
                        transFreqTable[0][i] = freqTable[i][0];
                        // System.out.println(transFreqTable[0][i]);
                    }

                    double[][] absFreqDouble = LogicMath.contData.ContDataReader.dataClassificationDouble(data, path);
                    int panelHeight = instance.getDataDiagram().getHeight();
                    int panelWidth = instance.getDataDiagram().getWidth();
                    Histogram[] histograms = LogicMath.contData.Histogram.histogramDimensions(absFreqDouble, panelHeight, panelWidth);

                    DrawHistogram drawHistogram = new DrawHistogram(histograms, panelWidth, panelHeight);
                    drawHistogram.setPreferredSize(new Dimension(panelWidth, panelHeight));


                    instance.setRawDataUrliste(Arrays.toString(data));
                    instance.getRawDataUrliste().setVisible(true);
                    // System.out.println(Arrays.toString(data));
                    instance.setDataAverage(avg);
                    instance.setDataVariance(var);
                    instance.setColumnNames(classInterval);
                    instance.setData(transFreqTable);
                    instance.updateTable();
                    instance.setDataDiagram(drawHistogram);
                    instance.repaint();

                    break;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case "openFile":
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                int response = fileChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    setPath(file.toString());
                    // System.out.println(file);
                    UiContWindow.getInstance().setPathField(file.toString());
                    try {
                        UiContWindow.getInstance()
                                .setDataMerkmal(LogicMath.DataCharacteristics.getDataName(file.toString()));
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

                break;
            default:
                throw new UnsupportedOperationException("Unbekannte Eingabe 'actionPerformed' in ActionContWindow");
        }

    }
}
