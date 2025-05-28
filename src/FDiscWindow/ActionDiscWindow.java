package FDiscWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class ActionDiscWindow implements ActionListener{
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
                    double[] data = LogicMath.discData.DiscDataReader.getDiscData(path);
                    //System.out.println(Arrays.toString(data));
                    instance.setRawDataUrliste(Arrays.toString(data));
                    instance.getRawDataUrliste().setVisible(true);

                    // Setze arithmetisches Mittel ein
                    double avg = LogicMath.DataBasicMath.getAverage(data);
                    instance.setDataAverage(avg);
                    // Setze epmirische Standardabweichung ein
                    double var = LogicMath.DataBasicMath.getVariance(data);
                    instance.setDataVariance(var);

                    // Setze Merkmalsausprägung für die Tabelle ein
                    String[] charExp = LogicMath.discData.DiscDataReader.getCharExpString(data);
                    instance.setColumnNames(charExp);
                    //System.out.println(Arrays.toString(charExp));
                    double[] charExpDouble = LogicMath.discData.DiscDataReader.getCharExp(data);
                    instance.setData(LogicMath.discData.DiscDataReader.getAbsFreq(charExpDouble, data));
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
                    UiDiscWindow.getInstance().setPathField(file.toString());
                    try {
                        UiDiscWindow.getInstance().setDataMerkmal(LogicMath.DataCharacteristics.getDataName(file.toString()));
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
