package FMainWindow;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

    UiMainWindow uiElements = new UiMainWindow();

    public MainWindow(String title) {
        super(title);

        this.setSize(200, 200);
        this.setResizable(false);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(uiElements);

    }
}
