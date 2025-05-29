package LogicMath.contData;

public class IntervalTranslator {

    public static double[] getIntervalEncoder(String classString) {
        double[] range = new double[4];
        classString = classString.trim();
        String[] select;
        byte min = 0;
        byte max = 1;
        String intervalTypeMin = "";
        String intervalTypeMax = "";
        String type = "";

        // Überprüfe auf offenes oder geschlossenes Intervall und kodiere diese
        // entsprechend an den Indizes 3 und 4 im double array
        if (classString.startsWith("(")) {
            intervalTypeMin = "(";
        } else if (classString.startsWith("[")) {
            intervalTypeMin = "[";
        }

        if (classString.endsWith(")")) {
            intervalTypeMax = ")";
        } else if (classString.endsWith("]")) {
            intervalTypeMax = "]";
        }

        if (classString.startsWith("<")) {
            type = "<";
        } else if (classString.startsWith(">")) {
            type = ">";
        } else if (classString.contains("-")) {
            type = "-";
        }

        switch (intervalTypeMin) {
            case "(":
                classString = classString.replace("(", "").trim();
                range[2] = 0;

                break;

            case "[":
                classString = classString.replace("[", "").trim();
                range[2] = 1;

                break;

            default:
                System.err.println("Unbekanntes öffnendes Intervall");
                break;
        }

        switch (intervalTypeMax) {
            case ")":
                classString = classString.replace(")", "").trim();
                range[3] = 0;

                break;

            case "]":
                classString = classString.replace("]", "").trim();
                range[3] = 1;

                break;

            default:
                System.err.println("Unbekanntes schließendes Intervall");
                break;
        }

        //Anhand des Vergleichsoperator werden der niedrigstmögliche Wert im Intervall auf range[0] 
        //und der höchstmögliche Wert im Intervall auf range[1] gespeichert
        switch (type) {
            case "<":
                classString = classString.replace("<", "").trim();
                range[min] = Double.NEGATIVE_INFINITY;
                range[max] = (Double.parseDouble(classString));

                break;
            case ">":
                classString = classString.replace(">", "").trim();
                range[max] = Double.POSITIVE_INFINITY;
                range[min] = Double.parseDouble(classString);

                break;
            case "-":
                select = classString.split("-");
                range[min] = Double.parseDouble(select[0]);
                range[max] = Double.parseDouble(select[1]);

                if (range[min] > range[max]) {
                    double temp = 0;
                    temp = range[min];
                    range[min] = range[max];
                    range[max] = temp;
                }

                break;
            default:
                System.err.println("Unbekannter Vergleichsoperator");
                break;
        }
        return range;
    }
}
