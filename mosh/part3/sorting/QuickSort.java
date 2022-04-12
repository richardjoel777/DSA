package part3.sorting;

public class QuickSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high)
            return;
        var boundary = partition(a, low, high);

        sort(a, low, boundary - 1);
        sort(a, boundary + 1, high);
    }
    
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int boundary = low - 1;
        for (int i = low; i <= high; i++)
            if (a[i] <= pivot)
                swap(a, i, ++boundary);
        return boundary;
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
