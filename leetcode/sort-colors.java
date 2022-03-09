class Solution {
    public void sortColors(int[] a) {
        int r = a.length - 1;
        int l = 0;
        int m = 0;
        int temp;
        while(m<=r)
        {
            if(a[m] == 0)
            {
                temp = a[l];
                a[l] = a[m];
                a[m] = temp;
                m++;
                l++;
            }
            else if(a[m] == 1)
            {
                m++;
            }
            else if(a[m] == 2)
            {
                temp = a[r];
                a[r] = a[m];
                a[m] = temp;
                r--;
            }
        }
    }
}