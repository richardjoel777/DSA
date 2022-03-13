class Solution {
    
    int jump(int[] nums, int ind, int n, int[] dp){
        if(ind >= n-1)
            return 0;
        int maxi = n+1;
        
        if(dp[ind] != -1)
            return dp[ind];
        
        for(int i=1;i<=nums[ind];i++)
        {
            int tj = 1 + jump(nums, ind+i, n, dp);
            maxi = Math.min(maxi, tj);
        }
        return dp[ind] = maxi;
    }
    
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int res = jump(nums, 0, n, dp);
        return res;
    }
}