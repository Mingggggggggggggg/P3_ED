package FMainWindow;

import javax.swing.JFrame;

import java.awt.*;

public class MainWindow extends JFrame {

    UiMainWindow uiElements = new UiMainWindow();

    public MainWindow(String title) {
        super(title);

        this.setSize(300, 100);
        this.setResizable(true);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
        this.setLayout(new GridBagLayout());
        

        GridBagConstraints rules = new GridBagConstraints();
        rules.gridx = 0;
        rules.gridy = 0;
        rules.weightx = 0.1;
        rules.weighty = 1.0;
        rules.fill = GridBagConstraints.BOTH;
    
        uiElements.setBackground(Color.BLUE);
        add(uiElements, rules);

        rules.gridx = 1;
        rules.gridy = 1;
        rules.weightx = 0;
        rules.weighty = 0;
        //rules.fill = GridBagConstraints.HORIZONTAL;

        uiElements.add(uiElements.getStartDiscButton(), rules);

        rules.gridx = 1;
        rules.gridy = 2;
        rules.weightx = 0;
        rules.weighty = 0;
        //rules.fill = GridBagConstraints.HORIZONTAL;

        uiElements.add(uiElements.getStartContButton(), rules);

        rules.gridx = 1;
        rules.gridy = 3;
        rules.weightx = 0;
        rules.weighty = 0;
        //rules.fill = GridBagConstraints.HORIZONTAL;

        uiElements.add(uiElements.getExitButton(), rules);
        /* 
        add(uiElements.getStartDiscButton(), BorderLayout.NORTH);
        add(uiElements.getStartContButton(), BorderLayout.CENTER);
        add(uiElements.getExitButton(), BorderLayout.SOUTH);
        */
    }
}
