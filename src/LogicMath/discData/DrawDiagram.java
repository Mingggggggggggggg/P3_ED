package LogicMath.discData;

import Other.P3WindowToViewport;
import java.awt.*;
import javax.swing.*;


public class DrawDiagram extends JPanel {

    private Bar[] bars;
    private int width;
    private int height;

    public DrawDiagram(Bar[] bars, int width, int height) {
        this.bars = bars;
        this.width = width;
        this.height = height;
    }

    public void setBars(Bar[] bars) {
        this.bars = bars;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double[] origin = { 0, 0 };
        P3WindowToViewport converter = new P3WindowToViewport(origin, width, height, width, height);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);

        for (int i = 0; i < bars.length; i++) {
            Bar bar = bars[i];
            bar.drawBar(g2d, converter);
        }

    }
}
