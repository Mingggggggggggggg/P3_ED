package LogicMath;

import Other.P3WindowToViewport;
import java.awt.*;
import javax.swing.*;

import LogicMath.discData.Bar;

public class DrawDiagram extends JPanel{
    private Bar[] bars;
    private int width;
    private int height;
    private Bar b1;

    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        P3WindowToViewport converter = new P3WindowToViewport(null, width, height, width, height);
    }
}
