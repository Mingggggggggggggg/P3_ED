package LogicMath;
// Code entnommen aus Vorlesungsunterlagen bei Herrn Bachmann in P2
public class QuickSort {

    public static double[] sort(double[] array, int left, int right) {
        if (left < right) {
            int q = partition(array, left, right);
            sort(array, left, q);
            sort(array, q + 1, right);
        }
        return array;
    }

    private static int partition(double[] array, int left, int right) {
        double x = array[(left + right) / 2];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (array[i] < x);

            do {
                j--;
            } while (array[j] > x);

            if (i < j) {
                swap(array, i, j);
            } else {
                return j;
            }
        }
    }

    public static double[] quicksort(double[] array) {
        return sort(array, 0, array.length - 1);
    }

    public static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void output(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\n-------------");
    }
}
