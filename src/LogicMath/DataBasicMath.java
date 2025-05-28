package LogicMath;

public class DataBasicMath {
    public static double getAverage(int[] data) {
        double result = 0;

        for(int i = 0; i < data.length; i++) {
            result =+ data[i];
        }

        result = result / data.length;

        return result;
    }

    // Berechne empirische Standardabweichung
    public static double getVariance(int[] data) {
        double result = 0;
        double dataAvg = getAverage(data);

        for (int i = 0; i < data.length; i++) {
            result =+ Math.pow((data[i] + dataAvg), 2);
        }



        return result;
    }
}
