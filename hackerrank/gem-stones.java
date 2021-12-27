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
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
    int[] l = new int[26];
    Set<Character> res = new HashSet<>();
    int flag=0;
    for(String s : arr)
    {
        Set<Character> temp = new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
             temp.add(s.charAt(i));
        }
        if(flag>0 && res.size()==0)
            return 0;
        if(flag==0)
        {
            res.addAll(temp);
            System.out.println(res);
            flag++;
        }
        else
        {
            res.retainAll(temp);
            System.out.println(res);
        }    
    }
    System.out.println(res);
    return res.size();
    }

}