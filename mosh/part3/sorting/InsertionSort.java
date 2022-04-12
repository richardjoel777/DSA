package part3.sorting;

public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int curr = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > curr) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = curr;
        }
    }
}
