package LogicMath.discData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DiscDataReader {

    public static int[] getDiscData(String name) throws IOException {
        int[] data = null;

        FileReader in = null;
        BufferedReader br = null;
        String s = "";

        try {
            in = new FileReader(name);
            br = new BufferedReader(in);
            
            s = br.readLine().trim();
            //System.out.println(s);

            if (!s.equals("discdata")) {
                System.err.println("Dateiformat ungueltig");
                System.exit(-1);
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
        return data;
    }



}
