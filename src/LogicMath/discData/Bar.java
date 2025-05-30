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
    private double highestVal;
    private double amountBar;

    public Bar(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void drawBar(Graphics2D g) {
        g.setColor(color);
        g.fill(new Rectangle2D.Double(x, y, width, height));
    }

    // Notiz: Brauche Anzahl der benötigten Balken double[0], ergebend aus Länge der
    // Merkmalsausprägung \n
    // Benötige höchstwert der Merkmalsausprägung oder alle abs. Häuf. in double[1],
    // um Dimensionen in y bestimmen zu können

    public static double[][] barDimensions(double[][] discDimensions, int vpHeight, int vpWidth) {
        int amountCharExp = discDimensions.length;
        
        double[][] result = new double[amountCharExp][3];
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
            //System.out.println(absFreq[i]);
        }

        maxHeight = Arrays.stream(absFreq).max().getAsDouble();

        winHeight = vpHeight - margin;
        winWidth = vpWidth - margin;
        barWidth = winWidth / (amountCharExp * 2);

        for (int i = 0; i < amountCharExp; i++) {
            coordX = margin + (i * barWidth);
            barHeight = (absFreq[i] / maxHeight) * winHeight;
            coordY = vpHeight - (margin + barHeight);

            result[i][0] = coordX;
            result[i][1] = coordY;
            result[i][2] = barHeight;
            //System.out.println("X " + result[i][0]);
            //System.out.println("Y " + result[i][1]);
            //System.out.println("Bar " + result[i][2]);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        double[] data = LogicMath.discData.DiscDataReader.getDiscData("discData.p3");
        double[] characterExpression = LogicMath.discData.DiscDataReader.getCharExp(data);
        double[][] result = LogicMath.discData.DiscDataReader.getAbsFreqDouble(characterExpression, data);

        barDimensions(result, 0, 0);
    }
}
