package FContWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            case value:
                
                break;
        
            default:
                throw new UnsupportedOperationException("Unbekannte Eingabe 'actionPerformed' in ActionContWindow");
        }

    }
}
