package part3.sorting;

public class MergeSort {
    public static void sort(int[] a) {
        if (a.length < 2)
            return;
        int mid = a.length / 2;
        int[] right = new int[mid];
        for (int i = 0; i < mid; i++)
            right[i] = a[i];
        int[] left = new int[a.length - mid];
        for (int i = mid; i < a.length; i++)
            left[i - mid] = a[i];
        sort(left);
        sort(right);

        merge(left, right, a);
    }
    
    private static void merge(int[] left, int[] right, int[] a)
    {
        int i = 0, j = 0, k = 0;
        while(i < right.length && j < left.length)
        {
            if (right[i] < left[j])
                a[k++] = right[i++];
            else
                a[k++] = left[j++];
        }
        while(i < right.length)
            a[k++] = right[i++];
        while(j < left.length)
            a[k++] = left[j++];
    }
}
