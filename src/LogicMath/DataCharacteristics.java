package LogicMath;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataCharacteristics {

    /**
     * Diese Methode ermittelt die Merkmal eines diskreten und
     * stetigen/quasi-stetigen Datensatzes
     * 
     * @param filePath Pfad zur Datei
     * @return Gibt den Namen des Merkmals aus der Datei zurück
     * @throws IOException
     * 
     * @author Minh
     */
    public static String getDataName(String filePath) throws IOException {
        FileReader in = null;
        BufferedReader br = null;
        String s = "";

        try {
            in = new FileReader(filePath);
            br = new BufferedReader(in);

            s = br.readLine().trim();
            // System.out.println(s);

            if (!s.equals("discdata") && !s.equals("contdata")) {
                return "Dateiformat ungueltig";
            }

            while ((s = br.readLine()) != null) {
                s = s.trim();

                if (s.equals("name")) {
                    s = br.readLine().trim();
                    if (s != null) {
                        return s.trim();
                    }

                    while ((s = br.readLine()) != null && !s.equals("endname")) {
                        return s;
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
            br.close();
            in.close();
        }
        return "Kein Merkmal gefunden";
    }
}
