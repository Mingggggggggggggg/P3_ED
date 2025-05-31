package LogicMath.discData;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

import Other.P3WindowToViewport;

public class Bar {

    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Bar(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void drawBar(Graphics2D g) {
        g.setColor(color);
        Rectangle2D.Double bar = new Rectangle2D.Double(x, y, width, height);
        g.fill(bar);
    }

    /** aaaaaaaaaaaaaaaaaaaaaaaa P3WindowToViewport vergessen
     * Kann hier rein? -> dynamische Skalierung der Balken?
     * 
     * @param discDimensions Double Bar Dimensionen anstelle des Object[][]
     * @param vpHeight
     * @param vpWidth
     * @return
     */
    public static Bar[] barDimensions(double[][] discDimensions, int vpHeight, int vpWidth) {
        int amountCharExp = discDimensions.length;

        //double[] origin = { 0, 0 };
        //P3WindowToViewport converter = new P3WindowToViewport(origin, width, height, width, height);

        Bar[] bars = new Bar[amountCharExp];
        double[] absFreq = new double[amountCharExp];

        double maxHeight;
        int margin = 17;

        int winHeight;
        int winWidth;
        int barWidth;

        double coordX;
        double coordY;
        double barHeight;

        // Extrahiere absolute Häufigkeiten und ermittle den höchstwert
        for (int i = 0; i < amountCharExp; i++) {
            absFreq[i] = discDimensions[i][1];
            // System.out.println(absFreq[i]);
        }
        maxHeight = Arrays.stream(absFreq).max().getAsDouble();

        winHeight = vpHeight - (margin * 2);
        winWidth = vpWidth - (margin * 2);
        barWidth = winWidth / (amountCharExp * 2);

        for (int i = 0; i < amountCharExp; i++) {
            coordX = margin + (i * barWidth * 1.275);
            barHeight = (absFreq[i] / maxHeight) * winHeight;
            coordY = vpHeight - (margin + barHeight);

            bars[i] = new Bar(coordX, coordY, barWidth, barHeight, Color.BLUE);
        }
        return bars;
    }
}
