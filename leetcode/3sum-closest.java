public class Solution {
    public int threeSumClosest(int[] A, int B) {
        int minTillNow = Integer.MAX_VALUE;
        int res = -1;
        Arrays.sort(A);
        int n = A.length;
        for(int i = 0;i<n-2;i++)
        {
            int l = i+1;
            int r = n-1;
            while(l<r)
            {
                int sum = A[i]+A[l]+A[r];
                int diff = Math.abs(sum-B);
                if(diff < minTillNow)
                {
                    minTillNow = diff;
                    res = sum;
                }
                if(sum > B)
                    r--;
                else if(sum < B)
                    l++;
                else
                    return B;
                    
            }
        }
            
            return res;
        }
    }