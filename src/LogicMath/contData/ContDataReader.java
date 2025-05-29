package LogicMath.contData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ContDataReader {

    public static double[] getContData(String filePath) throws IOException {
        // System.out.println(filePath);
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

            if (!s.equals("contdata")) {
                System.err.println("Dateiformat ungueltig");
                if (s.equals("discdata")) {
                    System.out.println("Falsche Datei ausgewählt. Meinten Sie contdata.p3?");
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
                            data[i] = Double.parseDouble(select[i].trim());
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

    public static String[] getContClasses(String filePath) throws IOException {
        // System.out.println(filePath);
        String[] data = new String[100];
        int dataLength = 0;
        String[] result;
        FileReader in = null;
        BufferedReader br = null;
        String s = "";
        String[] select;

        try {
            in = new FileReader(filePath);
            br = new BufferedReader(in);

            s = br.readLine().trim();
            // System.out.println(s);

            if (!s.equals("contdata")) {
                System.err.println("Dateiformat ungueltig");
                if (s.equals("discdata")) {
                    System.out.println("Falsche Datei ausgewählt. Meinten Sie contdata.p3?");
                    System.exit(-1);
                }
                System.exit(-1);
            }

            while ((s = br.readLine()) != null) {
                s = s.trim();

                if (s.equals("class")) {

                    s = s.trim();
                    while ((s = br.readLine()) != null && !s.equals("endclass")) {
                        select = s.split(";");

                        for (int i = 0; i < select.length; i++) {
                            data[dataLength] = select[i].trim();

                        }
                        dataLength++;
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
        result = new String[dataLength];
        System.arraycopy(data, 0, result, 0, dataLength);

        return result;
    }

    public static Object[][] dataClassification(double[] data, String filePath) throws IOException {
        String[] classesString = getContClasses(filePath);
        Object[][] result = new Object[classesString.length][2];

        for (int i = 0; i < classesString.length; i++) {
            int count = 0;
            double[] range = IntervalTranslator.getIntervalEncoder(classesString[i]);

            for (int j = 0; j < data.length; j++) {
                if (range[2] == 0) {
                    if (data[j] <= range[0]) {
                        continue;
                    }
                } else if (range[2] == 1) {
                    if (data[j] < range[0]) {
                        continue;
                    }
                }

                if (range[3] == 0) {
                    if (data[j] >= range[1]) {
                        continue;
                    }
                } else if (range[3] == 1) {
                    if (data[j] > range[1]) {
                        continue;
                    }
                }

                count++;
            }

            result[i][0] = count;
            result[i][1] = classesString[i];
            System.out.println(Arrays.toString(result[i]));
        }

        return result;
    }

    /*
     * public static Object[][] dataClassification(double[] data, double[] interval)
     * {
     * Object[][] result = new Object[interval.length][];
     * int count = 0;
     * 
     * if (interval[2] == 0) {
     * for (int i = 0; i < data.length; i++) {
     * if (data[i] > interval[0]) {
     * count++;
     * }
     * }
     * } else if (interval[2] == 1) {
     * for (int i = 0; i < data.length; i++) {
     * if (data[i] >= interval[0]) {
     * count++;
     * }
     * }
     * }
     * 
     * if (interval[3] == 0) {
     * for (int i = 0; i < data.length; i++) {
     * if (data[i] < interval[1]) {
     * count--;
     * }
     * }
     * } else if (interval[3] == 1) {
     * for (int i = 0; i < data.length; i++) {
     * if (data[i] <= interval[1]) {
     * count--;
     * }
     * }
     * }
     * 
     * return result;
     * }
     */
}
