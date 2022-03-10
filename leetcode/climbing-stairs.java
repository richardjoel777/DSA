class Solution {
    
    public int climbStairs(int n) {
        if(n<= 1)
            return 1;
        if(n == 2)
            return 2;
        int prev = 1;
        int prev2 = 2;
        for(int i=3;i<=n;i++)
        {
            int cur = prev + prev2;
            prev = prev2;
            prev2 = cur;
        }
        return prev2;
    }
}