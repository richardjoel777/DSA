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
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    int l = s.length();
    int[] a = new int[26];
    int flag = 0;
    for(int i=0;i<l;i++)
    {
        a[s.charAt(i) - 'a']++;
    }
    for(int i=0;i<26;i++)
    {
        if(a[i] % 2 != 0)
            flag++;
        if(flag > 1)
            return "NO";
    }
    return "YES";
    }

}
