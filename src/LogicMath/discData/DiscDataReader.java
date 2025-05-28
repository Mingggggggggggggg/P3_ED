package LogicMath.discData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DiscDataReader {


    public static int[] getDiscData(String name) throws IOException {
        System.out.println(name);
        int[] data = new int[100];
        int dataLength = 0;
        int[] result;
        FileReader in = null;
        BufferedReader br = null;
        String s = "";
        String[] select;

        try {
            in = new FileReader(name);
            br = new BufferedReader(in);
            
            s = br.readLine().trim();
            //System.out.println(s);

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
        //System.out.println(dataLength);
        result = new int[dataLength];
        System.arraycopy(data, 0, result, 0, dataLength);
        return result;
    }
}
