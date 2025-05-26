package FDiscWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionDiscWindow implements ActionListener{
    private static ActionDiscWindow instance = null;

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
                System.err.println("Mathe Mathe Mathe Mathe Mathe Mathe");
                break;
        
            default:
                throw new UnsupportedOperationException("Unbekannte Eingabe 'actionPerformed' in ActionDiscWindow");
        }

    }
}
