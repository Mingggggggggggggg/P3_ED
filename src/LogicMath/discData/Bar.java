package LogicMath.discData;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
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

    public void drawBar(Graphics2D g, P3WindowToViewport converter) {
        double[] topLeft = { x, y + height };
        double[] bottomRight = { x + width, y };
        int[] topLeftPx = converter.mapAndRound(topLeft);
        int[] bottomRightPx = converter.mapAndRound(bottomRight);

        int rectX = topLeftPx[0];
        int rectY = topLeftPx[1];
        int rectWidth = bottomRightPx[0] - topLeftPx[0];
        int rectHeight = bottomRightPx[1] - topLeftPx[1];

        g.setColor(color);
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
    }


    public static Bar[] barDimensions(double[][] discDimensions, int vpHeight, int vpWidth) {
        int amountCharExp = discDimensions.length;

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

        // Extrahiere absolute Häufigkeiten und ermittle den maxWert
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
