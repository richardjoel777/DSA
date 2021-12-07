import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n=digits.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                        if(i!=j && i!=k && j!=k && digits[i]>0 && digits[k]%2==0)
                        {
                            int temp = digits[i]*100+digits[j]*10+digits[k];
                            if(!res.contains(temp))
                                res.add(temp);
                        }
                }
            }
        }
        Collections.sort(res);
        // System.out.println(res);
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }
}