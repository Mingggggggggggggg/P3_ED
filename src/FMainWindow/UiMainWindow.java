package FMainWindow;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UiMainWindow extends JPanel{
    ActionMainWindow amw = ActionMainWindow.getInstance();

    private JButton startDiscButton = new JButton("startDisc");
    private JButton startContButton = new JButton("startCont");
    private JButton exitButton = new JButton("Exit");

    public UiMainWindow() {
        startDiscButton.setActionCommand("startDiscPressed");
        startDiscButton.addActionListener(amw);

        startContButton.setActionCommand("startContPressed");
        startContButton.addActionListener(amw);
        
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(amw);
    }

    public JButton getStartDiscButton() {
        return startDiscButton;
    }
    public JButton getStartContButton() {
        return startContButton;
    }
    public JButton getExitButton() {
        return exitButton;
    }
}
