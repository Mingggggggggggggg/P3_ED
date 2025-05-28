package LogicMath;

public class DataBasicMath {
    // Berechne Mittelwert
    public static double getAverage(double[] data) {
        double result = 0;

        for(int i = 0; i < data.length; i++) {
            result += data[i];
        }

        result = result / data.length;

        return result;
    }

    // Berechne empirische Standardabweichung
    public static double getVariance(double[] data) {
        double result = 0;
        double dataAvg = getAverage(data);

        for (int i = 0; i < data.length; i++) {
            result += Math.pow((data[i] - dataAvg), 2);
        }
        result = result / (data.length - 1);
        result = Math.sqrt(result);



        return result;
    }
}
