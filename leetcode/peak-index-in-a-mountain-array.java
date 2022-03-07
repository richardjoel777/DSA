class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = -0, end = arr.length-1;
        int target = 0;
        while(start < end)
        {
            int mid = start + (end-start)/2;
            target = arr[mid+1];
            if(target < arr[mid])
            {
                end = mid;
            }
            else if(target > arr[mid])
            {
                start = mid+1;
            }
        }
        return end;
    }
}