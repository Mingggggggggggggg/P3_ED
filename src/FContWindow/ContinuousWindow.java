package FContWindow;

import javax.swing.JFrame;


public class ContinuousWindow extends JFrame {

        UiContWindow uiElements = UiContWindow.getInstance();

    public ContinuousWindow(String title) {
        super(title);
        
        this.setSize(1400, 1000);
        this.setResizable(true);
        this.setLocation(250, 0);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setBackground(Color.GRAY);

        this.add(uiElements);
    }
}
