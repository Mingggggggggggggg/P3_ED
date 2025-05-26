package FMainWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

import Other.P3Style;

public class UiMainWindow extends JPanel {
    ActionMainWindow amw = ActionMainWindow.getInstance();

    private JButton startDiscButton = new JButton("startDisc");
    private JButton startContButton = new JButton("startCont");
    private JButton exitButton = new JButton("Exit");
    private GridBagConstraints rules = new GridBagConstraints();

    public UiMainWindow() {
        startDiscButton.setActionCommand("startDiscPressed");
        startDiscButton.addActionListener(amw);
        startDiscButton.setFont(P3Style.BUTTON_FONT);

        startContButton.setActionCommand("startContPressed");
        startContButton.addActionListener(amw);
        startContButton.setFont(P3Style.BUTTON_FONT);
        
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(amw);
        exitButton.setFont(P3Style.BUTTON_FONT);

        this.setLayout(new GridBagLayout());


        rules.gridx = 0;
        rules.gridy = 0;
        rules.weightx = 1;
        rules.insets = new Insets(5, 5, 5, 5);
        rules.fill = GridBagConstraints.HORIZONTAL;

        this.add(startDiscButton, rules);

        rules.gridy = 1;
        this.add(startContButton, rules);

        rules.gridy = 2;
        this.add(exitButton, rules);
    }
}
