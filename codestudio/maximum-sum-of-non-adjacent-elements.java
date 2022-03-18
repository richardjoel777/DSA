import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
        int prev = nums.get(0);
        int prev1 = 0;
        for(int i=1;i<n;i++)
        {
            int take = nums.get(i);
            if(i>1)
                take += prev1;
            int notTake = 0 + prev;
            int curr = Math.max(take,notTake);
            prev1 = prev;
            prev = curr;
        }
        return prev;
	}
}

