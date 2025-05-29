package FContWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;


public class ActionContWindow implements ActionListener{
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
                    instance.setRawDataUrliste(Arrays.toString(data));
                    instance.getRawDataUrliste().setVisible(true);
                    //System.out.println(Arrays.toString(data));

                    // Berechne und setze arithmetisches Mittel ein
                    double avg = LogicMath.DataBasicMath.getAverage(data);
                    instance.setDataAverage(avg);

                    // Berechne und setze empirische Standardabweichung ein                    
                    double var = LogicMath.DataBasicMath.getVariance(data);
                    instance.setDataVariance(var);

                    // Ermittle Klasseneinteilung aus Datei und gebe dieses als Klassennamen in die Tabelle ein
                    String[] classInterval = LogicMath.contData.ContDataReader.getContClasses(path);
                    instance.setColumnNames(classInterval);
                    Object[][] freqTable = LogicMath.contData.ContDataReader.dataClassification(data, path);
                    instance.setData(freqTable);
                    instance.updateTable();


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
                    System.out.println(file);
                    UiContWindow.getInstance().setPathField(file.toString());
                    try {
                        UiContWindow.getInstance().setDataMerkmal(LogicMath.DataCharacteristics.getDataName(file.toString()));
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
