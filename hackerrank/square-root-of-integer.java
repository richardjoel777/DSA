public class Solution {
    public int sqrt(int A) {
        long r = A;
        while(r*r>A)
        {
            r = (r + A/r) / 2;
        }
        return (int)r;
    }
}

