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
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
    int t1,t2;
    int n = s.length();
    for(int i=1;i<n;i++)
    {
        t1 = Math.abs(s.charAt(i-1) - s.charAt(i));
        t2 = Math.abs(s.charAt(n-i-1) - s.charAt(n-i));
        if(t1!=t2)
            return "Not Funny";
    }
    
    return "Funny";
    
    }

}