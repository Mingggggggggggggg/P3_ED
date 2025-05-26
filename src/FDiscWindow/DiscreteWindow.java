package FDiscWindow;

import javax.swing.JFrame;

public class DiscreteWindow extends JFrame {

    UiDiscWindow uiElements = new UiDiscWindow();

    public DiscreteWindow(String title) {
        super(title);
        
        this.setSize(600, 600);
        this.setResizable(true);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setBackground(Color.GRAY);

        this.add(uiElements);

    }
}
