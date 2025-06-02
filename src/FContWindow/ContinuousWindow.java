package FContWindow;

import javax.swing.JFrame;
import java.awt.*;


public class ContinuousWindow extends JFrame {

        UiContWindow uiElements = UiContWindow.getInstance();

    public ContinuousWindow(String title) {
        super(title);
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() - 250;
        int height = gd.getDisplayMode().getHeight();
        this.setSize(width, height);
        this.setResizable(true);
        this.setLocation(250, 0);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setBackground(Color.GRAY);

        this.add(uiElements);
    }
}
