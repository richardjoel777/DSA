package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'theLoveLetterMystery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int theLoveLetterMystery(String s) {
    int n = s.length();
    int res = 0;
    int t1,t2;
    for(int i=0;i<n/2;i++)
    {
        if(s.charAt(i) != s.charAt(n-1-i))
        {
            t1 = Math.max(s.charAt(i), s.charAt(n-1-i));
            t2 = Math.min(s.charAt(i), s.charAt(n-1-i));
            res+= t1-t2;
        }
    }
    return res;

    }

}