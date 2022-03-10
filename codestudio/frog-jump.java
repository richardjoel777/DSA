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