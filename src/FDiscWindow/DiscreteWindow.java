package FDiscWindow;

import javax.swing.JFrame;

public class DiscreteWindow extends JFrame {

    UiDiscWindow uiElements = UiDiscWindow.getInstance();

    public DiscreteWindow(String title) {
        super(title);
        
        this.setSize(1000, 1000);
        this.setResizable(true);
        this.setLocation(500, 10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setBackground(Color.GRAY);

        this.add(uiElements);

    }
}
