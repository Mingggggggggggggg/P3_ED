package LogicMath.discData;

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

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);

        for (int i = 0; i < bars.length; i++) {
            Bar bar = bars[i];
            bar.drawBar(g2d);
        }

    }
}
