import java.util.*;

public class Solution {
    
    public static int frogJump(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int j1 = prev1 + Math.abs(heights[i-1] - heights[i]);
            int j2 = Integer.MAX_VALUE;
            if(i>1)
                j2 = prev2 + Math.abs(heights[i-2] - heights[i]);
            int curr = Math.min(j1, j2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}


// import java.util.*;
// class TUF{
// static int solve(int ind,int[] height,int[] dp){
//     if(ind==0) return 0;
//     if(dp[ind]!=-1) return dp[ind];
//     int jumpTwo = Integer.MAX_VALUE;
//     int jumpOne= solve(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
//     if(ind>1)
//         jumpTwo = solve(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);
    
//     return dp[ind]=Math.min(jumpOne, jumpTwo);
// }


// public static void main(String args[]) {

//   int height[]={30,10,60 , 10 , 60 , 50};
//   int n=height.length;
//   int dp[]=new int[n];
//   Arrays.fill(dp,-1);
//   System.out.println(solve(n-1,height,dp));
// }
// }