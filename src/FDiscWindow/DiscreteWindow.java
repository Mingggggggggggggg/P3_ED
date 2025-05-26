package FDiscWindow;

import javax.swing.JFrame;

public class DiscreteWindow extends JFrame {

    UiDiscWindow uiElements = new UiDiscWindow();

    public DiscWindow(String title) {
        super(title);
        
        this.setSize(600, 600);
        this.setResizable(true);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setBackground(Color.GRAY);

        uiElements.add(uiElements);

    }
}
