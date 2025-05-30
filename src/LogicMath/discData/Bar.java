package LogicMath.discData;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Arrays;

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

    // Notiz: Brauche Anzahl der benötigten Balken double[0], ergebend aus Länge der
    // Merkmalsausprägung \n
    // Benötige höchstwert der Merkmalsausprägung oder alle abs. Häuf. in double[1],
    // um Dimensionen in y bestimmen zu können

    public static Bar[] barDimensions(double[][] discDimensions, int vpHeight, int vpWidth) {
        int amountCharExp = discDimensions.length;

        Bar[] bars = new Bar[amountCharExp];
        double[] absFreq = new double[amountCharExp];

        double maxHeight;
        int margin = 20;

        int winHeight;
        int winWidth;
        int barWidth;

        double coordX;
        double coordY;
        double barHeight;

        // Extrahiere absolute Häufigkeiten und ermittle den maxWert
        for (int i = 0; i < amountCharExp; i++) {
            absFreq[i] = discDimensions[i][1];
            // System.out.println(absFreq[i]);
        }

        maxHeight = Arrays.stream(absFreq).max().getAsDouble();

        winHeight = vpHeight - margin;
        winWidth = vpWidth - margin;
        barWidth = winWidth / (amountCharExp * 2);

        for (int i = 0; i < amountCharExp; i++) {
            coordX = margin + (i * barWidth);
            barHeight = (absFreq[i] / maxHeight) * winHeight;
            coordY = vpHeight - (margin + barHeight);

            bars[i] = new Bar(coordX, coordY, barWidth, barHeight, Color.BLUE);
        }
        return bars;
    }
}
