package FContWindow;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import FDiscWindow.ActionDiscWindow;

public class UiContWindow extends JPanel {
    
    ActionDiscWindow adw = ActionDiscWindow.getInstance();

    private JButton startButton = new JButton("Start");
    private JTextField pathField = new JTextField("Dateipfad hier");
    private JLabel dataMerkmal = new JLabel("MERKMAL HIER");
    private JLabel dataUrliste = new JLabel("Urliste: ");
    private JTable dataTable = new JTable();
    private JLabel dataAverage = new JLabel("Arithmetisches Mittel: ");
    private JLabel dataVariance = new JLabel("Empirische Standardabweichung: ");
    private JPanel dataDiagram = new JPanel();

    private GridBagConstraints rules = new GridBagConstraints();

    public UiContWindow() {
        
    }
}
