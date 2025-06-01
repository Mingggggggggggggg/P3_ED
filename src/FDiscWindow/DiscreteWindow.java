package FDiscWindow;

import javax.swing.JFrame;

public class DiscreteWindow extends JFrame {

    UiDiscWindow uiElements = UiDiscWindow.getInstance();

    public DiscreteWindow(String title) {
        super(title);
        
        this.setSize(1400, 1000);
        this.setResizable(true);
        this.setLocation(250, 0);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setBackground(Color.GRAY);

        this.add(uiElements);

    }
}
