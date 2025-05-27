package LogicMath.discData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DiscDataReader {

    public static int[] getDiscData(String name) throws IOException {
        int[] data = null;

        try {
            FileReader in = new FileReader(name);
            BufferedReader br = new BufferedReader(in);

            
        } catch (FileNotFoundException e) {

        } catch (IOException ex) {

        } finally {

        }
        return data;
    }



}
