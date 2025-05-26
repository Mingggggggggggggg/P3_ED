package FMainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import FContWindow.ContinuousWindow;
import FDiscWindow.DiscreteWindow;

public class ActionMainWindow implements ActionListener{
    private static ActionMainWindow instance = null;

    public static ActionMainWindow getInstance() {
        if (instance == null) {
            instance = new ActionMainWindow();
        }
        return instance;
    }
    private ActionMainWindow() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "startDiscPressed":
                DiscreteWindow discWindow = new DiscreteWindow("Diskrete Daten");
                discWindow.setVisible(true);

            case "startContPressed":
                ContinuousWindow contWindow = new ContinuousWindow("Stetige Daten");
                contWindow.setVisible(true);

            case "exit":
                System.out.println("Programm wird beendet FMAIN");
                System.exit(1);
        
            default:
                throw new UnsupportedOperationException("Unbekannte Eingabe 'actionPerformed' in ActionMainWindow");
        }


    }
}
