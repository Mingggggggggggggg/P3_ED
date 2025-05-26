package FContWindow;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import FDiscWindow.ActionDiscWindow;

public class UiContWindow {
        ActionDiscWindow adw = ActionDiscWindow.getInstance();

    private JButton startButton = new JButton("startDisc");
    private JTextField pathField = new JTextField("Pfad hier eingeben");
    private JLabel dataMerkmal = new JLabel();
    private JLabel dataUrliste = new JLabel();
    private JTable dataTable = new JTable();
    private JLabel dataAverage = new JLabel();
    private JLabel dataVariance = new JLabel();
    private JPanel dataDiagram = new JPanel();

    private GridBagConstraints rules = new GridBagConstraints();

    public UiContWindow() {
        
    }
}
