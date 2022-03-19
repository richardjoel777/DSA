/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int r = n, l=0;
        while(l<r)
        {
            int mid = l + (r-l)/2;
            int res = guess(mid+1);
            if(res == 0)
                return mid+1;
            if(res == 1)
                l = mid;
            else
                r = mid;
        }
        return r;
    }
}