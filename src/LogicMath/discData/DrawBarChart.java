package LogicMath.discData;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JPanel;
import Other.P3WindowToViewport;

public class DrawBarChart extends JPanel {
    private double min;
    private double max;

    public static void initialize(Object[][] absFreq) {
        String[] characterExpressionString;
        double[] characterExpression;
        double[] absFreqDouble;

        for (int i = 0; i < absFreq.length; i++) {

            characterExpressionString[i] = absFreq[i][0];


            //System.out.println(absFreq[i][0]); // Merkmalsausprägung
            //System.out.println(absFreq[i][1]); // Absolute Häufigkeiten
        }
        //System.out.println(absFreq.toString());

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        P3WindowToViewport converter = new P3WindowToViewport(null, WIDTH, HEIGHT, WIDTH, HEIGHT);

    }

    public static void main(String[] args) throws IOException {
        double[] data = LogicMath.discData.DiscDataReader.getDiscData("discData.p3");
        String[] charExp = LogicMath.discData.DiscDataReader.getCharExpString(data);
        double[] charExpDouble = LogicMath.discData.DiscDataReader.getCharExp(data);
        Object[][] freqTable = LogicMath.discData.DiscDataReader.getAbsFreq(charExpDouble, data);


        initialize(freqTable);
    }
    

    
}
