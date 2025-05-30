package LogicMath;

import Other.P3WindowToViewport;
import java.awt.*;
import javax.swing.*;

import LogicMath.discData.Bar;

public class DrawDiagram extends JPanel{
    private Bar[] bars;
    private int width;
    private int height;

    public DrawDiagram(Bar[] bars, int width, int height) {
        this.bars = bars;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double[] origin = {0, 0};

        P3WindowToViewport converter = new P3WindowToViewport(origin, width, height, width, height);

        for(int i = 0; i < bars.length; i++) {

        }

    }
}
