package part3.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = { 3, 1, 5, 12, 0, 4, 9, 1, 2 };
        // InsertionSort.sort(a);
        // BubbleSort.sort(a);
        // SelectionSort.sort(a);
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
