package LogicMath.discData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DiscDataReader {

    /**
     * Diese Methode liest die Zieldatei ein und gibt die ensprechenden Daten als
     * Array zurück
     * 
     * @param filePath Pfad zur Datei
     * @return
     * @throws IOException
     */
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

    /**
     * Diese Methode ermittelt die Merkmalsausprägungen eines diskreten Datensatzes.
     * Hierbei wird sich die Natur des Sets zunutze gemacht, da diese keine
     * Dublikate erlauben
     * 
     * @param data Daten ausgelesen aus {@link #getDiscData(String)}
     * @return Gibt Merkmalsausprägung als Double Array zurück
     */
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
        // LogicMath.QuickSort.output(toSort);

        return toSort;
    }

    /**
     * Nahezu identisch zu {@link #getCharExp(double[])}. Gibt die Daten jedoch als
     * String Array zurück
     * 
     * @param data Daten ausgelesen aus {@link #getDiscData(String)}
     * @return Gibt Merkmalsausprägung als String Array zurück
     */
    public static String[] getCharExpString(double[] data) {
        HashSet<Double> characterExpression = new HashSet<Double>();

        for (int i = 0; i < data.length; i++) {
            characterExpression.add(data[i]);
        }

        Double[] puffer = characterExpression.toArray(new Double[0]);
        // System.out.println(characterExpression);

        double[] toSort = new double[puffer.length];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = puffer[i];
        }

        LogicMath.QuickSort.quicksort(toSort);
        // LogicMath.QuickSort.output(toSort);

        String[] result = new String[toSort.length];
        for (int i = 0; i < toSort.length; i++) {
            result[i] = String.valueOf((Double) toSort[i]);
        }
        return result;

    }

    /**
     * 
     * @param expression Merkmalsausprägung aus {@link #getCharExp(double[])}
     * @param data       Daten ausgelesen aus {@link #getDiscData(String)}
     * @return Gibt Merkmalsausprägung und Häufigkeit als zweidimensionales Objekt
     *         zurück
     */
    public static Object[][] getAbsFreq(double[] expression, double[] data) {
        Object[][] result = new Object[expression.length][2];
        double[] toSort = LogicMath.QuickSort.quicksort(data);
        // LogicMath.QuickSort.output(data);

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
        // System.out.println(result.toString());
        return result;
    }
}
