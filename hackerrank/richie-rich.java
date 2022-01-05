import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
    StringBuilder res = new StringBuilder(s);
    for(int i=0,j=n-1;i<=j;i++,j--)
    {
        if(i == j && k>0)
            res.setCharAt(i, '9');
        if(s.charAt(i) == s.charAt(j) && s.charAt(j)!='9')
        {
            if(k>1)
            {
                res.setCharAt(i, '9');
                res.setCharAt(j, '9');
                k -= 2;
            }
        }
        else
        {
            if(k>1)
            {
               if(s.charAt(i) != '9')
               {
               res.setCharAt(i, '9');
               k--;
               }
               if(s.charAt(j) != '9')
               {
               res.setCharAt(j, '9');
               k--;
               }
            }
            else if(k>0)
            {
                if(s.charAt(i) > s.charAt(j))
                    res.setCharAt(j, s.charAt(i));
                else
                   res.setCharAt(i, s.charAt(j));
                k--;
            }
            else
                return "-1";
        }
    }
    
    return res.toString();
    
    }

}