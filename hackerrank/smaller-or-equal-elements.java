import java.util.ArrayList;

public class Solution {

    int binarySearch(ArrayList<Integer> arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid-1, x);
            if (arr.get(mid) <= x)
                return binarySearch(arr, mid+1, r, x);
        }
        return l + (r - l) / 2;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = binarySearch(A, 0, A.size()-1, B);
        return count;
    }
}
