package LogicMath.discData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.HashSet;
import java.util.Set;

public class DiscDataReader {

    public static double[] getDiscData(String name) throws IOException {
        System.out.println(name);
        double[] data = new double[100];
        int dataLength = 0;
        double[] result;
        FileReader in = null;
        BufferedReader br = null;
        String s = "";
        String[] select;

        try {
            in = new FileReader(name);
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
        double[] result;
        for (int i = 0; i < data.length; i++) {
            characterExpression.add(data[i]);
        }

        String[] puffer = new String[characterExpression.size()];
        characterExpression.toArray(puffer);
        result = new double[characterExpression.size()];

        for (int i = 0; i < characterExpression.size(); i++) {
            result[i] = Double.parseDouble(puffer[i]);
        }

        return result;
    }

    public static String[] getCharExpString(double[] data) {
        HashSet<Double> characterExpression = new HashSet<Double>();
        int k = 0;

        for (int i = 0; i < data.length; i++) {
            characterExpression.add(data[i]);
        }

        String[] result = new String[characterExpression.size()];

        Object[] tempArray = characterExpression.toArray();

        for (int j = 0; j < tempArray.length; j++) {
            result[k] = String.valueOf((Double) tempArray[j]);
            k++;
        }
        // STRING NICHT RICHTIG ALS ARRAY WIEDERGEGEBEN SONDER NUR ARRAY[0]
        return result;
    }

    public static double[] getAbsFreq(double[] expression, double[] data) {
        double[] puffer = new double[data.length];

        return data;
    }
}
