package LogicMath.contData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContDataReader {

    /**
     * Diese Methode extrahiert stetige bzw. quasi-stetige Daten aus einer Datei
     * und gibt diese als Double Array zurück.
     * 
     * @param filePath Pfad zur Datei
     * @return Gibt Daten als Double Array zurück
     * @throws IOException
     * 
     * @author Minh
     */
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

    /**
     * Diese Methode extrahiert die Klassenintervalle aus der Datei und gibt diese
     * als String Array zurück.
     * Zum nahtlosen Einfügen in columnNames einer JTable
     * 
     * @param filePath Pfad zur Datei
     * @return Klassenintervalle aus der Datei als String Array
     * @throws IOException
     * 
     * @author Minh
     */
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

    /**
     * Diese Methode verarbeitet die String Klassenintervalle und zählt anhand der
     * ausgelesenen Daten
     * die Häufigkeiten, wie oft diese in die entsprechhenden Klassenintervalle
     * fallen.
     * 
     * @param data     Array aus {@link #getContData(String)}
     * @param filePath Pfad zur Datei
     * @return Zweidimensionales Objekt mit Klassenintervall und dazugehörige
     *         Häufigkeiten
     * @throws IOException
     * 
     * @author Minh
     */
    public static Object[][] dataClassification(double[] data, String filePath) throws IOException {
        String[] classesString = getContClasses(filePath);
        Object[][] result = new Object[classesString.length][2];

        for (int i = 0; i < classesString.length; i++) {
            int count = 0;
            double[] range = IntervalTranslator.getIntervalEncoder(classesString[i]);

            for (int j = 0; j < data.length; j++) {
                // Wenn untere Grenze offen
                if (range[2] == 0) {
                    if (!(data[j] > range[0])) {
                        continue;
                    }
                    // Wenn untere Grenze geschlossen
                } else if (range[2] == 1) {
                    if (!(data[j] >= range[0])) {
                        continue;
                    }
                }
                // Bei obere Grenze offen
                if (range[3] == 0) {
                    if (!(data[j] < range[1])) {
                        continue;
                    }
                    // Wenn obere Grenze geschlossen
                } else if (range[3] == 1) {
                    if (!(data[j] <= range[1])) {
                        continue;
                    }
                }

                count++;
            }

            result[i][0] = count; // Häufigkeit im Intervall
            result[i][1] = classesString[i]; // Klassenintervall
            // System.out.println((result[i][1]));
        }
        return result;
    }

    public static double[][] dataClassificationDouble(double[] data, String filePath) throws IOException {
        String[] classesString = getContClasses(filePath);
        double[][] result = new double[classesString.length][classesString.length * 2];

        for (int i = 0; i < classesString.length; i++) {
            int count = 0;
            double[] range = IntervalTranslator.getIntervalEncoder(classesString[i]);

            for (int j = 0; j < data.length; j++) {
                // Wenn untere Grenze offen
                if (range[2] == 0) {
                    if (!(data[j] > range[0])) {
                        continue;
                    }
                    // Wenn untere Grenze geschlossen
                } else if (range[2] == 1) {
                    if (!(data[j] >= range[0])) {
                        continue;
                    }
                }
                // Bei obere Grenze offen
                if (range[3] == 0) {
                    if (!(data[j] < range[1])) {
                        continue;
                    }
                    // Wenn obere Grenze geschlossen
                } else if (range[3] == 1) {
                    if (!(data[j] <= range[1])) {
                        continue;
                    }
                }

                count++;
            }

            result[i][0] = count; // Häufigkeit im Intervall
            result[i][1] = range[0]; // Untere Grenze
            result[i][2] = range[1]; // Obere Grenze
            //System.out.println(range[0]);
            //System.out.println(range[1]);

            /* 
            for (int k = 0; k < 2; k++) {
                result[i + k][1] = range[k]; // Klassenintervall
                // System.out.println((result[i][1]));
            }*/
        }
        return result;
    }

    /**
     * Diese Methode prüft, ob die Grenzen, die in der Datei gegeben werden,
     * lückenlos sind.
     * Nicht lückenlose Klassen sollen eine Fehlermeldung geben und das Programm
     * schließen.
     * 
     * @param classesString String aus {@link #getContClasses(String)}
     * 
     * @author Minh
     */
    public static void continuityCheck(double[] encodedClasses) {
        boolean hasNegativeInfinity;
        boolean hasPositiveInfinity;
        for (int i = 0; i < encodedClasses.length; i++) {

        }
    }
}
