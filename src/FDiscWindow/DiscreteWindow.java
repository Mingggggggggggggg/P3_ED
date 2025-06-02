package FDiscWindow;

import javax.swing.JFrame;
import java.awt.*;

public class DiscreteWindow extends JFrame {

    UiDiscWindow uiElements = UiDiscWindow.getInstance();

    public DiscreteWindow(String title) {
        super(title);

        // https://stackoverflow.com/questions/3680221/how-can-i-get-screen-resolution-in-java
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() - 250;
        int height = gd.getDisplayMode().getHeight();
        this.setSize(width, height);
        this.setResizable(true);
        this.setLocation(250, 0);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // this.setBackground(Color.GRAY);

        this.add(uiElements);

    }
}
