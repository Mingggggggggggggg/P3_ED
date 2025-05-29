package LogicMath.contData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContDataReader {

    public static void main(String[] args) {
        try {
            double[] test = getContData("contData.p3");
            for (int i = 0; i < test.length; i++) {
                System.out.println(test[i]);
            }

            String[] test2 = getContClasses("contData.p3");

            for (int i = 0; i < test2.length; i++) {
                double[] range = IntervalTranslator.getInterval(test2[i]);
                for (int j = 0; j < 2; j++) {
                    System.out.println(range[j]);
                }
                //System.out.println(test2[i]);
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static double[] getContData(String filePath) throws IOException {
        //System.out.println(filePath);
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
            //System.out.println(s);

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
        //System.out.println(dataLength);
        result = new double[dataLength];
        System.arraycopy(data, 0, result, 0, dataLength);
        return result;
    }

public static String[] getContClasses(String filePath) throws IOException {
        //System.out.println(filePath);
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
            //System.out.println(s);

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
        //System.out.println(dataLength);
        result = new String[dataLength];
        System.arraycopy(data, 0, result, 0, dataLength);
        return result;
    }
}
