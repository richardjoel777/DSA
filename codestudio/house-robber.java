import java.util.*;

public class Solution {
    
    public static long maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
        long prev = (long)nums.get(0);
        long prev1 = 0;
        for(int i=1;i<n;i++)
        {
            long take = (long)nums.get(i);
            if(i>1)
                take += (long)prev1;
            long notTake = 0 + prev;
            long curr = Math.max(take,notTake);
            prev1 = prev;
            prev = curr;
        }
        return prev;
	}
    
	public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if(n == 1)
            return valueInHouse[0];
        ArrayList<Integer> t1 = new ArrayList<>(n-1);
        ArrayList<Integer> t2 = new ArrayList<>(n-1);
        for(int i=0;i<n;i++)
        {
            if(i != 0)
                t1.add(valueInHouse[i]);
            if(i != n-1)
                t2.add(valueInHouse[i]);
        }
        return Math.max(maximumNonAdjacentSum(t1), maximumNonAdjacentSum(t2));
    }	
}