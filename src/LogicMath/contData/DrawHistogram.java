package LogicMath.contData;

import javax.swing.*;
import java.awt.*;
import Other.P3WindowToViewport;

public class DrawHistogram extends JPanel {
    private Histogram[] histograms;
    private int width;
    private int height;

    public DrawHistogram(Histogram[] histograms, int width, int height) {
        this.histograms = histograms;
        this.width = width;
        this.height = height;
    }
        public void setHistogram(Histogram[] histograms) {
        this.histograms = histograms;
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



        //RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.setRenderingHints(rh);

        for (int i = 0; i < histograms.length; i++) {
            Histogram hg = histograms[i];
            hg.drawHistogram(g2d, converter);
        }
        // Zeichne Achsen
        int[] xAxisStart= converter.mapAndRound(new double[] {padding + 0,padding +  0});
        int[] xAxisEnd = converter.mapAndRound(new double[] {padding + width, padding + 0});
        int[] yAxisStart = converter.mapAndRound(new double[] {padding + 0, padding + 0});
        int[] yAxisEnd = converter.mapAndRound(new double[] {padding + 0, padding + height});

        g2d.setColor(Color.BLACK);
        g2d.drawLine(xAxisStart[0], xAxisStart[1], xAxisEnd[0], xAxisEnd[1]);
        g2d.drawLine(yAxisStart[0], yAxisStart[1], yAxisEnd[0], yAxisEnd[1]);
    }
}
