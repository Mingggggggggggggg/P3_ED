package LogicMath.contData;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Arrays;

import Other.P3WindowToViewport;

public class Histogram {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Histogram(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    /**
     * 
     * @param g
     * @param converter
     */
    public void drawHistogram(Graphics2D g, P3WindowToViewport converter) {
        // Setze den ersten Punkt auf "unten" links vom Balken
        double[] point1 = {
                this.x,
                this.y
        };
        // Setze den zweiten Punkt auf "oben" rechts vom Balken
        double[] point2 = {
                this.x + this.width,
                this.y + this.height
        };
        // MapandRound konvertiert die Werte und kehrt Y Achse um
        int[] convPoint1 = converter.mapAndRound(point1);
        int[] convPoint2 = converter.mapAndRound(point2);

        // Setze tatsächliche unten links Koordinate als Ursprung
        int barX = convPoint1[0];
        int barY = convPoint1[1];

        // Ermittle Dimensionen aus der sich der Balken aus dem Ursprung bildet
        int barWidth = convPoint2[0] - convPoint1[0];
        int barHeight = convPoint2[1] - convPoint1[1];
        g.setColor(this.color);
        g.fillRect(barX, barY, barWidth, barHeight);
    }

    /**
     * 
     * @param discDimensions Double Bar Dimensionen anstelle des Object[][]
     * @param vpHeight
     * @param vpWidth
     * @return
     */
    public static Histogram[] histogramDimensions(double[][] discDimensions, int vpHeight, int vpWidth) {
        int amountCharExp = discDimensions.length;
        Histogram[] histogram = new Histogram[amountCharExp];
        double[] absFreq = new double[amountCharExp];

        double maxHeight;
        int margin = 30;

        double histogramWidth;
        double coordX;
        double coordY;
        double histogramHeight;

        // Hole absolute Häufigkeiten aus discDimensions (double[][] war einfacher als
        // Object[][] zu double[])
        for (int i = 0; i < amountCharExp; i++) {
            absFreq[i] = discDimensions[i][1];
        }
        maxHeight = Arrays.stream(absFreq).max().getAsDouble();
        // Berechne Balkenbreite anhand des möglichen Platzes und anzahl der benötigten
        // Balken
        histogramWidth = (vpWidth - 2 * margin) / (amountCharExp * 1.5);

        // Setze die Ursprungskoordinaten fest und addiere Abstand drauf, die zuvor
        // abgezogen wurden
        for (int i = 0; i < amountCharExp; i++) {
            coordX = margin + (i * histogramWidth * 1.5);
            histogramHeight = (absFreq[i] / maxHeight) * (vpHeight - 2 * margin);
            coordY = 0;
            histogram[i] = new Histogram(coordX, coordY, histogramWidth, histogramHeight, Color.BLUE);
        }
        return histogram;
    }
}
