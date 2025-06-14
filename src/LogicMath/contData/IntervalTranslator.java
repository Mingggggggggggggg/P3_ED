﻿package LogicMath.contData;

public class IntervalTranslator {

    /**
     * Diese Methode enkodiert die Klassenintervall Strings von bspw. (10-15] zu
     * range[] = {10, 15, 0, 1}. range[0 und 1] geben jeweils die untere und obere
     * Grenze wieder. range[2 und 3] zeigen an, ob es sich um eine offene bzw.
     * geschlossene Grenze handelt; 0 für offen und 1 für geschlossen.
     * Diese Lösung sah in meinem Kopf viel eleganter aus, aber scheint wegen der
     * switch-cases etwas lang geraten zu sein. Ich mag switch-cases sehr und wollte
     * tief verschachtelte if-Anweisungen vermeiden
     * 
     * @param classString Ein Klassenintervall-String aus
     *                    {@link #getContClasses(String)}
     * @return Gibt Klassenintervall als double Array der Länge 4 zurück. Das Array
     *         ist wie folgt kodiert [untere Grenze, obere Grenze, offen[0] oder
     *         geschlossen[1], offen[0] oder geschlossen[1]
     * 
     * @author Minh
     */
    public static double[] getIntervalEncoder(String classString) {
        double[] range = new double[4];
        classString = classString.replace(";", "").trim();
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

        // Auf contains setzen, anstelle von startsWith.
        // startsWith referenziert auf den Originalstring? Oder replace?
        if (classString.contains("<")) {
            type = "<";
        } else if (classString.contains(">")) {
            type = ">";
        } else if (classString.contains("-")) {
            type = "-";
        }

        // Kodiere offene (0) bzw. geschlossene (1) Intervalle in die Indizes
        // range[2] für die untere Grenze und
        // range[3] für die obere Grenze
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

        // Anhand des Vergleichsoperator werden der niedrigstmögliche Wert im Intervall
        // auf range[0]
        // und der höchstmögliche Wert im Intervall auf range[1] gespeichert
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

                /*
                 * if (range[min] > range[max]) {
                 * double temp = 0;
                 * temp = range[min];
                 * range[min] = range[max];
                 * range[max] = temp;
                 * }
                 */

                break;
            default:
                System.err.println("Unbekannter Vergleichsoperator " + classString);
                break;
        }
        // LogicMath.contData.ContDataReader.continuityCheck(range);
        return range;
    }
}
