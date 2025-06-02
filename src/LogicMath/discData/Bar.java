package LogicMath.discData;

import java.awt.*;
import java.util.Arrays;
import Other.*;

public class Bar {

    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    /**
     * Balkenobjekt zum dynamischen Erstellen von Balken.
     * Der Aufbau ist angelehnt an: https://youtu.be/zCiMlbu1-aQ?si=h3n5QvURMDIUct2y&t=991 
     * 
     * @param x      Koordinate x
     * @param y      Koordinate y
     * @param width  Balkenbreite
     * @param height Balkenhöhe
     * @param color  Farbe
     * 
     * @author Minh
     */
    public Bar(double x, double y, double width, double height, Color color) {
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
     * Diese Methode zeichnet die Objekte. Dabei werden die Koordinaten der Balken
     * mittels der P3WindowToViewport auf das Panel gemappt
     * 
     * @param g         Graphics g
     * @param converter P3WindowToViewport
     * 
     * @author Minh
     */
    public void drawBar(Graphics2D g, P3WindowToViewport converter) {
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
     * Diese Methode ermittelt die Dimensionen der Balken anhand der erforderlichen
     * Anzahl und der Panelgröße. Ursprünglich war der Paramter discDimensions ein
     * Object[][], aber wegen Probleme bezüglich des konvertieren zu einem double[]
     * Array wurde die alte Methode kopiert und angepasst
     * 
     * @param discDimensions Double Bar Dimensionen anstelle des Object[][]
     * @param vpHeight       Panelhöhe
     * @param vpWidth        Panelbreite
     * @return Bar[] Objekt
     */
    public static Bar[] barDimensions(double[][] discDimensions, int vpHeight, int vpWidth) {
        int amountCharExp = discDimensions.length;
        Bar[] bars = new Bar[amountCharExp];
        double[] absFreq = new double[amountCharExp];

        double maxHeight;
        int margin = 30;

        double barWidth;
        double coordX;
        double coordY;
        double barHeight;

        // Hole absolute Häufigkeiten aus discDimensions (double[][] war einfacher als
        // Object[][] zu double[])
        for (int i = 0; i < amountCharExp; i++) {
            absFreq[i] = discDimensions[i][1];
        }
        maxHeight = Arrays.stream(absFreq).max().getAsDouble();
        // Berechne Balkenbreite anhand des möglichen Platzes und anzahl der benötigten
        // Balken
        barWidth = (vpWidth - 2 * margin) / (amountCharExp * 1.5);

        // Setze die Ursprungskoordinaten fest und addiere Abstand drauf, die zuvor
        // abgezogen wurden
        for (int i = 0; i < amountCharExp; i++) {
            coordX = margin + (i * barWidth * 1.5);
            barHeight = (absFreq[i] / maxHeight) * (vpHeight - 2 * margin);
            coordY = 0;
            bars[i] = new Bar(coordX, coordY, barWidth, barHeight, P3Style.COLOR_GRAPH_A);
        }
        return bars;
    }
}
