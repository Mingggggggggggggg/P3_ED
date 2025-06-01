package LogicMath.discData;

import java.awt.*;
import javax.swing.*;

import Other.P3WindowToViewport;

public class DrawBarDiagram extends JPanel {

    private Bar[] bars;
    private int width;
    private int height;

    public DrawBarDiagram(Bar[] bars, int width, int height) {
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
        int vpWidth = getWidth();
        int vpHeight = getHeight();
        int padding = 5;

        double[] origin = { 0, 0 };
        P3WindowToViewport converter = new P3WindowToViewport(origin, width, height, vpWidth, vpHeight);

        // RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setRenderingHints(rh);

        for (int i = 0; i < bars.length; i++) {
            Bar bar = bars[i];
            bar.drawBar(g2d, converter);
        }
        // Zeichne Achsen
        int[] xAxisStart = converter.mapAndRound(new double[] { padding + 0, padding + 0 });
        int[] xAxisEnd = converter.mapAndRound(new double[] { padding + width, padding + 0 });
        int[] yAxisStart = converter.mapAndRound(new double[] { padding + 0, padding + 0 });
        int[] yAxisEnd = converter.mapAndRound(new double[] { padding + 0, padding + height });

        g2d.setColor(Color.BLACK);
        g2d.drawLine(xAxisStart[0], xAxisStart[1], xAxisEnd[0], xAxisEnd[1]);
        g2d.drawLine(yAxisStart[0], yAxisStart[1], yAxisEnd[0], yAxisEnd[1]);
    }
}
