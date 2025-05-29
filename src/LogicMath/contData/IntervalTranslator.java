package LogicMath.contData;

public class IntervalTranslator {
    
    public static double[] getInterval(String classString) {
        double[] range = new double[2];
        classString = classString.trim();
        String[] select;
        byte min = 0;
        byte max = 1;
        String s = "";
        boolean isOpenMin;
        boolean isOpenMax;

        if (classString.startsWith("(") || classString.startsWith("[")) {
            if (classString.startsWith("(")) {
                isOpenMin = true;
            }
            if (classString.startsWith("[")) {
                isOpenMin = false;
            }
        }








        if (classString.startsWith("<")) {
            s = classString.replace("<", "").trim();
            range[min] = Double.NEGATIVE_INFINITY;
            range[max] = (Double.parseDouble(s));
        }
        if (classString.startsWith(">")) {
            s = classString.replace(">", "").trim();
            range[max] = Double.POSITIVE_INFINITY;
            range[min] = Double.parseDouble(s);

        }
        if (classString.contains("-")) {
            select = classString.split("-");
            range[min] = Double.parseDouble(select[0]);
            range[max] = Double.parseDouble(select[1]);

            if (range[min] > range[max]) {
                double temp = 0;
                range[min] = temp;
                range[min] = range[max];
                range[max] = temp;
            }

        }

        return range;
    }
}
