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
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
    char prev = s.charAt(0);
    int res = 0;
    for(int i=1;i<s.length();i++)
    {
        if(s.charAt(i) == prev)
            res++;
        else
            prev = s.charAt(i);
    }
    return res;
    }

}