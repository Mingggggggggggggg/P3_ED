package FMainWindow;

import javax.swing.JFrame;
import java.awt.Color;

public class MainWindow extends JFrame {

    UiMainWindow uiElements = new UiMainWindow();

    public MainWindow(String title) {
        super(title);

        this.setSize(600, 600);
        this.setResizable(true);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
    }
}
