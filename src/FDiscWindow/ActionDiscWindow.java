package FDiscWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int response = fileChooser.showOpenDialog(null);

        switch (action) {
            case "startDiscMaths":
                System.out.println();
                try {
                    System.out.println(LogicMath.DataCharacteristics.getDataName(path));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case "openFile":


                if (response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    //setPath(file.toString());
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
