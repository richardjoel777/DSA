package part3.sorting;

public class BubbleSort {
    public static void sort(int[] a) {
        boolean isSorted;
        for(int i=0;i<a.length - i;i++) 
        {
            isSorted = true;
            for(int j=1; j<a.length; j++)
            {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted)
                return;
        }
    }
}
