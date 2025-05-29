package LogicMath.discData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DiscDataReader {

    public static double[] getDiscData(String filePath) throws IOException {
        System.out.println(filePath);
        double[] data = new double[100];
        int dataLength = 0;
        double[] result;
        FileReader in = null;
        BufferedReader br = null;
        String s = "";
        String[] select;

        try {
            in = new FileReader(filePath);
            br = new BufferedReader(in);

            s = br.readLine().trim();
            // System.out.println(s);

            if (!s.equals("discdata")) {
                System.err.println("Dateiformat ungueltig");
                if (s.equals("contdata")) {
                    System.out.println("Falsche Datei ausgewählt. Meinten Sie discdata.p3?");
                    System.exit(-1);
                }
                System.exit(-1);
            }

            while ((s = br.readLine()) != null) {
                s = s.trim();

                if (s.equals("data")) {

                    s = s.trim();
                    while ((s = br.readLine()) != null && !s.equals("enddata")) {
                        select = s.split(";");

                        for (int i = 0; i < select.length; i++) {
                            data[i] = Integer.parseInt(select[i].trim());
                            dataLength++;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Datei nicht gefunden.");
            System.err.println(e);
        } catch (IOException ex) {
            System.err.println("Datei konnte nicht gelesen werden.");
            System.err.println(ex);
        } finally {
            if (br != null) {
                br.close();
            }
            if (in != null) {
                in.close();
            }
        }

        // Kopiere data-Array in ein result-array mit der korrekten Länge.
        // System.out.println(dataLength);
        result = new double[dataLength];
        System.arraycopy(data, 0, result, 0, dataLength);
        return result;
    }


    public static double[] getCharExp(double[] data) {
        HashSet<Double> characterExpression = new HashSet<Double>();

        for (int i = 0; i < data.length; i++) {
            characterExpression.add(data[i]);
        }

        Double[] puffer = characterExpression.toArray(new Double[0]);
        System.out.println(characterExpression);

        double[] toSort = new double[puffer.length];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = puffer[i];
        }

        LogicMath.QuickSort.quicksort(toSort);
        //LogicMath.QuickSort.output(toSort);

        return toSort;
    }

    public static String[] getCharExpString(double[] data) {
        HashSet<Double> characterExpression = new HashSet<Double>();

        for (int i = 0; i < data.length; i++) {
            characterExpression.add(data[i]);
        }

        Double[] puffer = characterExpression.toArray(new Double[0]);
        //System.out.println(characterExpression);

        double[] toSort = new double[puffer.length];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = puffer[i];
        }

        LogicMath.QuickSort.quicksort(toSort);
        //LogicMath.QuickSort.output(toSort);

        String[] result = new String[toSort.length];
        for (int i = 0; i < toSort.length; i++) {
            result[i] = String.valueOf((Double) toSort[i]);
        }
        return result;

    }

    public static Object[][] getAbsFreq(double[] expression, double[] data) {
        Object[][] result = new Object[expression.length][2];
        double[] toSort = LogicMath.QuickSort.quicksort(data);
        //LogicMath.QuickSort.output(data);

        for (int i = 0; i < expression.length; i++) {
            double current = expression[i];
            int absFreq = 0;

            for (int j = 0; j < toSort.length; j++) {
                if (toSort[j] == current) {
                    absFreq++;    
                }
            }

        result[i][0] = String.valueOf(current);
        result[i][1] = absFreq;
        }
        //System.out.println(result.toString());
        return result;
    }
}
