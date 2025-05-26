package FMainWindow;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UiMainWindow extends JPanel{
    private JButton startDiscButton = new JButton("startDisc");
    private JButton starContButton = new JButton("startCont");
    private JButton exitButton = new JButton("Exit");

    public JButton getStartDiscButton() {
        return startDiscButton;
    }
    public JButton getStarContButton() {
        return starContButton;
    }
    public JButton getExitButton() {
        return exitButton;
    }
}
