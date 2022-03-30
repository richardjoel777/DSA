class Solution {
    
    public boolean rowSearch(int[] a, int target) {
        int n = a.length;
        int r = n-1;
        int l = 0;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(a[mid] == target)
                return true;
            if(a[mid] > target)
                r = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] a, int target) {
        int n = a.length;
        int r = n-1;
        int l = 0;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(r == l)
                return rowSearch(a[r], target);
            if(a[mid][0] == target)
                return true;
            if(a[mid][0] < target && a[mid][a[mid].length-1]>=target)
                return rowSearch(a[mid], target);
            if(a[mid][0] > target)
                r = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
}