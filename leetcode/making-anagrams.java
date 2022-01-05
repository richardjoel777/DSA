import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    int[] l1 = new int[26];
    int[] l2 = new int[26];
    int res = 0;
    for(int i=0;i<s1.length();i++)
    {
        l1[s1.charAt(i) - 'a']++;
    }
    for(int i=0;i<s2.length();i++)
    {
        l2[s2.charAt(i) - 'a']++;
    }
    for(int i=0;i<26;i++)
    {
        res += Math.abs(l1[i] - l2[i]);
    }
    return res;
    }

}
