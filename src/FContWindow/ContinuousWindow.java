package FContWindow;

import javax.swing.JFrame;

public class ContinuousWindow {
        static class ContWindow extends JFrame {
        

        public ContWindow(String title) {
            super(title);
        
            this.setSize(600, 600);
            this.setResizable(true);
            this.setLocation(500, 100);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //this.setBackground(Color.GRAY);
        }
    }
}
