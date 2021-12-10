class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int a = 0;
        int i=0;
        int j=n-1;
        while(i<=j)
        {
            int h = Math.min(height[i], height[j]);
            a = Math.max(h*(j-i), a);
            if(height[i]<=height[j])
                i++;
            else
                j--;
        }
        return a;
    }
}