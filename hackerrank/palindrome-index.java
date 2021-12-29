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
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
     
    public static boolean isPalindrome(String s)
    {
        int n=s.length();
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i) != s.charAt(n-1-i))
                return false;
        }
        return true;
    }

    public static int palindromeIndex(String s) {
    int n=s.length();
    int i=0,j=n-1;
    while(i<j)
    {
        if(s.charAt(i) != s.charAt(j))
        {
            boolean f = isPalindrome(s.substring(i+1,j+1));
            if(f)
                return i;
            return j;     
        }
        else
        {
            i++;
            j--;
        }
    }
    return -1;
    }

}