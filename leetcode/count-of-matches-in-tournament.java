class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        if(n == 1)
            return res;
        while(n != 2)
        {
            if(n%2 == 0)
            {
                n = n/2;
                res += n;
            }
            else
            {
                n = (n-1)/2+1;
                res += n-1;
            }
        }
        return res+1;
    }
}