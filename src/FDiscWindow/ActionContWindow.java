package FDiscWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionContWindow implements ActionListener{
    private static ActionContWindow instance = null;

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
            case "startDiscMaths":
                try {
                    System.out.println(LogicMath.DataCharacteristics.getDiscDataName("discData.p3"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
        
            default:
                throw new UnsupportedOperationException("Unbekannte Eingabe 'actionPerformed' in ActionDiscWindow");
        }

    }
}
